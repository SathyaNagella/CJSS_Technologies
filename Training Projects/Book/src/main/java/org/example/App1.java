package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("nothing")
public class App1 {
    @RequestMapping(value="/testing",method= RequestMethod.POST)
    public String right(@RequestParam("example1") String example, Model model) {
        model.addAttribute("output", example);
        return "index";
    }
}
