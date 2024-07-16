package com.example.priceapp.application.ports.input;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.priceapp.domain.models.Price;

public interface GetPriceQuery {
    Optional<Price> getPrice(Long productId, Long brandId, LocalDateTime applicationDate);
}
