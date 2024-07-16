package com.example.priceapp.infrastructure.adapters.output;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.priceapp.application.ports.output.PriceRepository;
import com.example.priceapp.domain.models.Price;
import com.example.priceapp.infrastructure.repository.SpringDataPriceRepository;
import com.example.priceapp.infrastructure.repository.entities.PriceEntity;

@Component
public class JpaPriceRepositoryAdapter implements PriceRepository {

    @Autowired
    private SpringDataPriceRepository springDataPriceRepository;

    public List<Price> findByProductIdAndBrandIdAndDateRange(Long productId, Long brandId, LocalDateTime date) {

        return springDataPriceRepository
                .findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId,
                        brandId,
                        date, date)
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());

    }

    private Price toModel(PriceEntity entity) {
        return Price.builder()
                .brandId(entity.getBrandId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priceList(entity.getPriceList())
                .productId(entity.getProductId())
                .priority(entity.getPriority())
                .price(entity.getPrice())
                .curr(entity.getCurr())
                .build();
    }
}
