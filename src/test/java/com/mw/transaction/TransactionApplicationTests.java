package com.mw.transaction;

import com.mw.transaction.entry.UserInfo;
import com.mw.transaction.mapper.UserInfoMapper;
import com.mw.transaction.service.UesrInfoService;
import com.sun.istack.internal.XMLStreamException2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionApplicationTests {

    @Autowired
    UesrInfoService uesrInfoService;

    @Test
    void saveTryCath() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(15);
        userInfo.setName("123");
        uesrInfoService.saveTryCath(userInfo);
    }

    @Test
    void save1()throws XMLStreamException2 {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(15);
        userInfo.setName("123");
        uesrInfoService.save1(userInfo);
    }

    @Test
    void save2(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(15);
        userInfo.setName("123");
        uesrInfoService.save2(userInfo);
    }

    @Test
    void save3(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(15);
        userInfo.setName("123");
        uesrInfoService.save3(userInfo);
    }


    @Test
    void save4(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(15);
        userInfo.setName("123");
        uesrInfoService.save4(userInfo);
    }


    @Test
    void save5(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(15);
        userInfo.setName("123");
        uesrInfoService.save5(userInfo);
    }


    @Test
    void save7(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(15);
        userInfo.setName("123");
        uesrInfoService.save7(userInfo);
    }

    @Test
    void save9(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(15);
        userInfo.setName("123");
        uesrInfoService.save9(userInfo);
    }
}
