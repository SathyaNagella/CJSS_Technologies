package com.example.springvalidator.service;

import com.example.springvalidator.model.CustomerModel;

import java.util.List;

public interface ServiceInterface {
    String saveCustomer(CustomerModel customerModel);
    List<CustomerModel> getAllCustomers();
    String delete(Integer cusNo);
    CustomerModel updateAdd(Integer cusNo);
}
