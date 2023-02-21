package com.example.EjerciciosLaptops;

import com.example.EjerciciosLaptops.entity.Laptop;
import com.example.EjerciciosLaptops.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjerciciosLaptopsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjerciciosLaptopsApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "HP");
		Laptop laptop2 = new Laptop(null, "Asus");
		Laptop laptop3 = new Laptop(null, "Acer");

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);
	}

}
