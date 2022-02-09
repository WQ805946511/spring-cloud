package com.example.service02.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(value = "service01")
public interface Service01 {
    @GetMapping("/aa")
    String aa();
}
