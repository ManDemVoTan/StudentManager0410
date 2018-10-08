package edu.zera.student.manager.controller;

import edu.zera.student.manager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String index(){
        return "hello";
    }
    @PostMapping("/register")
    public String getUserRegister(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  Model model){
       String un =  userService.register(username,password);
       if (un.equals("")){
           model.addAttribute("error",true);
           return "hello";
       }
        model.addAttribute("un",userService.findAllUsername());
       return "index";
    }
}
