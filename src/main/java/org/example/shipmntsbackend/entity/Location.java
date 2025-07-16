package org.example.shipmntsbackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String locationCode;

    private String parentLocationCode;

    @Enumerated(EnumType.STRING)
    private LocationType type;

    @Transient
    private List<Location> childs = new ArrayList<>();

    public enum LocationType { warehouse, storage }
}
