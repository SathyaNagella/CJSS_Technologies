package com.example.springvalidator.service;

import com.example.springvalidator.model.CustomerModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Service
public class Service_Imple_Class implements ServiceInterface{
    List<CustomerModel> customerModelList=new LinkedList<>();
    @Override
    public String saveCustomer(CustomerModel customerModel) {
        customerModelList.add(customerModel);
        return "Customer Added Successfully";
    }

    @Override
    public List<CustomerModel> getAllCustomers() {
        return customerModelList;
    }

    @Override
    public String delete(Integer cusNo) {
        CustomerModel deleteList=customerModelList.stream().filter(pr->pr.getCusId()==cusNo).findFirst().get();
        customerModelList.remove(deleteList);
        //customerModelList.stream().filter(fi->fi.getCusId()==eno).re
        return cusNo+" Customer Deleted Successfully";
    }

    @Override
    public CustomerModel updateAdd(Integer cusNo) {
        CustomerModel updateList=customerModelList.stream().filter(up->up.getCusId()==cusNo).findFirst().get();
        if(updateList!=null)
        {
            customerModelList.remove(updateList);
        }
        return updateList;
    }
}
