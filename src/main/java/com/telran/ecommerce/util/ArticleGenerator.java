package com.telran.ecommerce.util;

import com.telran.ecommerce.entity.Article;
import com.telran.ecommerce.repository.ArticleRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArticleGenerator {

    private static final String[] TITLES = {"How to make a busy bathroom a place to relax", "Another Title", "One More Title"};
    private static final String[] AUTHORS = {"Henrik Annemark", "Bob Annemark", "Author 3"};
    private static final String[] TEXTS = {"<p>Your bathroom serves a string of busy functions on a daily basis. See how you can make all of them work, and still have room for comfort and relaxation.</p>\n" +
            "<h3>A cleaning hub with built-in ventilation</h3>\n" +
            "<p>Use a rod and a shower curtain to create a complement to your cleaning cupboard. Unsightly equipment is stored out of sight yet accessibly close – while the air flow helps dry any dampness.</p>",
            "<h3>Storage with a calming effect</h3>\n" +
                    "<p>Having a lot to store doesn’t mean it all has to go in a cupboard. Many bathroom items are better kept out in the open – either to be close at hand or are nice to look at. Add a plant or two to set a calm mood for the entire room (and they’ll thrive in the humid air).</p>\n" +
                    "<h3>Kit your clutter for easy access</h3>\n" +
                    "<p>Even if you have a cabinet ready to swallow the clutter, it’s worth resisting a little. Let containers hold kits for different activities – home spa, make-up, personal hygiene – to bring out or put back at a moment’s notice.</p>",
            "<h3>Make your mop disappear</h3>\n" +
                    "<p>Having your cleaning tools organized makes them easier to both use and return to. When they’re not needed, close the curtain and feel the peace of mind it brings.</p>"
    };
    private static final String[] IMAGES = {"img1", "img2", "img3"};
    private static final boolean[] FEATURED_OPTIONS = {false, true, false};

    public static List<Article> getRandomArticles(int count) {
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Article article = getRandomArticle();
            articles.add(article);
        }

        return articles;
    }

    public static Article getRandomArticle() {
        Random random = new Random();

        int randomIndex = random.nextInt(TITLES.length);
        String title = TITLES[randomIndex];

        randomIndex = random.nextInt(AUTHORS.length);
        String author = AUTHORS[randomIndex];

        int numTexts = TEXTS.length;
        String[] text = new String[numTexts];
        for (int i = 0; i < numTexts; i++) {
            text[i] = TEXTS[i];
        }

        int numImages = IMAGES.length;
        String[] images = new String[numImages];
        for (int i = 0; i < numImages; i++) {
            images[i] = IMAGES[i];
        }

        LocalDate date = getRandomDate();

        boolean featured = FEATURED_OPTIONS[random.nextInt(FEATURED_OPTIONS.length)];

        return new Article(title, author, text, images, date, featured);
    }


    private static LocalDate getRandomDate() {
        Random random = new Random();
        int year = getRandomNumber(2022, 2023);
        int month = getRandomNumber(1, 12);
        int day = getRandomNumber(1, 28);

        return LocalDate.of(year, month, day);
    }

    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void generateAndSaveRandomArticles(int count, ArticleRepository articleRepository) {
        List<Article> articles = getRandomArticles(count);
        articleRepository.saveAll(articles);
    }
}
