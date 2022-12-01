package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. ���� ȣ�Ⱑ���� ���α׷����� ���
@Controller
public class Hello {
	int iv = 10; // �ν��Ͻ� ����
	static int cv = 20; // static ����
	
	//2. URL�� �޼��带 ����
	@RequestMapping("/hello")
	private void main() { // �ν��Ͻ� �޼��� - iv, cv�� �Ѵ� ��밡��
		System.out.println(" Hello - privata "); // ��Ĺ �ֿܼ� �����
//		System.out.println(iv); //ok
		System.out.println(cv); //ok 
	}
	
	public static void main2() {// static �޼��� - cv�� ��밡��
//		System.out.println(iv); // ������
		System.out.println(cv); //ok

	}

}
//System.out.println > �ֿܼ� ���