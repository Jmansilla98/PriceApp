package com.example.priceapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetPriceAt10On14th() throws Exception {

        mockMvc.perform(get("/price")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("applicationDate", "2020-06-14-10.00.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void testGetPriceAt16On14th() throws Exception {
        mockMvc.perform(get("/price")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("applicationDate", "2020-06-14-16.00.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    void testGetPriceAt21On14th() throws Exception {

        mockMvc.perform(get("/price")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("applicationDate", "2020-06-14-21.00.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void testGetPriceAt10On15th() throws Exception {

        mockMvc.perform(get("/price")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("applicationDate", "2020-06-15-10.00.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    void testGetPriceAt21On16th() throws Exception {
        mockMvc.perform(get("/price")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("applicationDate", "2020-06-16-21.00.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95));
    }
}
