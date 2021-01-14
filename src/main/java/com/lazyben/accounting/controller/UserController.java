package com.lazyben.accounting.controller;

import com.lazyben.accounting.convert.c2s.UserInfoC2SConverter;
import com.lazyben.accounting.exception.InvalidParameterException;
import com.lazyben.accounting.manager.UserInfoManager;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class UserController {
    private final UserInfoManager userInfoManager;
    private final UserInfoC2SConverter userInfoC2SConverter;

    @Autowired
    public UserController(UserInfoManager userInfoManager, UserInfoC2SConverter userInfoC2SConverter) {
        this.userInfoManager = userInfoManager;
        this.userInfoC2SConverter = userInfoC2SConverter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserInfoById(@PathVariable("id") long id) {
        if (id <= 0L) {
            throw new InvalidParameterException(String.format("User id %s is invalid", id));
        }
        val userInfo = userInfoManager.getUserInfoById(id);
        return ResponseEntity.ok(userInfoC2SConverter.convert(userInfo));
    }
}
