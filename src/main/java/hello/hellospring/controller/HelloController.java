package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //문자반환
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
        //http://localhost:8080/hello-string?name=spring!!!!
        //소스보기 하면 hello spring!!! 만 나오고 ResponseBody 에 그대로 써준다
        //템플릿 엔진으로 조작이 아니라 그대로 데이터를 내려주는 방식
    }

    //객체반환
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();//cmd + shift + enter (자동완성 종료)
        hello.setName(name);
        return hello;
        //객체가 반환되면 JSON 으로 출력 (JsonConverter) cf:StringConverter
        //http://localhost:8080/hello-api?name=spring!!!!
    }

    static class Hello {
        private String name;

        //getter setter 방식, propertie 접근방식, 자바빈 규약
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
