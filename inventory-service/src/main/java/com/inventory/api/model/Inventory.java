package com.inventory.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    private Long productId;
    private Long inventoryId;
    private Boolean stockAvailability;
}
