package com.telran.ecommerce.controller;

import com.telran.ecommerce.entity.Article;
import com.telran.ecommerce.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;
    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/getAll")
    public List<Article> getAllArticles() {
        return articleRepository.findAll(); // Возвращает все статьи из базы данных
    }

    @GetMapping("/get3Latest")
    public List<Article> getLatestArticles() {
        return articleRepository.findTop3ByOrderByDateDesc();
    }
    @GetMapping("/getLatest")
    public List<Article> getLatestArticles(@RequestParam int count) {
        return articleRepository.findTopNByOrderByDateDesc(count);
    }
}
