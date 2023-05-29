package com.example.backend.service.user.account;

import com.sun.jdi.event.StepEvent;

import java.util.Map;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/28 11:47
 */
public interface RegisterService
{
    Map<String, String> register(String username, String password, String confirmedPassword);
}
