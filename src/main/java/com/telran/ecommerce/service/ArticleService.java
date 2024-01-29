package com.telran.ecommerce.service;
import com.telran.ecommerce.entity.Article;
import com.telran.ecommerce.exception.ArticleNotFoundException;
import com.telran.ecommerce.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void addArticleIfNotExists(Article article) {
        String id = article.getId();

        if (!articleRepository.existsById(id)) {
            articleRepository.save(article);
        }
    }

    public void deleteArticleById(String id) {
        articleRepository.deleteById(id);
    }

    public Page<Article> getArticlesByPage(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("date").descending());
        return articleRepository.findAll(pageRequest);
    }

    public Article getArticleById(String id) throws ArticleNotFoundException {
        Optional<Article> optionalArticle = articleRepository.findById(id);

        if (optionalArticle.isPresent()) {
            return optionalArticle.get();
        } else {
            throw new ArticleNotFoundException("Article not found with ID: " + id);
        }
    }
}
