package com.assignment.repository;


import com.assignment.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByShopperId(Long shopperId);
    List<Product> findByShopperIdAndCategoryAndBrand(Long shopperId, String category, String brand);
    List<Product> findByShopperIdAndCategory(Long shopperId, String category);
    List<Product> findByShopperIdAndBrand(Long shopperId, String brand);

    Page<Product> findByShopperId(Long shopperId, Pageable pageable);
    Page<Product> findByShopperIdAndCategoryAndBrand(Long shopperId, String category, String brand, Pageable pageable);
    Page<Product> findByShopperIdAndCategory(Long shopperId, String category, Pageable pageable);
    Page<Product> findByShopperIdAndBrand(Long shopperId, String brand, Pageable pageable);
}
