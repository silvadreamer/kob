package com.example.backend.controller.user;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/27 16:05
 */

@RestController
public class UserController
{
    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/all/")
    public List<User> getAll()
    {
        return userMapper.selectList(null);
    }

    @GetMapping("/user/{userid}/")
    public User getUser(@PathVariable int userid)
    {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userid);
        return userMapper.selectOne(queryWrapper);

        //return userMapper.selectById(userid);
    }

    @GetMapping("/user/add/{userid}/{username}/{password}/")
    public String addUser(@PathVariable int userid, @PathVariable String username, @PathVariable String password)
    {
        User user = new User(userid, username, password);
        userMapper.insert(user);
        return "add success";
    }

    @GetMapping("/user/delete/{userid}/")
    public String deleteUser(@PathVariable int userid)
    {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userid);
        userMapper.delete(queryWrapper);
        return "delete success";
    }
}
