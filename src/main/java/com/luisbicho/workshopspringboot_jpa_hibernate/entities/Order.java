package com.luisbicho.workshopspringboot_jpa_hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luisbicho.workshopspringboot_jpa_hibernate.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Instant moment;
    private Integer status;

    @OneToOne(mappedBy="order",cascade = CascadeType.ALL)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name="client_id")
    private User client;


    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> orderItems = new HashSet<>();


    public Order() {
    }

    public Order(Integer id, Instant moment,OrderStatus status, User client) {
        this.id = id;
        this.moment = moment;
        setStatus(status);
        this.client=client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        if(status != null){
            this.status=status.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal() {
        double sum=0.0;
        for(OrderItem x:orderItems) {
            sum+=x.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
