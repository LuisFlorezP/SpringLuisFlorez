package com.example.EjercicioDos.entidades;

import jakarta.persistence.*;

@Entity
@Table (name = "latops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private Integer year;
    private String disco;
    private Integer nucleo;
    private double velocidad;

    public Laptop() {
    }

    public Laptop(Long id, String marca, Integer year, String disco, Integer nucleo, double veocidad) {
        this.id = id;
        this.marca = marca;
        this.year = year;
        this.disco = disco;
        this.nucleo = nucleo;
        this.velocidad = velocidad;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public Integer getNucleo() {
        return nucleo;
    }

    public void setNucleo(Integer nucleo) {
        this.nucleo = nucleo;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setValocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Laptop:" +
                    "\n - Id = " + id +
                        "\n - Marca = " + marca +
                            "\n - Year = " + year +
                                "\n - Disco = " + disco +
                                    "\n - Nucleo = " + nucleo +
                                        "\n - Velocidad = " + velocidad;
    }
}
