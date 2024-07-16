package com.example.priceapp.application.ports.output;

import java.time.LocalDateTime;
import java.util.List;

import com.example.priceapp.domain.models.Price;

public interface PriceRepository {
    public List<Price> findByProductIdAndBrandIdAndDateRange(Long productId, Long brandId, LocalDateTime date);
}
