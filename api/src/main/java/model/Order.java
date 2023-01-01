package model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Reference", unique=true, nullable=false,updatable = false)
    private String id = UUID.randomUUID().toString();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Article articles;

    @Column(name="date", unique=true, nullable=false)
    private LocalTime date;

    public Order() {
    }

    public Order(Article articles, LocalTime date) {
        this.articles = articles;
        this.date = date;
    }

    public Order(String id, Article articles, LocalTime date) {
        this.id = id;
        this.articles = articles;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Article getArticles() {
        return articles;
    }

    public void setArticles(Article articles) {
        this.articles = articles;
    }

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", articles=" + articles +
                ", date=" + date +
                '}';
    }
}
