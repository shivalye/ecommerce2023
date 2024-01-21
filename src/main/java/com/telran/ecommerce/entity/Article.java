package com.telran.ecommerce.entity;

import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "articles")
public class Article {

    @Id
    private String id;
    private String title;
    private String author;
    private String[] text;
    private String[] images;
    private LocalDate date;
    private boolean featured;

    public Article(String title, String author, String[] text,
                   String[] images, LocalDate date, boolean featured) {

        this.title = title;
        this.author = author;
        this.text = text;
        this.images = images;
        this.date = date;
        this.featured = featured;
    }

    public String getDateAsString() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
