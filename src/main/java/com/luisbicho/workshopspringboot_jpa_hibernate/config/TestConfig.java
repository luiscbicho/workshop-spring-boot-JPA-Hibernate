package com.luisbicho.workshopspringboot_jpa_hibernate.config;

import com.luisbicho.workshopspringboot_jpa_hibernate.entities.*;
import com.luisbicho.workshopspringboot_jpa_hibernate.entities.enums.OrderStatus;
import com.luisbicho.workshopspringboot_jpa_hibernate.repositories.*;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User pedro = new User(null,"Pedro Bicho","pedro@gmail.com","92432424394","teste");
        User ines = new User(null,"Ines Fragoso","ines@gmail.com","924232294","teste");

        Order o1 = new Order(null, Instant.now(),OrderStatus.PAID,pedro);
        Order o2 = new Order(null,Instant.now(),OrderStatus.WAITING_PAYMENT,ines);

        userRepository.saveAll(Arrays.asList(pedro,ines));
        orderRepository.saveAll(Arrays.asList(o1,o2));

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat1);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3));

        Payment pay1 = new Payment(null,Instant.now(),o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);



    }
}
