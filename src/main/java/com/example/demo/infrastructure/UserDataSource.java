package com.example.demo.infrastructure;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataSource implements UserRepository {

    JdbcTemplate jdbcTemplate;

    public UserDataSource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users"
                , ((rs, rowNum) ->
                        new User(rs.getString("name"), rs.getInt("age")))
        );
    }
}
