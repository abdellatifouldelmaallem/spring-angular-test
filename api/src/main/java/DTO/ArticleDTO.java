package DTO;

import entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
    private Integer id;
    private String name;
    private Double price;
    private  String picture;

    public static ArticleDTO toDto(Article entity){
        return ArticleDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .picture(entity.getPicture())
                .build();
    }
}
