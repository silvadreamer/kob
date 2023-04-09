package com.example.backend.controller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Silva31
 * @date 2023/4/8 22:09
 */

@Controller
@RequestMapping("/pk/")
public class IndexController
{
    @RequestMapping("index/")
    public String index()
    {
        return "pk/index.html";
    }
}
