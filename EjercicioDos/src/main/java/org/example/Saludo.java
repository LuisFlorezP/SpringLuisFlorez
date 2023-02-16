package org.example;

import org.springframework.stereotype.Component;

@Component
public class Saludo {

    public Saludo() {
    }

    public String imprimirSaludo() {
        return "Hola querido amigo!";
    }
}
