package com.inventory.api.controller;

import com.inventory.api.model.Inventory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class InventoryController {

    @GetMapping("/inventory/{productId}")
    public Inventory getInventory(@PathVariable Long productId) {
        List<Inventory> inventoryList = getInventoryList();
        Inventory inventory = inventoryList.stream().filter(inv -> inv.getProductId().equals(productId)).findAny().orElseGet(() -> new Inventory());
        return inventory;
    }

    public List<Inventory> getInventoryList() {
        // get this list from Database
        List<Inventory> inventoryList = Arrays.asList(
                new Inventory(123L, 123L, true),
                new Inventory(654L, 654L, true),
                new Inventory(289L, 289L, false)
        );
        return  inventoryList;
    }
}
