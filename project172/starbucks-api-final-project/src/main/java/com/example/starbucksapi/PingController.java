package com.example.starbucksapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller

public class PingController {
    class Ping {
        private String test ;
        public Ping(String msg) { this.test = msg ; }
        public String getTest() { return this.test ; }
    }

    @GetMapping("/")
 
    public String viewHome(Model model) {
        model.addAttribute( "message", "Hello World!" );
        return "home" ; 
    }

  
    @GetMapping("/cashier")
    public String viewOrder(Model model, @ModelAttribute("drink") StarbucksOrder order) {
        model.addAttribute( "message", "Hello World!" );
        return "cashier" ; 
    }    
    @GetMapping("/sign-in")
    public String viewOrder(Model model) {
        model.addAttribute( "message", "Hello World!" );
        return "sign-in" ; 
    }     
    @GetMapping("/menu")
    public String viewMenu(Model model) {
        model.addAttribute( "message", "Hello World!" );
        return "menu" ; 
    }    
    @GetMapping("/balance")
    public String viewBalance(Model model) {
        model.addAttribute( "message", "Hello World!" );
        return "balance" ; 
    }

}
