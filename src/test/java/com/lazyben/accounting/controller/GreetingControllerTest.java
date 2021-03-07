package com.lazyben.accounting.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GreetingControllerTest {
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();
    }

    @Test
    void testGreeting() throws Exception {
        // Arrange & Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting").param("name", "admin"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello admin"));
    }
}
