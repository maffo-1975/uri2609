package com.devsuperior.uri2609;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CategorySumProjection> list1 = repository.search1();
		System.out.println("\n*** RESULTADO SQL RAIZ:");
		list1.stream().map(x -> new CategorySumDTO(x)).forEach(System.out::println);

		System.out.println("\n\n");

		List<CategorySumDTO> list2 = repository.search2();
		System.out.println("\n*** RESULTADO JPQL:");
		list2.stream().forEach(System.out::println);
	}
}
