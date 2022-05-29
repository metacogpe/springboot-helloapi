package com.example.helloapi.controller;

import com.example.helloapi.dto.CustomerRequestDto;
import com.example.helloapi.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController                     // 아래 클래스가 rest api 처리함을 알림
@RequestMapping("/api")          // 주소 할당 : URL의 공통 부분
public class ApiController {

    @GetMapping("/hello")        // URL ; 동작 의미 : http://localhost:9090/api/hello
    public String hello() {
        return "hello SpringBoot!!!";
    }

    @GetMapping(path = "/hello-path")  // http://localhost:9090/api/hello-path
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

    // Query parameter
    // ?key1=value1?key2=value2
    // http://localhost:9090/api/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")     //
    public String queryParma(@RequestParam Map<String, String> queryParam) {  //key=value 형태이므로, Map활용 ; queryParam 변수에 key/value로 받기

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {   // queryParam.entrySet().forEach()에 대해 entry로 리턴하는 entrySet() 활용 ; 람다식
            System.out.println(entry.getKey());     // 리턴된 키
            System.out.println(entry.getValue());   // 리턴된 value
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    @GetMapping(path = "query-param-fixed")  // 명시적으로 query parameters를 지정하는 방법
    public String queryParamFixed(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        return name+" "+email+" "+age;
    }

    // 명시적으로 query parameters를 객체(UserRequest)를 활용하여 정의 : 실무에서 주로 사용하여 추
    @GetMapping(path = "query-param-fixed-multi")
    public String queryParamFixedMulti(UserRequest userRequest) {

        return userRequest.toString();
    }

    // POST
    @PostMapping("/users")
        /*
        {
          "account":"user01",
          "email":"abc@gmail.com",
          "address":"seoul"
        }
    */
    public void user(@RequestBody  Map<String, Object> postRequestData) {

        postRequestData.forEach((key, value) -> {  //forEach recommended by IntelliJ
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        });
    }

    @PostMapping("/customers")  // POST with dto
    public void userDto(@RequestBody CustomerRequestDto postRequestData) {

        System.out.println(postRequestData);
    }
}
