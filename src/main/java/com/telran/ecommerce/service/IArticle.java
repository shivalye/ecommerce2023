package com.telran.ecommerce.service;

import com.telran.ecommerce.entity.Article;
import com.telran.ecommerce.types.Code;
import com.telran.ecommerce.types.Shipping;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.UUID;

public interface IArticle {

    Article getArticle(UUID articleId);
    UUID addArticle(String img, String title, String text, Date date);
    Code removeArticle(UUID articleId);
    Code updateArticle(UUID articleId, String img, String title, String text, Date date);

}



