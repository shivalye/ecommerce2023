package com.telran.ecommerce.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Document(collection = "articles")
public class Article {
   @Id
    private int index;
    private String title;
    private String author;
    private String[] text;
    private String[] images;
    private Date date;
    private boolean featured;

    public Article(int index, String title, String author, String[] text,
                   String[] images, Date date, boolean featured)
    {
        this.index = index;
        this.title = title;
        this.author = author;
        this.text = text;
        this.images = images;
        this.date = date;
        this.featured = featured;
    }
}
