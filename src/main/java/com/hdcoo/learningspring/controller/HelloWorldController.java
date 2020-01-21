package com.hdcoo.learningspring.controller;

import com.hdcoo.learningspring.service.HelloWorld;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloWorldController {

    @Resource
    private HelloWorld helloWorld;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        return helloWorld.sayHi(name);
    }

    @RequestMapping("/eat")
    public String eat(@RequestParam String sex, @RequestParam String food) {
        return helloWorld.eat(sex, food);
    }

    @RequestMapping("/sleep")
    public String sleep(@RequestParam String sex, @RequestParam int duration) {
        return helloWorld.sleep(sex, duration);
    }

}
