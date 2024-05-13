package com.dao;

import com.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SignupDaoImpl implements SignupDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUser(SignupDto signupDto) {
        String sql = "insert into users values(?,?,?)";
        String sql2 = "insert into authorities values(?,?)";
        jdbcTemplate.update(sql, signupDto.getUsername(), signupDto.getPassword(), 1);
        jdbcTemplate.update(sql2, signupDto.getUsername(), "USER");

    }
}
