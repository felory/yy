package com.ww.yy.controller;

import com.ww.yy.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Greeting ,%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting hi(@RequestParam(value="name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


}
