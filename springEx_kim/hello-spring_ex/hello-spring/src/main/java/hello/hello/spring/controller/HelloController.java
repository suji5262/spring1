package hello.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc (@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
// 여기까지 실행하면 에러가 나는데 밑에 로그를 보고 > WARN(워링) > 문제점을 찾아라! >
// Required request parameter 'name' for method parameter type String is not present(오류메세지) > Required 라는 옵션이 빠졌다

    @GetMapping("hello-string")
    @ResponseBody  // http > 헤더부, 바디부 > 바디부에 데이터를 직접 넣어주겠음
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name; // "hello spring" > 뷰 이런게 없고 문자가 그대로 내려감
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
    }
}






