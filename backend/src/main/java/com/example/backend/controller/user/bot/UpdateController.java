package com.example.backend.controller.user.bot;

import com.example.backend.service.user.bot.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/31 19:56
 */

@RestController
public class UpdateController
{
    @Autowired
    private UpdateService updateService;

    @PostMapping("/user/bot/update/")
    public Map<String, String> update(@RequestParam Map<String, String> data)
    {
        return updateService.update(data);
    }

}
