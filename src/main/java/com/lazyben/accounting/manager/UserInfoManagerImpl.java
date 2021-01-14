package com.lazyben.accounting.manager;

import com.lazyben.accounting.convert.p2c.UserInfoP2CConverter;
import com.lazyben.accounting.dao.UserInfoDao;
import com.lazyben.accounting.exception.ResourceNotFoundException;
import com.lazyben.accounting.model.common.UserInfo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
        val userInfo = Optional.ofNullable(userInfoDao.getUserInfoById(id))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User %s is not found", id)));
        return userInfoP2CConverter.convert(userInfo);
    }
}
