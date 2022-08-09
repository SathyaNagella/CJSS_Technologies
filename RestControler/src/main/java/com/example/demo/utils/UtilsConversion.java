package com.example.demo.utils;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.EmployeeModel;
import org.springframework.beans.BeanUtils;

public class UtilsConversion {
    public static EmployeeEntity modelToEntity(EmployeeModel employeeModel){
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employeeModel,employeeEntity);
        return employeeEntity;
    }
    public static EmployeeModel EntityToModel(EmployeeEntity employeeEntity){
        EmployeeModel employeeModel=new EmployeeModel();
        BeanUtils.copyProperties(employeeEntity,employeeModel);
        return employeeModel;
    }
}
