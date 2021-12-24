package com.example.my_task.controllers;

import com.example.my_task.entity.Article;
import com.example.my_task.entity.Color;
import com.example.my_task.entity.User;
import com.example.my_task.services.articleService.ArticleService;
import com.example.my_task.services.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private final UserService userService;
    private final ArticleService articleService;

    public UserController(UserService userService, ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }

    @ResponseBody
    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userService.findAllUsers();
        return users;
    }

    @ResponseBody
    @GetMapping("/users/age/filter")
    public List<User> getFilterUsers(int a) {
        List<User> users = userService.findAllUsers();
        List<User> usersFilter = users.stream().filter(user -> user.getAge() >= a).collect(Collectors.toList());
        return usersFilter;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @ResponseBody
    @GetMapping("/users/article_color/filter")
    public Set<User> getFilterArticleUsers(Color color) {
        Set<User> fUsers = new HashSet<>();
        List<User> users = userService.findAllUsers();
        List<Article> articles = articleService.findAllArticle();
        List<Article> filterArticle = articles.stream().filter(article -> article.getColor().equals(color)).collect(Collectors.toList());

        for (User user : users) {
            for (Article article : filterArticle) {
                if (user.getUser_id() == article.getUser().getUser_id()) {
                    fUsers.add(user);
                }
            }
        }
        return fUsers;
    }

    @ResponseBody
    @GetMapping("/users/articleCount/filter")
    public Set<User> getFilterArticleCountUsers() {
        Set<User> fUsers = new HashSet<>();
        List<User> users = userService.findAllUsers();
        List<Article> articles = articleService.findAllArticle();

        for (User user : users) {
            int count = 0;
            for (Article article : articles) {
                if (user.getUser_id() == article.getUser().getUser_id()) {
                    count++;
                }
            }
            if (count > 3) {
                fUsers.add(user);
            }
        }
        return fUsers;
    }
}
