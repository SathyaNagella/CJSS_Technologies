package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class controller {
    @Autowired
    ServiceCart serviceCart;
    public Long CartID=0L;
    @RequestMapping(" ")
    public String first(){
        return "first";
    }
    @GetMapping("/AddCart")
    public String addCart(Model model){
    CartModel cartModel=new CartModel();
        model.addAttribute("cartModel",cartModel);
        return "addCart";
    }
    @PostMapping("/saveCart")
    public String saveCart(@ModelAttribute("cartModel") CartModel cartModel,Model model){
        model.addAttribute("message",serviceCart.saveCart(cartModel));
        return "next";
    }
    @GetMapping("/viewCart")
    public String viewCart(Model model){
        model.addAttribute("cartList",serviceCart.getAll());
        return "next";
    }

    @GetMapping("/AddItems")
    public String addItems(@RequestParam("cartId") Long cartId, Model model){
        CartID=cartId;
        ItemsModel itemsModel=new ItemsModel();
        model.addAttribute("itemsModel",itemsModel);
        return "addItems";
    }
    @PostMapping("/saveItems")
    public String saveItems(@ModelAttribute("itemsModel") ItemsModel itemsModel,Model model){
        model.addAttribute("message",serviceCart.saveItems(itemsModel,CartID));
        return "first";
    }
    @GetMapping("/viewCartItems")
    public String viewAllCartItems(Model model){
        model.addAttribute("CarDelarsList",serviceCart.carDelars());
        return "cartitem";
    }
}
