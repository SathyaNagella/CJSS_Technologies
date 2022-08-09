package com.example.product.service;
import com.example.product.entity.*;
import com.example.product.model.AdminModel;
import com.example.product.model.OrderModel;
import com.example.product.model.ProductModel;
import com.example.product.model.UserModel;
import com.example.product.repository.AdminRepository;
import com.example.product.repository.OrderRepository;
import com.example.product.repository.ProductRepository;
import com.example.product.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    public List<ProductModel> getProducts() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        List<ProductModel> productModelList = new ArrayList<>();
        productEntityList.forEach(productEntity -> {
            ProductModel productModel = new ProductModel();
            BeanUtils.copyProperties(productEntity, productModel);
            productModelList.add(productModel);
        });
        return productModelList;
    }

    public String checkAdmin(String adminId, Long password) {
        Optional<AdminEntity> adminEntity = adminRepository.findById(adminId);

        if (!adminEntity.isPresent()) {
            return "Admin Not Available";
        } else if ((adminEntity.get().getAdminId().equals(adminId)) && (adminEntity.get().getAdminMobileNo().toString().equals(password.toString()))) {
            return "Login Successful";
        } else
            return "Invalid Admin";
    }

    public String saveAdmin(AdminModel adminModel) {
        AdminEntity adminEntity = new AdminEntity();
        BeanUtils.copyProperties(adminModel, adminEntity);
        if (adminRepository.existsById(adminEntity.getAdminId())) {
            return "Admin already exist";
        }
        adminEntity.setRole("admin");
        //adminEntity.setAdminMobileNo(passwordEncoder.encode(adminModel.getAdminMobileNo()));
        adminEntity.setAdminName(encoder.encode(adminModel.getAdminName()));
        System.out.println(adminModel);
        adminRepository.save(adminEntity);
        return "Admin added Successfully";
    }

    public String saveProduct(ProductModel productModel) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productModel, productEntity);
        productRepository.saveAndFlush(productEntity);
        return productEntity.getProductId() + "Saved Successfully";
    }

    public String delete(String productId) {
        productRepository.deleteById(productId);
        return productId + " Deleted Successfully";
    }

    public ProductModel updateAdd(String editId) {
        ProductEntity productEntity = productRepository.getReferenceById(editId);
        //productRepository.deleteById(editId);
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productEntity, productModel);
        return productModel;
    }
//    public String updateProduct(ProductModel productModel){
//        ProductEntity productEntity=new ProductEntity();
//        BeanUtils.copyProperties(productModel,productEntity);
//        productRepository.saveAndFlush(productEntity);
//        return "updated successfully";
//    }

    public String checkUser(String userId, String userPassword) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);

        if (!userEntity.isPresent()) {
            return "User Not Available";
        } else if ((userEntity.get().getUserId().equals(userId)) && (userEntity.get().getUserPassWord().toString().equals(userPassword.toString()))) {
            return "Login Successful";
        } else
            return "Invalid Password";
    }

    public String saveUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userModel, userEntity);
        if (userRepository.findById(userEntity.getUserId()).isPresent()) {
            return userEntity.getUserId() + " already exists Successfully";
        }else {
            userRepository.save(userEntity);
            return userEntity.getUserId() + " User Saved Successfully";
        }
    }

    public String placeOrder(String orderId,String userId) {
        List<ProductModel> productModelList = getProducts();
        ProductEntity productEntity = new ProductEntity();
        ProductModel productModel = productModelList.stream().filter(fi -> fi.getProductId().equals(orderId)).findFirst().get();
        Integer stockSize = (Integer) productModel.getSkuEntity().getSkuStock();
         if(stockSize<1) {
           return " Out Of Stock ";
        }else {
            SKUEntity skuEntity = productModel.getSkuEntity();
            skuEntity.setSkuStock(stockSize - 1);
            productModel.setSkuEntity(skuEntity);
            BeanUtils.copyProperties(productModel, productEntity);

            OrderEntity orderEntity=new OrderEntity();
            if(orderEntity.getOrderQty()==null){
                orderEntity.setOrderQty(0L);
            }
            Long qyt = orderEntity.getOrderQty();
            orderEntity.setUserId(userId);
            orderEntity.setOrderQty(qyt+1);
            orderEntity.setOrderStatus("Ordered");
            orderEntity.setProductId(orderId);
            orderRepository.save(orderEntity);
            productRepository.saveAndFlush(productEntity);
            return " placed Successfully ";
        }
    }

    public List<ProductModel> searchProduct(String productCategory){
        List<ProductModel> searchProductsList=getProducts().stream().filter(data->data.getProductCategory().equals(productCategory)).collect(Collectors.toList());
        return searchProductsList;
    }
    public List<OrderModel> getOrders(String userId){
        List<OrderEntity> orderEntityList=orderRepository.findAllByUserId(userId);
        List<OrderModel> orderModelList=new ArrayList<>();
        orderEntityList.forEach(data->{
            OrderModel orderModel=new OrderModel();
            BeanUtils.copyProperties(data,orderModel);
            orderModelList.add(orderModel);
        });
        return orderModelList;
    }
    public String deleteOrder(Long orderId){
        Optional<OrderEntity> orderEntity=orderRepository.findById(orderId);
        orderEntity.get().setOrderStatus("Cancelled");
        orderRepository.saveAndFlush(orderEntity.get());
        //orderRepository.deleteById(orderId);
        Optional<ProductEntity> productEntity=productRepository.findById(orderEntity.get().getProductId());
        int qty=productEntity.get().getSkuEntity().getSkuStock();
        productEntity.get().getSkuEntity().setSkuStock(qty+1);
        productRepository.saveAndFlush(productEntity.get());
        return orderId+" OrderId Canceled Successfully";
    }
}
