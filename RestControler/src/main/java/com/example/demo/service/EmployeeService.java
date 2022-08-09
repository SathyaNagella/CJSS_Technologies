package com.example.demo.service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.utils.UtilsConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<EmployeeModel> retriveEmployees(){
        List<EmployeeEntity> employeeEntityList=employeeRepository.findAll();
        List<EmployeeModel>employeeModelList=new ArrayList<>();
        employeeEntityList.forEach(employeeEntity -> {
            employeeModelList.add(UtilsConversion.EntityToModel(employeeEntity));
        });
        return employeeModelList;
    }
    public String saveEmployee(EmployeeModel employeeModel){
        employeeRepository.save(UtilsConversion.modelToEntity(employeeModel));
        return "Employee Saved Successfully";
    }
    public EmployeeModel getEmployee(Long empId){
       return UtilsConversion.EntityToModel(employeeRepository.findById(empId).get());

    }
    public String update(EmployeeModel employeeModel,Long empId){
        EmployeeEntity employee=UtilsConversion.modelToEntity(employeeModel);

        if(employeeRepository.findById(empId).isPresent()){
            employee.setEmployeeId(empId);
            employeeRepository.save(employee);
            return "Employee Updated Successfully";
        }else {
            return "EmpId not Exists";
        }

    }
    public String delete(Long empId){
        employeeRepository.deleteById(empId);
        return empId+" Deleted Successfully";
    }
}
