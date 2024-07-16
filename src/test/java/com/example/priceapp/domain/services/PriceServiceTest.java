package com.example.priceapp.domain.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.example.priceapp.domain.models.Price;

public class PriceServiceTest {

    private final PriceService priceService = new PriceService();

    @Test
    public void testGetApplicablePrice() {
        Price price1 = Price.builder()
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 0))
                .priority(0)
                .price(35.50)
                .build();

        Price price2 = Price.builder()
                .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
                .priority(1)
                .price(25.45)
                .build();

        List<Price> prices = Arrays.asList(price1, price2);

        Optional<Price> applicablePrice = priceService.getApplicablePrice(prices,
                LocalDateTime.of(2020, 6, 14, 16, 0, 0));
        assertTrue(applicablePrice.isPresent());
        assertEquals(25.45, applicablePrice.get().getPrice());
    }
}
