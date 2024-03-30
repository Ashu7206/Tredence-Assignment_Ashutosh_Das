package com.assignment.repository;

import com.assignment.entity.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ShopperRepository.java
@Repository
public interface ShopperRepository extends JpaRepository<Shopper, Long> {
    Shopper findByShopperId(String shopperId);
}


