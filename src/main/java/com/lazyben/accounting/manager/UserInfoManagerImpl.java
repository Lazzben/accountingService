package com.lazyben.accounting.manager;

import com.lazyben.accounting.convert.p2c.UserInfoP2CConverter;
import com.lazyben.accounting.dao.UserInfoDao;
import com.lazyben.accounting.model.common.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoManagerImpl implements UserInfoManager {
    private final UserInfoDao userInfoDao;
    private final UserInfoP2CConverter userInfoP2CConverter;

    @Autowired
    public UserInfoManagerImpl(UserInfoDao userInfoDao, UserInfoP2CConverter userInfoP2CConverter) {
        this.userInfoDao = userInfoDao;
        this.userInfoP2CConverter = userInfoP2CConverter;
    }

    @Override
    public UserInfo getUserInfoById(long id) {
        return userInfoP2CConverter.convert(userInfoDao.getUserInfoById(id));
    }
}
