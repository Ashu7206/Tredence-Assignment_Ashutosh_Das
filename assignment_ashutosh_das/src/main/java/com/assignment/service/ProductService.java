package com.assignment.service;

import com.assignment.entity.Product;
import com.assignment.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByShopper(Long shopperId, String category, String brand) {
        if (category != null && brand != null) {
            return productRepository.findByShopperIdAndCategoryAndBrand(shopperId, category, brand);
        } else if (category != null) {
            return productRepository.findByShopperIdAndCategory(shopperId, category);
        } else if (brand != null) {
            return productRepository.findByShopperIdAndBrand(shopperId, brand);
        } else {
            return productRepository.findByShopperId(shopperId);
        }
    }

    public Page<Product> getProductsByShopperWithFilters(Long shopperId, String category, String brand, Pageable pageable) {
        if (category != null && brand != null) {
            return productRepository.findByShopperIdAndCategoryAndBrand(shopperId, category, brand, pageable);
        } else if (category != null) {
            return productRepository.findByShopperIdAndCategory(shopperId, category, pageable);
        } else if (brand != null) {
            return productRepository.findByShopperIdAndBrand(shopperId, brand, pageable);
        } else {
            return productRepository.findByShopperId(shopperId, pageable);
        }
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
