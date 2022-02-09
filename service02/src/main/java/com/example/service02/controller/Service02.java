package com.example.service02.controller;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service01")
public interface Service02 {

    @GetMapping("/aa")
    Response cc();
}
