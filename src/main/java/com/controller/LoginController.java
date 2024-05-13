package com.controller;

import com.dao.SignupDao;
import com.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SignupDao signupDao;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup(@ModelAttribute("signupdto") SignupDto signupdto) {
        return "signup";
    }

    @PostMapping("/process-signup")
    public String processSignup(SignupDto signupDto, RedirectAttributes redirectAttributes) {
        System.out.println(signupDto.toString());
        System.out.println("Before encoding: " + signupDto.getPassword());
      String encodedPassword = passwordEncoder.encode(signupDto.getPassword());
      signupDto.setPassword(encodedPassword);
        System.out.println("encodedPassword: " + encodedPassword);

        signupDao.saveUser(signupDto);
        return "redirect:/login";
    }

    @GetMapping("/trainer")
    public String showTrainerDashboard() {
        return "trainer-dashboard";
    }
    @GetMapping("/coder")
    public String showCoderDashboard() {
        return "coder-dashboard";
    }


}
