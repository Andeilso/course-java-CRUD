package com.project.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.course.entities.Order;
import com.project.course.entities.User;
import com.project.course.repositories.OrderRepository;
import com.project.course.repositories.UserRepository;

@Configuration
@Profile ("test")
public class TestConfig implements CommandLineRunner{
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository){
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas Lima", "lucas@email.com", "9999-9999", "d1sa23");
        User u2 = new User(null, "Felipe Lima", "felipe@email.com", "8888-8888", "d1fh56");
        User u3 = new User(null, "Carlos Silva", "carlos@email.com", "7777-7777", "j64yg");
        User u4 = new User(null, "Fabiana Santos", "fabiana@email.com", "6666-6666", "er5tre65");
        User u5 = new User(null, "Ana Carolina", "ana@email.com", "5555-5555", "v1x541vc");

        Order o1 = new Order(null, Instant.parse("2000-05-20T09:15:23Z"), u1);
        Order o2 = new Order(null, Instant.parse("2005-05-26T12:27:51Z"), u2);
        Order o3 = new Order(null, Instant.parse("2002-09-30T22:48:41Z"), u1);
        Order o4 = new Order(null, Instant.parse("2007-01-21T13:53:59Z"), u4);
        Order o5 = new Order(null, Instant.parse("2014-12-25T17:02:27Z"), u3);

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));
    }
}
