package com.example.demo.service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.security.MyUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EMployeeService {
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    EmployeeRepository employeeRepository;
    public String saveEmp(EmployeeModel employeeModel){
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employeeModel,employeeEntity);
        employeeEntity.setPassword(encoder.encode(employeeModel.getPassword()));
        employeeRepository.save(employeeEntity);
        return "EMployee added sucessfully";
    }
    public List<EmployeeModel> getEMp(){
        List<EmployeeEntity> employeeEntityList=employeeRepository.findAll();
        List<EmployeeModel> employeeModelList=new ArrayList<>();
        employeeEntityList.forEach(employeeEntity -> {
            EmployeeModel employeeModel=new EmployeeModel();
            BeanUtils.copyProperties(employeeEntity,employeeModel);
            employeeModelList.add(employeeModel);
        });
        return employeeModelList;
    }
}
