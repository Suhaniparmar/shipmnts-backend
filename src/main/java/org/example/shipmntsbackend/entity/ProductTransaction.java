package org.example.shipmntsbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class ProductTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String warehouseCode;
    private String locationCode;
    private String productCode;

    private int quantity;
    private double volume;

    private LocalDate transactionDate;
    private boolean delivered = false;

    // Getters and Setters
}