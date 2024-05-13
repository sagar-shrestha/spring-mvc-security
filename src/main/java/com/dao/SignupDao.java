package com.dao;

import com.dto.SignupDto;
import org.springframework.security.core.userdetails.User;

public interface SignupDao {

    void saveUser(SignupDto signupDto);
}
