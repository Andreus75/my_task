package com.example.my_task.services.articleService;

import com.example.my_task.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    void saveArticle(Article article);
    Optional<Article> findArticleById(int article_id);
    List<Article> findAllArticle();
    void deleteArticleById(int article_id);
}
