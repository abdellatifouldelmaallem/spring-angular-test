package service;

import DTO.ArticleDTO;
import DTO.OrderDTO;
import entity.Article;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

   public List<OrderDTO> getAllOrder(){
       return (List<OrderDTO>) OrderDTO.toDTO((Order) orderRepository.findAll());
   }

   public OrderDTO saveOrder(OrderDTO orderDTO){
       return OrderDTO.toDTO(orderRepository.save(Order.toEntity(orderDTO)));
   }

    public OrderDTO updateOrder(OrderDTO orderDTO){
        return OrderDTO.toDTO(orderRepository.save(Order.toEntity(orderDTO)));
    }

    public OrderDTO getOrderById(String reference){
        Optional<Order> orderOptional = orderRepository.findById(reference);
        return OrderDTO.toDTO(orderOptional.get());
    }
}
