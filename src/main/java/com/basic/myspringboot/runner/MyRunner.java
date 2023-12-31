package com.basic.myspringboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
//가장 먼저 실행되게 설정 (숫자가 낮을수록 우선순위가 높음)
@Order(1)
public class MyRunner implements ApplicationRunner {
    @Value("${myboot.name}")   //springframework 의 value import
    private String name;

    @Value("${myboot.age}")
    private int age;

    @Value("${myboot.fullName}")
    private String fullName;

    @Autowired
    private Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Port Number = " + environment.getProperty("local.server.port"));
        System.out.println("myboot.name = " + name);
        System.out.println("myboot.age = " + age);
        System.out.println("myboot.fullName = " + fullName);
        System.out.println(">>>Git Test");

        System.out.println("VM Argument foo = " + args.containsOption("foo"));
        System.out.println("Program Argument bar = " + args.containsOption("bar"));

    }
}
