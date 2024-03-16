package com.luisbicho.workshopspringboot_jpa_hibernate.repositories;

import com.luisbicho.workshopspringboot_jpa_hibernate.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
