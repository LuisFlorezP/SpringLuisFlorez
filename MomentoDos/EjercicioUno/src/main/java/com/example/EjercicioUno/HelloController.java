package com.example.EjercicioUno;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saludar")
    public String saludar() {
        return "Buenas noches people.";
    }
}
