package com.project.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.course.entities.Category;
import com.project.course.entities.Order;
import com.project.course.entities.User;
import com.project.course.entities.enums.OrderStatus;
import com.project.course.repositories.CategoryRepository;
import com.project.course.repositories.OrderRepository;
import com.project.course.repositories.UserRepository;

@Configuration
@Profile ("test")
public class TestConfig implements CommandLineRunner{
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository){
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User use1 = new User(null, "Lucas Lima", "lucas@email.com", "9999-9999", "d1sa23");
        User use2 = new User(null, "Felipe Lima", "felipe@email.com", "8888-8888", "d1fh56");
        User use3 = new User(null, "Carlos Silva", "carlos@email.com", "7777-7777", "j64yg");
        User use4 = new User(null, "Fabiana Santos", "fabiana@email.com", "6666-6666", "er5tre65");
        User use5 = new User(null, "Ana Carolina", "ana@email.com", "5555-5555", "v1x541vc");

        Order ord1 = new Order(null, Instant.parse("2000-05-20T09:15:23Z"), OrderStatus.PAID, use1);
        Order ord2 = new Order(null, Instant.parse("2005-05-26T12:27:51Z"), OrderStatus.SHIPPED, use2);
        Order ord3 = new Order(null, Instant.parse("2002-09-30T22:48:41Z"), OrderStatus.CANCELED, use1);
        Order ord4 = new Order(null, Instant.parse("2007-01-21T13:53:59Z"), OrderStatus.DELIVERED, use4);
        Order ord5 = new Order(null, Instant.parse("2014-12-25T17:02:27Z"), OrderStatus.WAITING_PAYMENT, use3);

        Category cat1 = new Category(null, "ELETRONICO");
        Category cat2 = new Category(null, "RELOGIO");
        Category cat3 = new Category(null, "A PROVA DAGUA");
        Category cat4 = new Category(null, "PC");
        Category cat5 = new Category(null, "NOTEBOOK");
        Category cat6 = new Category(null, "MONITOR");

        userRepository.saveAll(Arrays.asList(use1, use2, use3, use4, use5));
        orderRepository.saveAll(Arrays.asList(ord1, ord2, ord3, ord4, ord5));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
    }
}
