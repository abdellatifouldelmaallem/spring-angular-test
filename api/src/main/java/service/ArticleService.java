package service;

import DTO.ArticleDTO;
import entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ArticleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public ArticleDTO getArticleById( Integer id){
        Optional<Article> articleDTOOptional = articleRepository.findById(id);
        return ArticleDTO.toDto(articleDTOOptional.get());
    }

    public List<ArticleDTO> getAllArticles(){
        return (List<ArticleDTO>) ArticleDTO.toDto((Article) articleRepository.findAll());
    }

    public ArticleDTO saveArticle(ArticleDTO articleDTO){
        return ArticleDTO.toDto(articleRepository.save(Article.toEntity(articleDTO)));
    }


}
