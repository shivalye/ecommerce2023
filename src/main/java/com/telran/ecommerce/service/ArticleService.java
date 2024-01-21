package com.telran.ecommerce.service;

import com.telran.ecommerce.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.telran.ecommerce.repository.ArticleRepository;

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
}
