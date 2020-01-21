package com.hdcoo.learningspring.service;

import org.springframework.stereotype.Component;

@Component
public class Man implements Person {
    @Override
    public String eat(String food) {
        return "Eating " + food;
    }

    @Override
    public String sleep(int duration) {
        return "sleep " + duration;
    }
}
