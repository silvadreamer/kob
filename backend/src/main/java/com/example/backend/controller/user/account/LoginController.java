package com.example.backend.controller.user.account;

import com.example.backend.service.user.account.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/28 12:07
 */

@RestController
public class LoginController
{
    @Autowired
    private LoginService loginService;

    @PostMapping("/user/account/token/")
    public Map<String, String> getToken(@RequestParam Map<String, String> map)
    {
        String username = map.get("username");
        String password = map.get("password");
        System.out.println(username + ' ' + password);
        return loginService.getToken(username, password);
    }
}
