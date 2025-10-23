package com.api.example.apiDemo.helloController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/hola")
    public String hola() {
        return "hola world";
    }

    @GetMapping("/namaste")
    public String namaste() {
        return "namaste world";
    }

}
