package com.example.backend.controller.user.bot;

import com.example.backend.pojo.Bot;
import com.example.backend.service.user.bot.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/31 20:17
 */
@RestController
public class GetListController
{
    @Autowired
    private GetListService getListService;

    @GetMapping("/user/bot/getlist/")
    public List<Bot> getList()
    {
        return getListService.getList();
    }
}

