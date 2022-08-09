package com.example.demo.empcontroller;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EMployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
    @Autowired
    EMployeeService eMployeeService;
    @GetMapping(" ")
    public String index(){
        return "index";
    }
    @GetMapping("/reg")
    public String choice(Model model){
        EmployeeModel employeeModel=new EmployeeModel();
        model.addAttribute("employeeModel",employeeModel);
        return "empRegister";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employeeModel") EmployeeModel employeeModel,Model model){
        model.addAttribute("message",eMployeeService.saveEmp(employeeModel));
        return "index";
    }
    @GetMapping("/listEmployees")
    public String getEmployees(Model model){
        model.addAttribute("empList",eMployeeService.getEMp());
        return "employeesList";
    }
}
