package com.example.backend.service.impl.user.account;

import com.example.backend.pojo.User;
import com.example.backend.service.impl.utils.UserDetailsImpl;
import com.example.backend.service.user.account.LoginService;
import com.example.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/28 11:52
 */

@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private AuthenticationManager authenticationManager;

//    @Override
//    public Map<String, String> getToken(String username, String password)
//    {
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
//                = new UsernamePasswordAuthenticationToken(username, password);
//
//        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//        UserDetailsImpl userDetails = (UserDetailsImpl) authenticate.getPrincipal();
//        User user = userDetails.getUser();
//
//        String jwt = JwtUtil.createJWT(user.getId().toString());
//        Map<String, String> map = new HashMap<>();
//        map.put("error_message", "success");
//        map.put("token", jwt);
//
//        return map;
//    }

    @Override
    public Map<String, String> getToken(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);  // 登录失败，会自动处理
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        User user = loginUser.getUser();
        String jwt = JwtUtil.createJWT(user.getId().toString());
        System.out.println(jwt);
        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("token", jwt);

        return map;
    }

}
