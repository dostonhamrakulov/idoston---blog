package com.asosiy.idoston.controller;

import com.asosiy.idoston.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String mainPage(){
        return "Site is under development!";
    }

    @RequestMapping("/greeting")
    public Hello greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Hello(counter.incrementAndGet(),
                String.format(template, name));
    }
}
