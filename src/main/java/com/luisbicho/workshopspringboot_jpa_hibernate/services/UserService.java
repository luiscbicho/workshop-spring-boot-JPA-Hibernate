package com.luisbicho.workshopspringboot_jpa_hibernate.services;

import com.luisbicho.workshopspringboot_jpa_hibernate.entities.User;
import com.luisbicho.workshopspringboot_jpa_hibernate.repositories.UserRepository;
import com.luisbicho.workshopspringboot_jpa_hibernate.services.exceptions.DatabaseException;
import com.luisbicho.workshopspringboot_jpa_hibernate.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()->new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void deleteById(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(User newUser, Integer id){
        User user = (userRepository.findById(id)).orElseThrow(()-> new ResourceNotFoundException(id));
        updateData(user,newUser);
        return userRepository.save(user);

    }

    private void updateData(User user, User newUser) {
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPhone(newUser.getPhone());

    }

}
