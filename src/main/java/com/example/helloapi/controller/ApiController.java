package com.example.helloapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                     // 아래 클래스가 rest api 처리함을 알림
@RequestMapping("/api")          // URL의 공통 부분
public class ApiController {

    @GetMapping("/hello")        // URL ; 동작 의미 : htp://localhost:9090/api/hello
    public String hello() {
        return "hello SpringBoot!!!";
    }

    @GetMapping("/{name}")      // PathVariable 방식 : path명이 변하는 경우
    public String name(@PathVariable String name) {
        return name;
    }
}
