package com.luisbicho.workshopspringboot_jpa_hibernate.resources;

import com.luisbicho.workshopspringboot_jpa_hibernate.entities.User;
import com.luisbicho.workshopspringboot_jpa_hibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

     @Autowired
     private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User luis = new User(null,"Luis Bicho","luis@gmail.com","924934394","teste");
        User maria = new User(null,"Maria Santos","maria@gmail.com","9249333394","teste");
        List<User> list = Arrays.asList(luis,maria);
        return ResponseEntity.ok().body(list);
    }

}
