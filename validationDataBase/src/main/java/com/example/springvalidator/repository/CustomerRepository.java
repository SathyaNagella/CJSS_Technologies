package com.example.springvalidator.repository;

import com.example.springvalidator.entity.CustomerEntity;
import com.example.springvalidator.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {
    default List<CustomerEntity> findAllByCity(String data){
        List<CustomerEntity> customerEntityList=findAll().stream().filter(fi->fi.getCusCity().toLowerCase().equals(data.toLowerCase())).collect(Collectors.toList());
        return customerEntityList;
    }
}
