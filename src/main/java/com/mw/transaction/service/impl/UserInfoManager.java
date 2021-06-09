package com.mw.transaction.service.impl;


import com.mw.transaction.entry.UserInfo;
import com.mw.transaction.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserInfoManager {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Transactional
    protected  void save8(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
        int number = 20/0;
    }
}
