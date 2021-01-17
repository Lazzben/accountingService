package com.lazyben.accounting.dao;

import com.lazyben.accounting.dao.mapper.UserInfoMapper;
import com.lazyben.accounting.model.persistence.UserInfo;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserInfoDaoTest {
    @Mock
    private UserInfoMapper userInfoMapper;

    @InjectMocks
    private UserInfoDaoImpl userInfoDao;

    @Test
    public void testUserInfoDao() {
        long userId = 1L;
        String username = "admin";
        String password = "admin";
        LocalDate createTime = LocalDate.now();

        val userInfo = UserInfo.builder()
                .id(userId)
                .username(username)
                .password(password)
                .createTime(createTime)
                .build();

        doReturn(userInfo).when(userInfoMapper).getUserInfoById(userId);

        val result = userInfoDao.getUserInfoById(userId);

        assertEquals(userInfo, result);

        verify(userInfoMapper).getUserInfoById(eq(userId));
    }
}
