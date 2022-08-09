package com.example.springvalidator.service;

import com.example.springvalidator.entity.CustomerEntity;
import com.example.springvalidator.model.CustomerModel;
import com.example.springvalidator.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Service
public class Service_Imple_Class implements ServiceInterface{
    @Autowired
    CustomerRepository customerRepository;
    List<CustomerModel> customerModelList=new LinkedList<>();
    @Override
    public String saveCustomer(CustomerModel customerModel) {
        if(customerRepository.findById(customerModel.getCusId()).isPresent()){
            return "Customer Already Exist";
        }
        CustomerEntity customerEntity=new CustomerEntity();
        BeanUtils.copyProperties(customerModel,customerEntity);
        customerRepository.save(customerEntity);
        return "Customer Added Successfully";
    }

    @Override
    public List<CustomerModel> getAllCustomers() {
        List<CustomerModel> CustomerModelList=new ArrayList<>();

        List<CustomerEntity> customerEntityList=customerRepository.findAll();
        customerEntityList.forEach(customerEntity->{
            CustomerModel customer=new CustomerModel();
            BeanUtils.copyProperties(customerEntity,customer);
            CustomerModelList.add(customer);
        });
        return CustomerModelList;
    }

//    public List<CustomerModel> getCustomerByCity(String name){
//        List<CustomerModel> customerModelList1=new ArrayList<>();
//        List<CustomerEntity> customerEntities=customerRepository.findByCity(name);
//        customerEntities.forEach(customerEntity -> {
//            CustomerModel customerModel=new CustomerModel();
//            BeanUtils.copyProperties(customerEntity,customerModel);
//            customerModelList1.add(customerModel);
//        });
//        return customerModelList1;
//    }

    @Override
    public String delete(Integer cusNo) {
       customerRepository.deleteById(cusNo);
        return cusNo+" Customer Deleted Successfully";
    }

    @Override
    public CustomerModel updateAdd(Integer cusNo) {
        CustomerEntity customerEntity=customerRepository.getReferenceById(cusNo);
        customerRepository.deleteById(cusNo);
        CustomerModel customerModel=new CustomerModel();
        BeanUtils.copyProperties(customerEntity,customerModel);
        return customerModel;
    }

    @Override
    public List<CustomerModel> getSearchData(String data){
       List<CustomerEntity> customerEntityList=customerRepository.findAllByCity(data);
       List<CustomerModel> customerModels=new ArrayList<>();
       customerEntityList.forEach(customerEntity -> {
            CustomerModel customerModel=new CustomerModel();
           BeanUtils.copyProperties(customerEntity,customerModel);
           customerModels.add(customerModel);
       });
        return customerModels;
    }
}
