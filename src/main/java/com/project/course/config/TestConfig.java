package com.project.course.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.course.entities.User;
import com.project.course.repositories.UserRepository;

@Configuration
@Profile ("test")
public class TestConfig implements CommandLineRunner{
    private UserRepository userRepository;

    public TestConfig(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas Lima", "lucas@email.com", "9999-9999", "d1sa23");
        User u2 = new User(null, "Felipe Lima", "felipe@email.com", "8888-8888", "d1fh56");
        User u3 = new User(null, "Carlos Silva", "carlos@email.com", "7777-7777", "j64yg");
        User u4 = new User(null, "Fabiana Santos", "fabiana@email.com", "6666-6666", "er5tre65");
        User u5 = new User(null, "Ana Carolina", "ana@email.com", "5555-5555", "v1x541vc");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
    }
}
