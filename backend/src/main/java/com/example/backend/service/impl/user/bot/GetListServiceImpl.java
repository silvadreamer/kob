package com.example.backend.service.impl.user.bot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.BotMapper;
import com.example.backend.pojo.Bot;
import com.example.backend.pojo.User;
import com.example.backend.service.impl.utils.UserDetailsImpl;
import com.example.backend.service.user.bot.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/31 20:18
 */
@Service
public class GetListServiceImpl implements GetListService
{
    @Autowired
    private BotMapper botMapper;

    @Override
    public List<Bot> getList()
    {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        QueryWrapper<Bot> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());

        return botMapper.selectList(queryWrapper);
    }
}

