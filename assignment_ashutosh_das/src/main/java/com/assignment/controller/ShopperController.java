package com.assignment.controller;

import com.assignment.entity.Shopper;
import com.assignment.service.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppers")
public class ShopperController {
    @Autowired
    private ShopperService shopperService;

    @GetMapping("/{shopperId}")
    public ResponseEntity<Shopper> getShopperById(@PathVariable String shopperId) {
        Shopper shopper = shopperService.getShopperById(shopperId);
        if (shopper != null) {
            return ResponseEntity.ok(shopper);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Shopper>> getAllShoppers() {
        List<Shopper> shoppers = shopperService.getAllShoppers();
        return ResponseEntity.ok(shoppers);
    }

    @PostMapping
    public ResponseEntity<Shopper> createShopper(@RequestBody Shopper shopper) {
        Shopper createdShopper = shopperService.createShopper(shopper);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShopper);
    }
}

