package com.example.my_task.init;

import com.example.my_task.dao.ArticleDao;
import com.example.my_task.dao.UserDao;
import com.example.my_task.entity.Article;
import com.example.my_task.entity.Color;
import com.example.my_task.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private final UserDao userDao;
    private final ArticleDao articleDao;

    @Autowired
    public DataInit(UserDao userDao, ArticleDao articleDao) {
        this.userDao = userDao;
        this.articleDao = articleDao;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = userDao.count();
        long count2 = articleDao.count();

        if (count == 0 && count2 == 0) {
            User user1 = new User(1, "Ivan", 23);
            User user2 = new User(2, "Ira", 21);
            User user3 = new User(3, "Igor", 21);
            User user4 = new User(4, "Nastya", 30);
            User user5 = new User(5, "Kolya", 33);

            userDao.save(user1);
            userDao.save(user2);
            userDao.save(user3);
            userDao.save(user4);
            userDao.save(user5);

            Article article1 = new Article(1, "chemistry", Color.BLACK);
            Article article2 = new Article(2, "physics", Color.GRAY);
            Article article3 = new Article(3, "maths", Color.BLACK);
            Article article4 = new Article(4, "history", Color.BLACK);
            Article article5 = new Article(5, "physical", Color.BLACK);
            Article article6 = new Article(6, "computer science", Color.RED);
            Article article7 = new Article(7, "biology", Color.RED);
            Article article8 = new Article(8, "java", Color.RED);
            Article article9 = new Article(9, "node", Color.RED);
            Article article10 = new Article(10, "js", Color.GREEN);

            article1.setUser(user1);
            article2.setUser(user2);
            article3.setUser(user3);
            article4.setUser(user4);
            article5.setUser(user5);
            article6.setUser(user1);
            article7.setUser(user3);
            article8.setUser(user4);
            article9.setUser(user3);
            article10.setUser(user1);

            articleDao.save(article1);
            articleDao.save(article2);
            articleDao.save(article3);
            articleDao.save(article4);
            articleDao.save(article5);
            articleDao.save(article6);
            articleDao.save(article7);
            articleDao.save(article8);
            articleDao.save(article9);
            articleDao.save(article10);
        }
    }
}
