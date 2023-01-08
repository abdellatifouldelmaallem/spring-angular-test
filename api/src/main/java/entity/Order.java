package entity;

import DTO.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "Order")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Reference", unique=true, nullable=false,updatable = false)
    private String id = UUID.randomUUID().toString();

    @OneToMany(targetEntity = Article.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Order_fk", referencedColumnName = "id")
    private List<Article> articleList;

    @Column(name="date", unique=true, nullable=false)
    private LocalTime date;

    public static Order toEntity(OrderDTO orderDTO){
        return  Order.builder()
                .id(orderDTO.getId())
                .articleList(orderDTO.getArticleList())
                .date(orderDTO.getDate())
                .build();
    }

    public Order(List<Article> articleList, LocalTime date) {
        this.articleList = articleList;
        this.date = date;
    }
}
