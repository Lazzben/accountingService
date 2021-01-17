package com.lazyben.accounting.manager;

import com.lazyben.accounting.convert.p2c.UserInfoP2CConverter;
import com.lazyben.accounting.dao.UserInfoDao;
import com.lazyben.accounting.exception.ResourceNotFoundException;
import com.lazyben.accounting.model.persistence.UserInfo;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class UserInfoManagerTest {
    private UserInfoManager userInfoManager;

    @Mock
    private UserInfoDao userInfoDao;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        userInfoManager = new UserInfoManagerImpl(userInfoDao, new UserInfoP2CConverter());
    }

    @Test
    public void testGetUserInfoById() {
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

        doReturn(userInfo).when(userInfoDao).getUserInfoById(userId);

        val result = userInfoManager.getUserInfoById(userId);
        assertEquals(userId, result.getId());
        assertEquals("admin", result.getUsername());
        assertEquals("admin", result.getPassword());

        verify(userInfoDao).getUserInfoById(eq(userId));
    }

    @Test
    public void testGetUserInfoByIdWithInvalidParameter() {
        long userId = -1L;

        doReturn(null).when(userInfoDao).getUserInfoById(userId);

        assertThrows(ResourceNotFoundException.class, () -> userInfoManager.getUserInfoById(userId));

        verify(userInfoDao).getUserInfoById(eq(userId));
    }
}
