package org.example.shipmntsbackend.repository;

import org.example.shipmntsbackend.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
    Optional<Location> findBylocation_code(String code);
    boolean existsBylocation_code(String code);

}
