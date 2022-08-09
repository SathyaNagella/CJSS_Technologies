package com.example.demo;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;
    private String name;
    @OneToMany(mappedBy = "cart" ,cascade = CascadeType.ALL)//,orphanRemoval = true
    private List<Items> items=new ArrayList<>();

    public Cart() {}

    public Cart(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setItems(List<Items> items) {this.items = items;}

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getName() {
        return name;
    }


    public Cart(Long cartId, String name, List<Items> items) {
        this.cartId = cartId;
        this.name = name;
        this.items = items;
    }

    public List<Items> getItems() {
        return items;
    }
}
