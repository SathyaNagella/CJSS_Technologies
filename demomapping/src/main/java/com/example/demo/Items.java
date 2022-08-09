package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Items {
     @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
     private String serialNumber;
     @ManyToOne
     @JoinColumn(name = "cart_id")
     private Cart cart;

    public Items() {}

    public Items(String serialNumber, Cart cart) {
        this.serialNumber = serialNumber;
        this.cart = cart;
    }
}
