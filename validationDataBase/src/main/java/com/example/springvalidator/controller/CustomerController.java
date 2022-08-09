package com.example.springvalidator.controller;
import com.example.springvalidator.model.CustomerModel;
import com.example.springvalidator.service.ServiceInterface;
import com.example.springvalidator.validation.NewValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller

public class CustomerController {
    @Autowired
    ServiceInterface serviceInterface;
    @Autowired
    NewValidation valid;
    @GetMapping("/user")
    public String choice(){
        return "choice1";
    }

    @GetMapping("/add Customers")
    public String addCustomer(Model model){
        CustomerModel customerModel=new CustomerModel();
        model.addAttribute("customerModel",customerModel);
        return "addCustomer";
    }

    @PostMapping("/saveCustomers")
    public String saveCustomers(@Valid @ModelAttribute("customerModel") CustomerModel customerModel, BindingResult bindingResult, Model model){
        valid.validate(customerModel,bindingResult);
        if(bindingResult.hasErrors()) return "addCustomer";
        model.addAttribute("message",serviceInterface.saveCustomer(customerModel));
        return "choice1";
    }
    @GetMapping("/view Customers")
    public String viewCustomers(Model model){
        model.addAttribute("customerModelList",serviceInterface.getAllCustomers());
        return "viewCustomers";
    }

//    @GetMapping("/editCustomer")
//    public String editCustomer(@RequestParam("editCity") String editCity,Model model){
//        model.addAttribute("customerModelList",serviceInterface.getCustomerByCity(editCity));
//        return "viewCustomers";
//    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id") String id,Model model){
        model.addAttribute("message",serviceInterface.delete(Integer.valueOf(id)));
        return "deleteCustomers";
    }
    @GetMapping("/editCustomer")
    public String editCustomer(@RequestParam("editId") String editId,Model model){
        model.addAttribute("cusModel",serviceInterface.updateAdd(Integer.valueOf(editId)));
        return "editCustomers";
    }
    @PostMapping("/updateCustomer")
    public String updateCustomer(@Valid @ModelAttribute("cusModel") CustomerModel cusModel,BindingResult bindingResult,Model model){
        valid.validate(cusModel,bindingResult);
        if(bindingResult.hasErrors())
            return "editCustomers";
        else serviceInterface.saveCustomer(cusModel);
        return "redirect:view Customers";
    }
    @PostMapping("/searchBar")
    public String searchBar(@RequestParam("search") String search,Model model){
        model.addAttribute("customerModelList",serviceInterface.getSearchData(search));
        return "viewCustomers";
    }
}
