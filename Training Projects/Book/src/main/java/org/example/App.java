package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class App {
    @RequestMapping(value="/user",method= RequestMethod.GET)
    public String getName(Model model){
        //System.out.println("entered into method");
        model.addAttribute("name"," SATHYA ");
        return "index";
    }

}
