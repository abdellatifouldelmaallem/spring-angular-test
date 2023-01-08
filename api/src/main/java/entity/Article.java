package entity;

import DTO.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Article")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article implements Serializable {
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

    public Article(String name, Double price, String picture) {
        this.name = name;
        this.price = price;
        this.picture = picture;
    }

}
