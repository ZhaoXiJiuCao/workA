package com.ems.service.impl;

import com.ems.dao.UserMapper;
import com.ems.entity.User;
import com.ems.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaozhihe
 * @Description: ${todo}
 * @date 2020/9/230:02
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAllUserInfo() {
        return userMapper.selectUserBatch();
    }
}
