package com.slama.inventoryservice.controller;

import com.slama.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public record InventoryController(
        InventoryService inventoryService
) {

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable String code){
        return inventoryService.checkInStock(code);
    }
}
