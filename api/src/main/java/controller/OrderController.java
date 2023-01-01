package controller;

import DTO.ArticleDTO;
import DTO.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.ArticleRepository;
import repository.OrderRepository;
import service.ArticleService;
import service.OrderService;

import java.util.List;

@RequestMapping
public class OrderController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private OrderService orderService;


    //     endpoints for Articles  =============
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

    //     endpoints for Orders  =============
    @GetMapping("/orders")
    public List<OrderDTO> getAllOrder(){
        return orderService.getAllOrder();
    }

    @PostMapping("/saveOder")
    public OrderDTO saveOrder(@RequestBody OrderDTO orderDTO){
        return orderService.saveOrder(orderDTO);
    }

    @PutMapping("/updateOreder")
    public String updateOrder(OrderDTO orderDTO){
        orderService.updateOrder(orderDTO);
        return "order updete succefuly";
    }

    @GetMapping("/orders/{id}")
    public OrderDTO getOrderById(@PathVariable("id") String ref){
        return orderService.getOrderById(ref);
    }

}
