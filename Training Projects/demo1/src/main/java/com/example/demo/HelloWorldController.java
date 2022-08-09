package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class HelloWorldController {
    @RequestMapping("/one")
    public String helloWorld() {
        return "Hello World From Spring Boot to Sathya";
    }

    @RequestMapping("/goodbye")
    public String goodBye() {
        return "Good Bye from Spring Boot";
    }

    @PostMapping("/post/{a}")
    public String postMethod(@PathVariable("a") String data) {
        return data;
    }

    @GetMapping("/que")
    public String question(Model model)
    {
        model.addAttribute("name","satya");
        return "data";
    }
    @GetMapping("/front")
    public String front(@RequestParam("end") String end, Model model)
    {
        model.addAttribute("output",end);
        return "data";
    }

    @RequestMapping("/message")
    public ModelAndView meth()
    {
        return new ModelAndView("data.jsp");
    }

}