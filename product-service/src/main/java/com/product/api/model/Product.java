package com.product.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long productId;
    private String productName;
    private String productDescription;
    private Integer productOriginalPrice;
    private Integer productDiscountedPrice;
    private Boolean productStock;
}
