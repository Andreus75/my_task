package com.example.my_task.controllers;

import com.example.my_task.entity.Article;
import com.example.my_task.services.articleService.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/articles")
    public void createArticle(@RequestBody Article article) {
        System.out.println(article);
        articleService.saveArticle(article);
    }
}
