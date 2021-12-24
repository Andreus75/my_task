package com.example.my_task.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int user_id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Article> articles = new ArrayList<>(0);

    public User() {
    }

    public User(int user_id, String name, int age) {
        this.user_id = user_id;
        this.name = name;
        this.age = age;
    }

    public int getUser_id() {
        return user_id;
    }

    public User setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public User setArticles(List<Article> articles) {
        this.articles = articles;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", articles=" + articles +
                '}';
    }
}
