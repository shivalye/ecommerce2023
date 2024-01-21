package com.telran.ecommerce;

import com.telran.ecommerce.entity.Article;
import com.telran.ecommerce.repository.ArticleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class ArticleRestoreAppl
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext cac =
                SpringApplication.run(ArticleRestoreAppl.class, args);

        ArticleRepository articleRepository = cac.getBean(ArticleRepository.class);
        List<Article> articleList;
        articleList = articleRepository.findAll();
        articleList.forEach(System.out::println);

    }
}
