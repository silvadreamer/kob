package com.example.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import com.example.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/28 14:46
 */
@Service
public class RegisterServiceImpl implements RegisterService
{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword)
    {
        Map<String, String> map = new HashMap<>();

        if(username == null)
        {
            map.put("error_message", "用户名不能为空");
            return map;
        }

        username = username.trim();
        if(username.length() > 100)
        {
            map.put("error_message", "用户名过长");
            return map;
        }

        if(password == null)
        {
            map.put("error_message", "密码不能为空");
            return map;
        }

        if(password.length() > 100)
        {
            map.put("error_message", "密码过长");
            return map;
        }

        if(!password.equals(confirmedPassword))
        {
            map.put("error_message", "密码不一致");
            return map;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if(!users.isEmpty())
        {
            map.put("error_message", "用户已存在");
            return map;
        }

        String encodedPassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/175416_lg_5a0290e4c6.jpg";
        User user = new User(null, username, encodedPassword, photo);
        userMapper.insert(user);
        map.put("error_message", "success");

        return map;
    }
}
