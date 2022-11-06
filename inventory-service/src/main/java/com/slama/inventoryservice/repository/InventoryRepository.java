package com.slama.inventoryservice.repository;

import com.slama.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>  {
    Optional<Inventory> findByCode(String code);
}
