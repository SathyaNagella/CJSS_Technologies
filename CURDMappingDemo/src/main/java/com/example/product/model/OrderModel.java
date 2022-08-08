package com.example.product.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderModel {
private Long orderId;
private String userId;
private String productId;
private Long orderQty;
private String orderStatus;
}
