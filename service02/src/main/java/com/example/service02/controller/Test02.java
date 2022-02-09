package com.example.service02.controller;

import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test02 {
    @Autowired
    private Service02 service02;

    @GetMapping("/cc")
    public String aa() {
        Response cc = service02.cc();
        System.out.println(cc);
        System.out.println("--------");
        System.out.println(cc.body());
        return "aa";
    }
}
