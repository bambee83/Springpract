package com.sparta.springiocdifin.repository;

import com.sparta.springiocdifin.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    
}
