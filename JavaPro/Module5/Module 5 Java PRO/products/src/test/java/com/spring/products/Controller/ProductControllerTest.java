package com.spring.products.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreateANewProduct() throws Exception {
        String requestBody = "{\n" +
                "    \"id\": \"1\",\n" +
                "    \"nome\": \"j5 prime\",\n" +
                "}";


        mockMvc.perform(MockMvcRequestBuilders
                        .post("/product")
                        .content(requestBody)
                        .contentType("application/json"))
                .andExpect(status().isCreated());
    }
}