package com.telran.ecommerce.service;

import com.telran.ecommerce.entity.Article;
import com.telran.ecommerce.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testAddArticleIfNotExists() {
        // Создаем новую статью для добавления
        Article newArticle = new Article();
        newArticle.setId("testId");
        newArticle.setTitle("Test Article");
        newArticle.setAuthor("Test Author");
        newArticle.setText(new String[]{"Test text"});
        newArticle.setImages(new String[]{"test_image.jpg"});
        newArticle.setDate(LocalDate.now());
        newArticle.setFeatured(true);

        // Мокируем репозиторий, чтобы избежать взаимодействия с реальной базой данных
        when(articleRepository.existsById("testId")).thenReturn(false);
        when(articleRepository.save(any(Article.class))).thenReturn(newArticle);

        // Вызываем метод добавления статьи
        articleService.addArticleIfNotExists(newArticle);

        // Проверяем, что статья была успешно добавлена
        verify(articleRepository, times(1)).save(any(Article.class));
    }

    @Test
    void testDeleteArticleById() {
        // Идентификатор статьи, которую нужно удалить
        String articleId = "testId";

        // Мокируем репозиторий, чтобы избежать взаимодействия с реальной базой данных
        doNothing().when(articleRepository).deleteById(articleId);

        // Вызываем метод удаления статьи
        articleService.deleteArticleById(articleId);

        // Проверяем, что метод deleteById был вызван ровно 1 раз
        verify(articleRepository, times(1)).deleteById(articleId);
    }

    @Test
    void testGetArticlesByPage() {
        // Номер страницы и размер страницы для теста
        int pageNumber = 0;
        int pageSize = 12;

        // Мокируем репозиторий, чтобы избежать взаимодействия с реальной базой данных
        when(articleRepository.findAll(any(PageRequest.class))).thenReturn(Page.empty());

        // Вызываем метод получения статей постранично
        Page<Article> result = articleService.getArticlesByPage(pageNumber, pageSize);

        // Проверяем, что результат не равен null
        assertNotNull(result);
    }
}
