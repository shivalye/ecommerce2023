package com.telran.ecommerce.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID articleId;
    @Setter
    private String img;
    @Setter
    private String title;
    @Setter
    private String text;
    @Setter
    private Date date;

    public Article(String img, String title, String text, Date date) {
        this.img = img;
        this.title = title;
        this.text = text;
        this.date = date;
    }

}
