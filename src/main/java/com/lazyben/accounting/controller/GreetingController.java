package com.lazyben.accounting.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam("name") String name) {
        return "Hello " + name;
    }
}
