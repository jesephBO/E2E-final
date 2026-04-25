package org.e2e.labe2e01.ride.domain;

import jakarta.persistence.*;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.driver.domain.Driver;
import org.e2e.labe2e01.passenger.domain.Passenger;

import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@Setter
@Getter

public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Status status;

    private ZonedDateTime arrivalDate;
    private ZonedDateTime departureDate;

    @JoinColumn(name = "destination_coordinates_id", nullable = false)
    private Coordinate destinationCoordinates;

    @JoinColumn(name = "origin_coordinates_id", nullable = false)
    private Coordinate originCoordinates;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String destinationName;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String originName;


}