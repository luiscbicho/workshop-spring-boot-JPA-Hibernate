package com.luisbicho.workshopspringboot_jpa_hibernate.resources;

import com.luisbicho.workshopspringboot_jpa_hibernate.entities.User;
import com.luisbicho.workshopspringboot_jpa_hibernate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

     @Autowired
     private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User>list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<User> update(@RequestBody User user,@PathVariable Integer id){
        user = userService.update(user,id);
        return ResponseEntity.ok().body(user);
    }

}
