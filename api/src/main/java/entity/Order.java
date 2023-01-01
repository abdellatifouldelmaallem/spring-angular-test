package entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Reference", unique=true, nullable=false,updatable = false)
    private String id = UUID.randomUUID().toString();

    @OneToMany(targetEntity = Article.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Order_fk", referencedColumnName = "id")
    private List<Article> articleList;

    @Column(name="date", unique=true, nullable=false)
    private LocalTime date;

    public Order() {
    }

    public Order(List<Article> articleList, LocalTime date) {
        this.articleList = articleList;
        this.date = date;
    }

    public Order(String id, List<Article> articleList, LocalTime date) {
        this.id = id;
        this.articleList = articleList;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
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
                ", articleList=" + articleList +
                ", date=" + date +
                '}';
    }
}
