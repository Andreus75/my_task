package com.example.my_task.services.articleService;

import com.example.my_task.dao.ArticleDao;
import com.example.my_task.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDao articleDao;

    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public void saveArticle(Article article) {
        if (article != null) {
            articleDao.save(article);
        }
    }

    @Override
    public Optional<Article> findArticleById(int article_id) {
        return articleDao.findById(article_id);
    }

    @Override
    public List<Article> findAllArticle() {
        List<Article> articles = (List<Article>) articleDao.findAll();
        return articles;
    }

    @Override
    public void deleteArticleById(int article_id) {
        articleDao.deleteById(article_id);
    }
}
