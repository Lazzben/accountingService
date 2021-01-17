package com.lazyben.accounting.convert.c2s;

import com.google.common.base.Converter;
import com.lazyben.accounting.model.common.UserInfo;
import com.sun.istack.internal.NotNull;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserInfoC2SConverter extends Converter<UserInfo, com.lazyben.accounting.model.service.UserInfo> {
    @Override
    protected com.lazyben.accounting.model.service.UserInfo doForward(UserInfo userInfo) {
        return com.lazyben.accounting.model.service.UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .build();
    }

    @Override
    protected UserInfo doBackward(com.lazyben.accounting.model.service.UserInfo userInfo) {
        return UserInfo.builder()
                .id(userInfo.getId())
                .password(userInfo.getPassword())
                .username(userInfo.getUsername())
                .build();
    }
}
