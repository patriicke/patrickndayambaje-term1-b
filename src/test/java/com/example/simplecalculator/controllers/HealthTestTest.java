package com.example.simplecalculator.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HealthTest.class)
public class HealthTestTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void healthTest() throws Exception {
        //call GET "/api/v1/health-test" application/json
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/health-test")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Server is up and running!"))
                .andReturn();

        assertEquals("Server is up and running!", result.getResponse().getContentAsString());

    }
}
