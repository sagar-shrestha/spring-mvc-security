package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HelloWorldController {

    @GetMapping("/helloworld")
    public String helloWorld(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "homepage";
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello world!!!!!";
    }

    @ResponseBody
    @GetMapping("/bye")
    public String bye() {
        return "bye bye!!!";
    }
}
