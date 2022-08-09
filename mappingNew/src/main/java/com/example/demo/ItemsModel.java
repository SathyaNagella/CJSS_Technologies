package com.example.demo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemsModel {
    private Long itemsId;
    private String serialNumber;
    private Cart cart;
}
