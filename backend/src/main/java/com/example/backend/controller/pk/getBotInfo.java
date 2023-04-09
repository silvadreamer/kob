package com.example.backend.controller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Silva31
 * @date 2023/4/9 21:45
 */

@RestController
@RequestMapping("/pk/")
public class getBotInfo
{
    @RequestMapping("getbotinfo/")
    public Map<String, String> info()
    {
        Map<String, String> map = new HashMap<>();
        map.put("name", "tiger");
        map.put("rating", "3000");
        return map;
    }
}
