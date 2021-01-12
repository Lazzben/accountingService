package com.lazyben.accounting.dao;

import com.lazyben.accounting.model.persistence.UserInfo;

public interface UserInfoDao {
    UserInfo getUserInfoById(long id);

    void createNewUser(String username, String password);
}
