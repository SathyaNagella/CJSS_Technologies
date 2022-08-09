package com.example.demo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartModel {
    private Long cartId;
    private String name;
    private List<Items> items=new ArrayList<>();
}
