package org.e2e.labe2e01.ride.application;


import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.ride.domain.Ride;
import org.e2e.labe2e01.ride.domain.RideService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ride")
@RequiredArgsConstructor
public class RideController {
    private final RideService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ride createRide(@RequestBody Ride ride){
        return service.createRide(ride);
    }

    @GetMapping("/{passengerId}")
    public Page<Ride> getRidesByPassanger(@PathVariable Long passangerId,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size){
        return service.getRidesByPassanger(passangerId,page,size);
    }

    @PatchMapping("/{rideId}/assign/{driverId}")
    public Ride assignDriver(
            @PathVariable Long rideId,
            @PathVariable Long driverId) {

        return service.assignDriver(rideId, driverId);
    }
    @PatchMapping("/{id}")
    public Ride updateRide(
            @PathVariable Long id,
            @RequestBody Ride ride) {

        return service.updateRide(id, ride);
    }
}
