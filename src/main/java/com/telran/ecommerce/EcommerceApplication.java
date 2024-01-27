package com.telran.ecommerce;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import com.telran.ecommerce.repository.ArticleRepository;
import com.telran.ecommerce.util.ArticleGenerator;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Legant-ecommerce", description = "Furniture Store service"))
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);

	}

	@Bean
	public CommandLineRunner initDatabase(ArticleRepository articleRepository) {
		return args -> {
			if (articleRepository.count() == 0) {
				ArticleGenerator.generateAndSaveRandomArticles(36, articleRepository);
			} else {
				System.out.println("Articles are already present in the database.");
			}
		};
	}
}
