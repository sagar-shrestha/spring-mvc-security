package com.controller;

import com.dto.ChangePasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.security.Principal;

@Controller
public class HelloWorldController {
    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/helloworld")
    public String helloWorld(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "homepage";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("username") String username, Model model) {
        jdbcUserDetailsManager.deleteUser(username);
        System.out.println(username + "deleted.");
        return "redirect:/login";
    }

    @GetMapping("/changePassword")
    public String changePassword(Model model) {

        model.addAttribute("changePassword", new ChangePasswordDto());
        return "change-password";
    }

    @PostMapping("/savePassword")
    public String savePassword(Principal principal, ChangePasswordDto changePasswordDto) {
        UserDetails userDetails = jdbcUserDetailsManager.loadUserByUsername(principal.getName());
        boolean matches = passwordEncoder.matches(changePasswordDto.getOldPassword(), userDetails.getPassword());
        if (!changePasswordDto.getNewPassword().equals(changePasswordDto.getConfirmPassword())) {
            return "redirect:/changePassword?invalidNewAndConfirmPassword";
        }
        if (matches) {
            String encodedPassword = passwordEncoder.encode(changePasswordDto.getConfirmPassword());
            jdbcUserDetailsManager.changePassword(changePasswordDto.getOldPassword(), encodedPassword);
            return "homepage";
        } else {

            return "redirect:/changePassword?invalidOldPassword";
        }
    }

    @ResponseBody
    @GetMapping("/bye")
    public String bye() {
        return "bye bye!!!";
    }
}
