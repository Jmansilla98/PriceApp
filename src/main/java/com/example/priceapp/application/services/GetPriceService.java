package com.example.priceapp.application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.priceapp.application.ports.input.GetPriceQuery;
import com.example.priceapp.application.ports.output.PriceRepository;
import com.example.priceapp.domain.models.Price;
import com.example.priceapp.domain.services.PriceService;

@Service
public class GetPriceService implements GetPriceQuery {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceService priceService;

    @Override
    public Optional<Price> getPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndDateRange(productId, brandId, applicationDate);
        return priceService.getApplicablePrice(prices, applicationDate);
    }
}
