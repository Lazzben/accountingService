package com.lazyben.accounting.controller;

import com.lazyben.accounting.convert.c2s.UserInfoC2SConverter;
import com.lazyben.accounting.exception.GlobalExceptionHandler;
import com.lazyben.accounting.manager.UserInfoManager;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerTest {
    private MockMvc mockMvc;

    @Mock
    public UserInfoManager userInfoManager;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userInfoManager, new UserInfoC2SConverter()))
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();

    }

    @AfterEach
    void teardown() {
        reset(userInfoManager);
    }

    @Test
    void testGetUserInfoById() throws Exception {
        // Arrange
        val userId = 100L;
        val username = "admin";
        val password = "admin";

        val userInfoInCommon = com.lazyben.accounting.model.common.UserInfo.builder()
                .id(userId)
                .username(username)
                .password(password)
                .build();

        doReturn(userInfoInCommon).when(userInfoManager).getUserInfoById(userId);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/" + userId))
                .andExpect(content().string("{\"id\":100,\"username\":\"admin\",\"password\":null}"))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());

        verify(userInfoManager).getUserInfoById(anyLong());
    }

    @Test
    void testGetUserInfoByIdWithInvalidUserId() throws Exception {
        // Arrange
        val userId = -1L;

        // Act & Assert                                                                                                                             {"code":"INVALID_PARAMETER","message":"User id -1 is invalid","statusCode":400,"errorType":"Client"}
        mockMvc.perform(MockMvcRequestBuilders.get("/" + userId))
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"code\":\"INVALID_PARAMETER\",\"message\":\"User id -1 is invalid\",\"statusCode\":400,\"errorType\":\"Client\"}"));

        verify(userInfoManager, never()).getUserInfoById(anyLong());
    }
}
