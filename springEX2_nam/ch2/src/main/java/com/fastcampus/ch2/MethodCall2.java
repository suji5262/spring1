package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

public class MethodCall2 {
	public static void main(String[] args) throws Exception{
		
		//1. YoilTellerMVC 의 객체를 생성
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		//2. main 메서드의 정보를 가져온다
		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class); // 오버로딩 될 수 있으니 다 적어야함
		
		//3. madel을 생성
		Model model = new BindingAwareModelMap(); // 모델의 구현체 > 인터페이스라 객체생성 불가능
		System.out.println("[before] model="+model);
		
		//4. main 메서드를 호출 - invoke 메서드를 사용
		// String viewName = obj.main(2021, 10, 1, model); // 아래 줄과 동일(Reflection API를 호출안할 때)
		String viewName = (String)main.invoke(obj, new Object[] { 2021, 10, 1, model }); // reflection API를 호출	
		// obj 객체에 대한 main 메서드 호출/ obj 배열은(갯수가 달라질 수 있음) = 매개변수
		System.out.println("viewName="+viewName);	
		
		// Model의 내용을 출력 
		System.out.println("[after] model="+model);
				
		// 텍스트 파일을 이용한 rendering
		render(model, viewName);			
	} // main
	
	static void render(Model model, String viewName) throws IOException {
		String result = "";
		
		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File("src/main/webapp/WEB-INF/views/"+viewName+".jsp"), "utf-8");
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. model을 map으로 변환 
		Map map = model.asMap();
		
		// 3.key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 4. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", ""+map.get(key));
		}
		
		// 5.렌더링 결과를 출력한다.
		System.out.println(result);
	}
}

// Reflection API 이용해 컨트롤럴 생성 → 메서드 호출
