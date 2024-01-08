package com.telran.ecommerce.repository;

import com.telran.ecommerce.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String>
{
    List<Article> findTop3ByOrderByDateDesc();
    List<Article> findTopNByOrderByDateDesc(int n);
}

