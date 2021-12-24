package com.example.my_task.dao;

import com.example.my_task.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleDao extends CrudRepository<Article, Integer> {
}
