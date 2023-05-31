package com.example.backend.controller.user.bot;

import com.example.backend.service.user.bot.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/31 19:34
 */
@RestController
public class RemoveController
{
    @Autowired
    private RemoveService removeService;

    @PostMapping("/user/bot/remove/")
    public Map<String, String> remove(@RequestParam Map<String, String> data)
    {
        return removeService.remove(data);
    }

}
