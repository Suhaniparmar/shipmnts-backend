package org.example.shipmntsbackend.controller;

import org.example.shipmntsbackend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/receipt")
    public ResponseEntity<?> addReceipt(@RequestBody Map<String, Object> body) {
        try {
            String warehouseCode = (String) body.get("warehouse_code");
            String dateStr = (String) body.get("transaction_date");
            LocalDate date = LocalDate.parse(dateStr);
            List<Map<String, Object>> products = (List<Map<String, Object>>) body.get("products");

            String msg = transactionService.addProducts(warehouseCode, date, products);
            boolean ok = msg.equals("Products added successfully");
            return ok ? ResponseEntity.ok(Map.of("success", true, "message", msg))
                    : ResponseEntity.badRequest().body(Map.of("success", false, "message", msg));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", e.getMessage()));
        }
    }
}