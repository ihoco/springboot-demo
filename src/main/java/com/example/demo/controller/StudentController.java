package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StudentController{


    @GetMapping("/students")
    public Map<String, String> hello(){
        // 这里返回一个简单的学生名字列表，模拟数据
        return Map.of("message", "Hello, SpringBoot!");
    }
}

