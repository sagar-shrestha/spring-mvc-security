package com.controller;

import com.dao.SignupDao;
import com.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;

@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SignupDao signupDao;

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

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
        UserDetails userDetails = User.withUsername(signupDto.getUsername()).password(signupDto.getPassword()).authorities("CODER").build();
        jdbcUserDetailsManager.createUser(userDetails);
    //    signupDao.saveUser(signupDto);
        return "redirect:/login";
    }

    @GetMapping("/trainer")
    public String showTrainerDashboard() {
        return "trainer";
    }

    @GetMapping("/coder")
    public String showCoderDashboard() {
        return "coder";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "access-denied";
    }


}
