package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Silva31
 * @version 1.0
 * @date 2023/5/27 16:01
 */

@Mapper
public interface UserMapper extends BaseMapper<User>
{

}
