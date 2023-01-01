package DTO;

import entity.Article;
import entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String id = UUID.randomUUID().toString();
    private List<Article> articleList;
    private LocalTime date;

    public static OrderDTO toDTO(Order order){
        return OrderDTO.builder()
                .id(order.getId())
                .articleList(order.getArticleList())
                .date(order.getDate())
                .build();
    }
}
