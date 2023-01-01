package controller;

import DTO.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.ArticleRepository;
import repository.OrderRepository;
import service.ArticleService;

import java.util.List;

@RequestMapping
public class OrderController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles/{id}")
    public ArticleDTO getArticleById(@PathVariable("id") Integer id){
        return articleService.getArticleById(id);
    }

    @GetMapping("/articles")
    public List<ArticleDTO> getAllArticles(){
        return articleService.getAllArticles();
    }

    @PostMapping("/saveArticle")
    public ArticleDTO saveArticle(@RequestBody ArticleDTO articleDTO){
        return articleService.saveArticle(articleDTO);
    }
}
