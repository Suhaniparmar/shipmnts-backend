package org.example.shipmntsbackend.service;

import org.example.shipmntsbackend.entity.Location;
import org.example.shipmntsbackend.entity.ProductTransaction;
import org.example.shipmntsbackend.repository.LocationRepository;
import org.example.shipmntsbackend.repository.ProductTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TransactionService {
    @Autowired
    private LocationRepository locationRepo;
    @Autowired
    private ProductTransactionRepository productRepo;

    public String addProducts(String warehouseCode, LocalDate date, List<Map<String, Object>> products) {
        for (Map<String, Object> p : products) {
            String locCode = (String) p.get("location_code");
            Location loc = locationRepo.findByLocationCode(locCode)
                    .orElseThrow(() -> new RuntimeException("Invalid location: " + locCode));

            if (!loc.getLocationCode().startsWith(warehouseCode)) {
                return "Location " + locCode + " doesn’t belong to warehouse " + warehouseCode;
            }

            ProductTransaction tx = new ProductTransaction();
            tx.setWarehouseCode(warehouseCode);
            tx.setLocationCode(locCode);
            tx.setProductCode((String) p.get("product_code"));
            tx.setQuantity((int) p.get("qty"));
            tx.setVolume((double) p.get("volume"));
            tx.setTransactionDate(date);
            productRepo.save(tx);
        }
        return "Products added successfully";
    }
}
