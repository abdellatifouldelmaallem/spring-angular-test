package lu.atozdigital.api.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = true, updatable = false)
    private Long id;

    private Date date;

    @OneToMany(targetEntity = Article.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "articles_fk", referencedColumnName = "id")
    private List<Article> articles;


    public Orders() {
    }

    public Orders(List<Article> articles, Date date) {
        this.articles = articles;
        this.date = date;
    }

    public Orders(Long id, List<Article> articles, Date date) {
        this.id = id;
        this.articles = articles;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", articles=" + articles +
                ", date=" + date +
                '}';
    }
}
