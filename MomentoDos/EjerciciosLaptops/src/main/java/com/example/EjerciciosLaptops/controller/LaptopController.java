package com.example.EjerciciosLaptops.controller;

import com.example.EjerciciosLaptops.entity.Laptop;
import com.example.EjerciciosLaptops.repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        System.out.println("Mostrando listado completo de laptops.");
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findAllOneById(@PathVariable Long id) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if (laptopOpt.isPresent()) {
            System.out.println("Laptop encontrada.");
            return ResponseEntity.ok(laptopOpt.get());
        } else {
            System.out.println("Laptop NO encontrada.");
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get(("User-Agent")));
        if (laptop.getId() != null) {
            System.out.println("El ID ya se encuentra en uso.");
            return ResponseEntity.badRequest().build();
        }
        System.out.println("Laptop creada.");
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            System.out.println("La laptop no existe.");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            System.out.println("La laptop no se encuentra.");
            return ResponseEntity.notFound().build();
        }
        System.out.println("Laptop actualizada.");
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {
        if (!laptopRepository.existsById(id)) {
            System.out.println("La laptop no existe.");
            return ResponseEntity.notFound().build();
        }
        System.out.println("Libro eliminado.");
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll() {
        System.out.println("Libros eliminados.");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
