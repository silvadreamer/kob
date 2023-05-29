package com.example.backend.service.user.account;

import java.util.Map;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/28 11:46
 */
public interface LoginService
{
    Map<String, String> getToken(String username, String password);
}
