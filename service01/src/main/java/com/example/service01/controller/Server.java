package com.example.service01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Server {
    @GetMapping("/aa")
    public String aa() {
        return "aa";
    }
}
