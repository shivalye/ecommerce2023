package com.telran.ecommerce.service;
import com.telran.ecommerce.entity.Article;
import com.telran.ecommerce.types.Code;
import org.springframework.data.domain.Page;
import java.time.LocalDate;
public interface IArticle {

    Article getArticle(int articleId);
    int addArticle(String img, String title, String text, LocalDate date);
    Code removeArticle(int articleId);
    Code updateArticle(int articleId, String img, String title, String text, LocalDate date);
    Page<Article> getArticlesByPage(int pageNumber, int pageSize);

}



