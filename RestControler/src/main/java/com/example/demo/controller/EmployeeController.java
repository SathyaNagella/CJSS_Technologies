package com.example.demo.controller;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/getEmployees")
    public List<EmployeeModel> getEmployees(){
           return employeeService.retriveEmployees();
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @RequestBody EmployeeModel employeeModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "Errors";
        }
        return employeeService.saveEmployee(employeeModel);
    }
    @GetMapping("/getEmployee/{empId}")
    public EmployeeModel getEmployee(@PathVariable(name="empId") Long empId){
        return employeeService.getEmployee(empId);
    }
    @PutMapping("/editEmployee/{empId}")
    public String editEmployee(@RequestBody EmployeeModel employeeModel,@PathVariable("empId") Long empId){
                return employeeService.update(employeeModel,empId);
    }
    @DeleteMapping("/deleteEmployee/{empId}")
    public String deleteEmployee(@PathVariable("empId") Long empId){
        return employeeService.delete(empId);
    }
}
