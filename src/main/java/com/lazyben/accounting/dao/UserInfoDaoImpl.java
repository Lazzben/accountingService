package com.lazyben.accounting.dao;

import com.lazyben.accounting.dao.mapper.UserInfoMapper;
import com.lazyben.accounting.model.persistence.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoDaoImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfo getUserInfoById(long id) {
        return userInfoMapper.getUserInfoById(id);
    }

    @Override
    public void createNewUser(String username, String password) {

    }
}
