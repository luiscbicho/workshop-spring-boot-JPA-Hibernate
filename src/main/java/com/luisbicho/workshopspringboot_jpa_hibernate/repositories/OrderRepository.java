package com.luisbicho.workshopspringboot_jpa_hibernate.repositories;

import com.luisbicho.workshopspringboot_jpa_hibernate.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
