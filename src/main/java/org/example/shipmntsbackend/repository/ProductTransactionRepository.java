package org.example.shipmntsbackend.repository;

import org.example.shipmntsbackend.entity.ProductTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTransactionRepository extends JpaRepository<ProductTransaction, Long> {
    List<ProductTransaction> findByWarehouseCodeAndLocationCodeAndProductCodeAndDeliveredFalse(
            String warehouseCode, String locationCode, String productCode);
}
