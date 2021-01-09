package com.lazyben.accounting.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable(value = "name") String name) {
        return "Hello " + name;
    }
}
