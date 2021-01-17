package com.lazyben.accounting.convert.c2s;

import com.lazyben.accounting.model.common.UserInfo;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInfoC2SConverterTest {

    private final UserInfoC2SConverter userInfoC2SConverter = new UserInfoC2SConverter();

    @Test
    void testDoForward() {
        // Arrange
        val userId = 100L;
        val username = "hardcore";
        val password = "hardcore";

        val userInfoInCommon = UserInfo.builder()
                .id(userId)
                .username(username)
                .password(password)
                .build();

        // Act
        val result = userInfoC2SConverter.convert(userInfoInCommon);

        // Assert
        assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id", userId)
                .hasFieldOrPropertyWithValue("username", username)
                .hasFieldOrPropertyWithValue("password", null);
    }

    @Test
    void testDoBackward() {
        // Arrange
        val userId = 100L;
        val username = "hardcore";
        val password = "hardcore";

        val userInfoInCommon = com.lazyben.accounting.model.service.UserInfo.builder()
                .id(userId)
                .username(username)
                .password(password)
                .build();

        // Act
        val result = userInfoC2SConverter.reverse().convert(userInfoInCommon);

        // Assert
        assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id", userId)
                .hasFieldOrPropertyWithValue("username", username)
                .hasFieldOrPropertyWithValue("password", password);

    }
}

