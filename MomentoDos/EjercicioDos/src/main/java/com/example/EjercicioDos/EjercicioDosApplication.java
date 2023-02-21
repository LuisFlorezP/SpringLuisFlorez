package com.example.EjercicioDos;

import com.example.EjercicioDos.entidades.Laptop;
import com.example.EjercicioDos.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjercicioDosApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioDosApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "HP", 2022, "SSD", 3, 2.55 );
		Laptop laptop2 = new Laptop(null, "Asus", 2023, "Mecánico", 2, 2.34 );
		Laptop laptop3 = new Laptop(null, "Acer", 2021, "Duro", 1, 2.77 );

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);
	}
}
