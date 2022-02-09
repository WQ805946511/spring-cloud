package com.example.service02.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class Test {
/*    @Autowired
    private Service01 service01;

    @GetMapping("/aa")
    public String aa() {
        return service01.aa();
    }*/

    @PostMapping("/dd")
    public String dd(@RequestBody String params) {
        JSONObject jsonObject = JSONObject.parseObject(params);
        return jsonObject.toString();
    }
}
