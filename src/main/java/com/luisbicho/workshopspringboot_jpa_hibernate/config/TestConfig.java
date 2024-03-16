package com.luisbicho.workshopspringboot_jpa_hibernate.config;

import com.luisbicho.workshopspringboot_jpa_hibernate.entities.Order;
import com.luisbicho.workshopspringboot_jpa_hibernate.entities.User;
import com.luisbicho.workshopspringboot_jpa_hibernate.entities.enums.OrderStatus;
import com.luisbicho.workshopspringboot_jpa_hibernate.repositories.OrderRepository;
import com.luisbicho.workshopspringboot_jpa_hibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User pedro = new User(null,"Pedro Bicho","pedro@gmail.com","92432424394","teste");
        User ines = new User(null,"Ines Fragoso","ines@gmail.com","924232294","teste");

        Order o1 = new Order(null, Instant.now(),OrderStatus.PAID,pedro);
        Order o2 = new Order(null,Instant.now(),OrderStatus.WAITING_PAYMENT,ines);

        userRepository.saveAll(Arrays.asList(pedro,ines));
        orderRepository.saveAll(Arrays.asList(o1,o2));

    }
}
