package com.pjx.demo2018.controller;

import com.pjx.demo2018.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author juqi
 * @date 18/5/26
 */
@RestController
public class SpringJDBCController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/users/{id}")
    public UserPO findUserByID(@PathVariable(value = "id") Long id) {
        String sql = "select * from t_user where id = ?";
        List<UserPO> users = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<UserPO>(UserPO.class));
        if (CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }
    @GetMapping("/users")
    public List<UserPO> findUsers(){
        String sql = "select * from t_user";
        List<UserPO> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserPO>(UserPO.class));
        return users;
    }
    @DeleteMapping("/users/{id}")
    public int deleteUserByID(@PathVariable Long id){
        String sql = "delete from t_user where id = ?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }
    @PostMapping("/users")
    public int addUsers(@RequestBody UserPO user){
        // 添加用户
        String sql = "insert into t_user(username, password) values(?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }
    @PutMapping("/users/{id}")
    public int editUser(@PathVariable Long id, @RequestBody UserPO user) {
        // 根据主键ID修改用户信息
        String sql = "UPDATE t_user SET username = ? ,password = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), id);
    }


}
