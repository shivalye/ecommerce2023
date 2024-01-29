package com.telran.ecommerce;

import com.telran.ecommerce.entity.Article;
import com.telran.ecommerce.repository.ArticleRepository;
import com.telran.ecommerce.util.ArticleGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class ArticleCreateAppl {

    private static final long N_ARTICLE = 36;

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(ArticleCreateAppl.class, args);

        ArticleRepository articleRepository = cac.getBean(ArticleRepository.class);
        List<Article> articles = ArticleGenerator.getRandomArticles((int) N_ARTICLE);

        articles.forEach(article -> {
            System.out.println("Saving article: " + article);
            articleRepository.save(article);
        });

        System.out.println("Articles saved successfully!");
    }
}
