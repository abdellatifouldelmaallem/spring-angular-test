package entity;

import DTO.ArticleDTO;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Table(name = "Article")
@Entity
@Data
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, updatable = false, nullable = false)
    private Integer id;
    @Column(name = "name", length = 250)
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "picture", length = 250)
    private  String picture;

    public static Article toEntity(ArticleDTO articleDTO){
        return Article.builder()
                .id(articleDTO.getId())
                .name(articleDTO.getName())
                .price(articleDTO.getPrice())
                .picture(articleDTO.getPicture())
                .build();
    }

    public Article() {
    }

    public Article(Integer id, String name, Double price, String picture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
    }

    public Article(String name, Double price, String picture) {
        this.name = name;
        this.price = price;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                '}';
    }
}
