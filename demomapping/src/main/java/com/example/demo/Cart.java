package com.example.demo;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    @OneToMany(mappedBy = "cart" ,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Items> items=new ArrayList<>();

    public Cart() {}

    public Cart(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setItems(List<Items> items) {this.items = items;}
}
