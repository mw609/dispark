package com.mw.transaction.service.impl;

import com.mw.transaction.entry.UserInfo;
import com.mw.transaction.mapper.UserInfoMapper;
import com.mw.transaction.service.UesrInfoService;
import com.mw.transaction.service.UesrInfoServiceSecond;
import com.sun.istack.internal.XMLStreamException2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl implements UesrInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UesrInfoServiceSecond uesrInfoServiceSecond;


    @Autowired
    private  UserInfoManager userInfoManager;

    /**
     * 事务失效原因1：异常被捕获
     * @param userInfo
     * @return
     */
    @Override
    @Transactional
    public Integer saveTryCath(UserInfo userInfo) {
        try {
            userInfoMapper.insert(userInfo);
            int number = 3/0;
            return number;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 发生非 error或者RunTimeException 时，造成事务失效
     * @param userInfo
     * @throws XMLStreamException2
     */
    @Override
    @Transactional
    public void save1(UserInfo userInfo) throws XMLStreamException2 {
        userInfoMapper.insert(userInfo);
        throw new XMLStreamException2("123");
    }

    /**
     * 事务传播类型  NOT_SUPPORTED   不支持事务，即使当前有事务，也不会使用事务。
     * @param userInfo
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void save2(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
        int number = 20/0;
    }


    /**
     * NEVER表示不支持事务
     * @param userInfo
     */
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void save3(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
        int number = 20/0;
    }

    /**
     * SUPPORTS 如果当前有事务，就加入，如果没事务，则以非事务运行。
     * @param userInfo
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void save4(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
        int number = 20/0;
    }


    @Override
    public void save5(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setName("666");
        userInfo1.setAge(666);
        save6(userInfo1);
    }

    @Override
    @Transactional
    public void save6(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
        int number = 20/0;
    }


    /**
     * REQUIRES_NEW会新开启事务，外层事务不会影响内部事务的提交/回滚
     * REQUIRES_NEW的内部事务的异常，会影响外部事务的回滚
     * @param userInfo
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save7(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setName("666");
        userInfo1.setAge(666);
        uesrInfoServiceSecond.save8(userInfo1);
        int number = 20/0;
    }

    @Override
    public void save9(UserInfo userInfo) {
        userInfoManager.save8(userInfo);
    }


}
