package com.assignment.service;

import com.assignment.entity.Shopper;
import com.assignment.repository.ShopperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopperService {
    @Autowired
    private ShopperRepository shopperRepository;

    public Shopper getShopperById(String shopperId) {
        return shopperRepository.findByShopperId(shopperId);
    }

    public Shopper createShopper(Shopper shopper) {

        return shopperRepository.save(shopper);
    }

    public List<Shopper> getAllShoppers() {
       return shopperRepository.findAll();
    }
}
