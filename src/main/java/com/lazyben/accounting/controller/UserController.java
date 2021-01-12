package com.lazyben.accounting.controller;

import com.lazyben.accounting.convert.c2s.UserInfoC2SConverter;
import com.lazyben.accounting.model.service.UserInfo;
import com.lazyben.accounting.manager.UserInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserInfoManager userInfoManager;
    private final UserInfoC2SConverter userInfoC2SConverter;

    @Autowired
    public UserController(UserInfoManager userInfoManager, UserInfoC2SConverter userInfoC2SConverter) {
        this.userInfoManager = userInfoManager;
        this.userInfoC2SConverter = userInfoC2SConverter;
    }

    @GetMapping("/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") long id) {
        return userInfoC2SConverter.convert(userInfoManager.getUserInfoById(id));
    }
}
