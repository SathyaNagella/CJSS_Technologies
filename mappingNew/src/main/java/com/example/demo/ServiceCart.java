package com.example.demo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCart {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ItemsRepository itemsRepository;
    public String saveCart(CartModel cartModel){
        if(cartModel==null){
            return "cart model not entered";
        }
        else {
            Cart cart=new Cart();
            BeanUtils.copyProperties(cartModel,cart);
            cartRepository.save(cart);
            return "Cart saved successfully";
        }
    }

    public List<CartModel> getAll(){

        List<Cart> cartList=cartRepository.findAll();
        List<CartModel > cartModelList=new ArrayList<>();

        cartList.forEach(cart -> {
            CartModel cartModel=new CartModel();
            BeanUtils.copyProperties(cart,cartModel);
            cartModelList.add(cartModel);
        });
        return cartModelList;
    }
    public String saveItems(ItemsModel itemsModel,Long CartId){
        Items items=new Items();
        BeanUtils.copyProperties(itemsModel,items);//convert

        Optional<Cart> cart=cartRepository.findById(CartId);//cart entity
        items.setCart(cart.get());

        List<Items> itemsList1= new ArrayList<>();
        itemsList1.add(items);

        cart.get().setItems(itemsList1);


        cartRepository.save(cart.get());
        return "Item saved Successfully";
    }
    public List<ItemsModel> carDelars(){
        List<Items> itemsList=itemsRepository.findAll();
        List<ItemsModel> itemsModelList=new ArrayList<>();
        itemsList.forEach(items -> {
            ItemsModel itemsModel=new ItemsModel();
            BeanUtils.copyProperties(items,itemsModel);
            itemsModelList.add(itemsModel);
        });
        return itemsModelList;
    }
}
