package com.hdcoo.learningspring.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HelloWorld {

    private double random = Math.random();

    @Resource
    private Person man;

    @Resource
    private Person woman;

    public String eat(String sex, String food) {
        return selectSex(sex).eat(food);
    }

    public String sleep(String sex, int duration) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException err) {
            System.out.println(err.toString());
        }
        return selectSex(sex).sleep(duration);
    }

    public String sayHi(String name) {
        return sayHi() + " " + name;
    }

    public String sayHi() {
        return "Hi";
    }

    private Person selectSex(String sex) throws IllegalArgumentException {
        if ("man".equals(sex)) {
            return man;
        }

        if ("woman".equals(sex)) {
            return woman;
        }

        throw new IllegalArgumentException();
    }
}
