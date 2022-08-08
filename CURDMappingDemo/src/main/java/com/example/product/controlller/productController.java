package com.example.product.controlller;
import com.example.product.entity.SKUEntity;
import com.example.product.model.AdminModel;
import com.example.product.model.ProductModel;
import com.example.product.model.UserModel;
import com.example.product.service.ProductService;
import com.example.product.validator.AdminValidator;
import com.example.product.validator.ProductValidator;
import com.example.product.validator.SKUValidator;
import com.example.product.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

@Controller
public class productController {

    @Autowired
    ProductService productService;
    @Autowired
    AdminValidator adminValidator;
    @Autowired
    UserValidator userValidator;
    @Autowired
    SKUValidator skuValidator;
    @Autowired
    ProductValidator productValidator;
    SKUEntity skuEntityClass=new SKUEntity();
    ProductModel productModelClass=new ProductModel();
    String userId="";

    @GetMapping("/start")
    public String choice(){
    return "choice";
}
    @GetMapping("/admin")
    public String adminCon(){
    return "admin";
}
    @PostMapping("/adminCheck")
    public String checkAdmin(@Valid @RequestParam("adminId") String adminId,@RequestParam("password") Long password, Model model){
        String result=productService.checkAdmin(adminId,password);
        if(result.equals("Login Successful")){
        model.addAttribute("message",result);
        return "CURD";
        }else{
            model.addAttribute("message",result);
        return "admin";}
    }
    @GetMapping("/New Admin")
    public String newAdmin(Model model){
        AdminModel adminModel=new AdminModel();
        model.addAttribute("adminModel",adminModel);    //adminCheck
        return "addAdmin";
    }
    @PostMapping("/saveAdmin")
    public String saveAdmin(@Valid @ModelAttribute("adminModel") AdminModel adminModel,BindingResult bindingResult,Model model){
        adminValidator.validate(adminModel,bindingResult);
        if(bindingResult.hasErrors()){
            return "addAdmin";
        }
        model.addAttribute("message",productService.saveAdmin(adminModel));
        return "CURD";
    }
    @GetMapping("/getProducts")
    public String getProducts(Model model){
        model.addAttribute("productsModelList",productService.getProducts());
        return "viewProducts";
    }
    @GetMapping("/Add Products")
    public String addProduct(Model model){
        ProductModel productModel=new ProductModel();
        model.addAttribute("productModel",productModel);
        return "addProducts";
    }
    @PostMapping("/saveProducts")
    public String saveProducts(@Valid @ModelAttribute("productModel") ProductModel productModel,BindingResult bindingResult,Model model){
        productModel.setSkuEntity(skuEntityClass);
        productValidator.validate(productModel,bindingResult);
        if(bindingResult.hasErrors()){
            return "addProducts";
        }
        model.addAttribute("productMessage",productService.saveProduct(productModel));
        return "redirect:getProducts";
    }
    @GetMapping("/curd")
    public String getCurdPage(){
    return "CURD";
}

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") String id,Model model) {
        System.out.println(id);
        model.addAttribute("message", productService.delete(id));
        return "redirect:getProducts";
    }

//<a href="editProduct?editId=${product.productId}"> Edit Product</a>
    @GetMapping("/editProduct")
    public String editProduct(/*@RequestParam("editId") String editId*/Model model){
        model.addAttribute("productModel",productService.updateAdd(productModelClass.getProductId()));
        return "editProduct";
    }
    @PostMapping("/updateProduct")
    public String updateProduct(@Valid @ModelAttribute("productModel") ProductModel productModel,BindingResult bindingResult,Model model){
        productModel.setSkuEntity(skuEntityClass);
        productValidator.validate(productModel,bindingResult);
        if(bindingResult.hasErrors())
            return "editProduct";
        else {
            model.addAttribute("message",productService.saveProduct(productModel));
            }
       // return "order";
        return "redirect:getProducts";
    }

    @GetMapping("/user")
    public String userLogin(){
    return "user";
}
    @PostMapping("/userCheck")
        public String userCheck(@RequestParam("userId") String userId,@RequestParam("userPassword") String userPassword,Model model){
        String result=productService.checkUser(userId,userPassword);
        if(result.equals("Login Successful")) {
            model.addAttribute("message",result);
            this.userId=userId;
            return "userCURD";
        }
        else{
            model.addAttribute("message",result);
            return "user";
        }
    }
    @GetMapping("/New User")
    public String newUser(Model model){
        UserModel userModel=new UserModel();
        model.addAttribute("userModel",userModel);
        return "newUser";
    }
    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("userModel") UserModel userModel,BindingResult bindingResult,Model model){
        userValidator.validate(userModel,bindingResult);
        if(bindingResult.hasErrors())
            return "newUser";
        model.addAttribute("message",productService.saveUser(userModel));
        return "user";
    }
    @GetMapping("/viewProducts")
    public String viewProduct(Model model){
        model.addAttribute("userModelList",productService.getProducts());
        return "viewUserProducts";
    }
    @GetMapping("/home")
    public String home(){
    return "userCURD";
}


//======sku=======
    @GetMapping("/Add SKU")
    public String addSku(Model model){
        SKUEntity skuEntity=new SKUEntity();
        model.addAttribute("SkuObj",skuEntity);
        return "SkuAdd";
    }

    @PostMapping("/saveSku")
    public String saveSku(@Valid @ModelAttribute("SkuObj")SKUEntity skuEntity ,BindingResult bindingResult,Model model){
        skuValidator.validate(skuEntity,bindingResult);
        if(bindingResult.hasErrors())
            return "SkuAdd";
        skuEntityClass=skuEntity;
        model.addAttribute("SkuDataObj",skuEntity);
        return "redirect:Add Products";
    }
    @GetMapping("/placeOrder")
    public String placeOrder(@RequestParam("orderId") String orderId,Model model){
        model.addAttribute("message",productService.placeOrder(orderId,userId));
        return "userCURD";
    }

    @GetMapping("/EDIT")
    public String edit(@RequestParam("editId") String editId,Model model){
        productModelClass=productService.updateAdd(editId);
        model.addAttribute("skuEditObj",productModelClass.getSkuEntity());
        return "editSKU";
    }

    @PostMapping("/updateSku")
    public String updateSku(@Valid @ModelAttribute("skuEditObj") SKUEntity skuEditObj,BindingResult bindingResult,Model model){
        skuValidator.validate(skuEditObj,bindingResult);
        if(bindingResult.hasErrors())
            return "editSKU";

            this.skuEntityClass = skuEditObj;
        return "redirect:editProduct";
    }

    @PostMapping("/searchProducts")
    public String searchProducts(@RequestParam("productCategory") String productCategory,Model model){
        model.addAttribute("userModelList",productService.searchProduct(productCategory));
        return "viewUserProducts";
    }
    @GetMapping("/viewOrders")
    public String viewOrders(Model model){
        model.addAttribute("orderProductList",productService.getOrders(userId));
        return "viewOrders";
    }
    @GetMapping("/ordersPage")
    public String ordersPage(){
    return "userCURD";
}
    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("orderId") Long orderId,Model model){
        model.addAttribute("message",productService.deleteOrder(orderId));
        return "userCURD";
    }
}