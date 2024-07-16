package com.example.priceapp.infrastructure.adapters.input;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.priceapp.application.ports.input.GetPriceQuery;
import com.example.priceapp.domain.models.Price;
import com.example.priceapp.exception.InvalidParameterException;
import com.example.priceapp.exception.PriceNotFoundException;

@RestController
public class PriceController {

    @Autowired
    private GetPriceQuery getPriceQuery;

    @GetMapping("/price")
    public ResponseEntity<Price> getPrice(
            @RequestParam Long productId,
            @RequestParam Long brandId,
            @RequestParam String applicationDate) {
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(applicationDate, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
        } catch (Exception e) {
            throw new InvalidParameterException("Bad format request " + applicationDate);
        }
        Optional<Price> price = getPriceQuery.getPrice(productId, brandId, date);
        if (price.isPresent()) {
            return ResponseEntity.ok(price.get());
        } else {
            throw new PriceNotFoundException(
                    "Applicable price not found for the given product ID and brand ID at the specified date and time");
        }
    }
}
