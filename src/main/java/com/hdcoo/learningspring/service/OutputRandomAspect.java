package com.hdcoo.learningspring.service;

import java.lang.reflect.Field;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OutputRandomAspect {

    @Before("execution(* com.hdcoo.learningspring.service.HelloWorld.*(..))")
    public void before(JoinPoint point) {
        Object target = point.getTarget();
        Class targetClass = target.getClass();
        Field[] fs = targetClass.getDeclaredFields();

        for (Field f : fs) {
            if(f.getName().equals("random")) {
                try {
                    f.setAccessible(true);
                    double value = (double) f.get(target);
                    System.out.println(value);
                    break;
                } catch (IllegalAccessException err) {
                    System.out.println(err.toString());
                }
            }
        }
    }
}
