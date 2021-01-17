package com.lazyben.accounting.convert.p2c;

import com.google.common.base.Converter;
import com.lazyben.accounting.model.persistence.UserInfo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserInfoP2CConverter extends Converter<UserInfo, com.lazyben.accounting.model.common.UserInfo> {
    @Override
    protected com.lazyben.accounting.model.common.UserInfo doForward(UserInfo userInfo) {
        return com.lazyben.accounting.model.common.UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .build();
    }

    @Override
    protected UserInfo doBackward(com.lazyben.accounting.model.common.UserInfo userInfo) {
        return UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .build();
    }
}
