package com.project.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.course.entities.Order;
import com.project.course.repositories.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        List<Order> orderList = orderRepository.findAll();

        return orderList;
    }

    public Order findById(Long id){
        Optional<Order> order = orderRepository.findById(id);

        return order.get();
    }
}
