package com.mw.transaction.service.impl;

import com.mw.transaction.entry.UserInfo;
import com.mw.transaction.mapper.UserInfoMapper;
import com.mw.transaction.service.UesrInfoServiceSecond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UesrInfoServiceSecondImpl implements UesrInfoServiceSecond {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save8(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);

    }
}
