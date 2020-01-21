package com.hdcoo.learningspring.service;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person {
    @Override
    public String eat(String food) {
        return "Share " + food + " with child";
    }

    @Override
    public String sleep(int duration) {
        return "Look after child";
    }
}
