package com.example.helloapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                     // 아래 클래스가 rest api 처리함을 알림
@RequestMapping("/api")          // 주소 할당 : URL의 공통 부분
public class ApiController {

    @GetMapping("/hello")        // URL ; 동작 의미 : http://localhost:9090/api/hello
    public String hello() {
        return "hello SpringBoot!!!";
    }

    @GetMapping(path = "/hello-path")  // http://localhost:9090/api/get/hello-path
    public String getHello() {
        return "get Hello";
    }

    @GetMapping("/{name}")      // PathVariable 방식 : path명이 변하는 경우
    public String name(@PathVariable String name) {
        return name;
    }

    @GetMapping("/path-variable/{name}")      // PathVariable 방식 : path명이 변하는 경우
    public String pathVairable(@PathVariable String name) {
        return name;
    }

    @GetMapping("/path-name/{name}")      // PathVariable 방식 : path명을 다른 변수명(pathName)으로 선언
    public String pathName(@PathVariable(name = "name") String pathName) {
        return pathName;
    }

}
