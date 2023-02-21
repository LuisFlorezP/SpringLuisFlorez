package com.example.EjerciciosLaptops.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  marca;

    public Laptop() {
    }

    public Laptop(Long id, String marca) {
        this.id = id;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Laptop:" +
                    "\n - Id = " + id +
                        "\n - Marca = " + marca;
    }
}
