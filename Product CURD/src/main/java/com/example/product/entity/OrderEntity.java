package com.example.product.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private String userId;
    private String productId;
    @NotNull(message = "mustNotBeNull")
    private Long orderQty;
    private String orderStatus;
}
