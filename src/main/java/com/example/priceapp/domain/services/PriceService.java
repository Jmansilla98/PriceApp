package com.example.priceapp.domain.services;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.priceapp.domain.models.Price;

@Service
public class PriceService {

    public Optional<Price> getApplicablePrice(List<Price> prices, LocalDateTime applicationDate) {
        return prices.stream()
                .filter(price -> !applicationDate.isBefore(price.getStartDate())
                        && !applicationDate.isAfter(price.getEndDate()))
                .max(Comparator.comparing(Price::getPriority));
    }
}
