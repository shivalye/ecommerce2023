package com.telran.ecommerce.controller;

import com.telran.ecommerce.entity.Article;
import com.telran.ecommerce.exception.ArticleNotFoundException;
import com.telran.ecommerce.repository.ArticleRepository;
import com.telran.ecommerce.service.ArticleService;
import com.telran.ecommerce.util.ArticleGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;
    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @Autowired
    private ArticleService articlesService;
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable String id) {
        try {
            Article article = articlesService.getArticleById(id);
            return ResponseEntity.ok(article);
        } catch (ArticleNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/getByPage")
    public ResponseEntity<Page<Article>> getArticlesByPage(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "12") int pageSize) {

        Page<Article> articles = articlesService.getArticlesByPage(pageNumber, pageSize);
        return ResponseEntity.ok(articles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable String id) {
        try {
            articlesService.deleteArticleById(id);
            return ResponseEntity.ok("Article deleted successfully");
        } catch (ArticleNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Article not found");
        }
    }

    @GetMapping("/getAll")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/get3Latest")
    public List<Article> getLatestArticles() {
        return articleRepository.findTop3ByOrderByDateDesc();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addArticle() {
        Article article = ArticleGenerator.getRandomArticle();
        LocalDate date = LocalDate.parse(article.getDateAsString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        article.setDate(date);

        articleRepository.save(article);

        return ResponseEntity.ok("Article added successfully");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
