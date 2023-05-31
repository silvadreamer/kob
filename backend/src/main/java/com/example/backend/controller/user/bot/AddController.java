package com.example.backend.controller.user.bot;

import com.example.backend.service.user.bot.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/31 19:12
 */
@RestController
public class AddController
{
    @Autowired
    private AddService addService;

    @PostMapping("/user/bot/add/")
    public Map<String, String> add(@RequestParam Map<String, String> data)
    {
        return addService.add(data);
    }
}

