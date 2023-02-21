package com.example.EjercicioDos.controller;

import com.example.EjercicioDos.entidades.Laptop;
import com.example.EjercicioDos.repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {

    LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public LaptopRepository getLaptopRepository() {
        return laptopRepository;
    }

    public void setLaptopRepository(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptos")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }
}
