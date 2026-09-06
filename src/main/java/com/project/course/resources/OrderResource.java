package com.project.course.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.course.entities.Order;
import com.project.course.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
    private final OrderService orderService;

    public OrderResource(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orderList = orderService.findAll();

        return ResponseEntity.ok().body(orderList);
    }

    @GetMapping (value="/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = orderService.findById(id);

        return ResponseEntity.ok().body(order);
    }
}
