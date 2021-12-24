package com.example.my_task.entity;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int article_id;

    private String text;

    private Color color = Color.BLACK;

    //    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    public Article() {
    }

    public Article(int article_id, String text, Color color) {
        this.article_id = article_id;
        this.text = text;
        this.color = color;
    }

    public Article(int article_id, String text, Color color, User user) {
        this.article_id = article_id;
        this.text = text;
        this.color = color;
        this.user = user;
    }

    public int getArticle_id() {
        return article_id;
    }

    public Article setArticle_id(int article_id) {
        this.article_id = article_id;
        return this;
    }

    public String getText() {
        return text;
    }

    public Article setText(String text) {
        this.text = text;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Article setColor(Color color) {
        this.color = color;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Article setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", text='" + text + '\'' +
                ", color=" + color +
                ", user=" + user +
                '}';
    }
}
