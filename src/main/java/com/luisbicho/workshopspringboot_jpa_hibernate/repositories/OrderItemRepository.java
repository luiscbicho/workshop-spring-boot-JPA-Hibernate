package com.luisbicho.workshopspringboot_jpa_hibernate.repositories;

import com.luisbicho.workshopspringboot_jpa_hibernate.entities.OrderItem;
import com.luisbicho.workshopspringboot_jpa_hibernate.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
