package com.luisbicho.workshopspringboot_jpa_hibernate.config;

import com.luisbicho.workshopspringboot_jpa_hibernate.entities.User;
import com.luisbicho.workshopspringboot_jpa_hibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User pedro = new User(null,"Pedro Bicho","pedro@gmail.com","92432424394","teste");
        User ines = new User(null,"Ines Fragoso","ines@gmail.com","924232294","teste");

        userRepository.saveAll(Arrays.asList(pedro,ines));

    }
}
