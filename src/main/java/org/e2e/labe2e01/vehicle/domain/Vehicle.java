package org.e2e.labe2e01.vehicle.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.e2e.labe2e01.driver.domain.Driver;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Vehicle {
    @Id
    private Long id;

    @Column(unique = true, nullable = false,columnDefinition = "VARCHAR(255)")
    private String licensePlate;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private Integer fabricationYear;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String brand;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String model;

    @OneToOne
    private Driver conductor;
}