package com.pricing.api.controller;

import com.pricing.api.model.Price;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PricingController {

    @GetMapping("/price/{productId}")
    public Price getPrice(@PathVariable Long productId) {
        List<Price> priceList = getPriceList();
        Price price = priceList.stream().filter(pr -> pr.getProductId().equals(productId)).findAny().orElseGet(() -> new Price());
        return new Price(price.getProductId(), price.getPriceId(), price.getOriginalPrice(), price.getDiscountedPrice());
    }

    public List<Price> getPriceList() {
        // get this list from Database
        List<Price> priceList = Arrays.asList(
                new Price(123L, 123L, 1100, 950),
                new Price(654L, 654L, 2500, 1900),
                new Price(289L, 289L, 3000, 2800)
        );
        return priceList;
    }
}
