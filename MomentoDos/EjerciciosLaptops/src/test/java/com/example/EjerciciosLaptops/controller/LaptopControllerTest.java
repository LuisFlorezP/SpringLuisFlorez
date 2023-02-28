package com.example.EjerciciosLaptops.controller;

import com.example.EjerciciosLaptops.entity.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;
    private final Logger logger = LoggerFactory.getLogger(LaptopController.class);

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Buscar todos los registros")
    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println("Registros: " + laptops.size());
        logger.info("El proceso finaliza correctamente.");
    }

    @DisplayName("Buscar un único registro")
    @Test
    void findAllOneById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        logger.info("El proceso finaliza correctamente.");
    }

    @DisplayName("Crear nuevo registro")
    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                        "marca": "Apple"
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();
        assertEquals(1L, result.getId());
        assertEquals("Apple", result.getMarca());
    }

    @DisplayName("Actualizar un registro")
    @Test
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                        "marca": "Apple"
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        String json2 = """
                {
                        "marca": "Apple Nuevo"
                }
                """;
        HttpEntity<String> request2 = new HttpEntity<>(json2, headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();
        assertEquals(1L, result.getId());
        assertEquals("Apple", result.getMarca());
    }

    @DisplayName("Eliminar un único registro")
    @Test
    void delete() {
    }

    @DisplayName("Eliminar todos los registros")
    @Test
    void deleteAll() {
    }
}