package com.slama.inventoryservice.service;

import com.slama.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public record InventoryService(
        InventoryRepository inventoryRepository
) {

    @Transactional(readOnly = true)
    public boolean checkInStock(String code) {
        return inventoryRepository.findByCode(code).isPresent();
    }

}
