package com.mw.transaction.mapper;

import com.mw.transaction.entry.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper {

   int insert(UserInfo userInfo);

   int update( UserInfo userInfo);
}
