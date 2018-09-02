package com.haaphoop.eshop.inventory.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haaphoop.eshop.inventory.dao.RedisDAO;
import com.haaphoop.eshop.inventory.mapper.UserMapper;
import com.haaphoop.eshop.inventory.model.User;
import com.haaphoop.eshop.inventory.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisDAO redisDAO;
    @Override
    public User findUserInfo() {
        return userMapper.findUserInfo();
    }

    @Override
    public User getCacheUser() {
        redisDAO.set("cache_user_lisi", "{\"name\":\"lisi\",\"age\":28}");
        String userJSON = redisDAO.get("cache_user_lisi");
        JSONObject userJSONObject = JSONObject.parseObject(userJSON);
        User user = new User();
        user.setName(userJSONObject.getString("name"));
        user.setAge(userJSONObject.getInteger("age"));
        return user;
    }
}
