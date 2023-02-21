package com.example.EjerciciosLaptops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saludito")
    public String saludo() {
        return "Buenos días";
    }
}
