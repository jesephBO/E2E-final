package org.e2e.labe2e01.ride.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.driver.domain.Driver;
import org.e2e.labe2e01.driver.infrastructure.DriverRepository;
import org.e2e.labe2e01.ride.infrastructure.RideRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RideService {
    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;

    //POST
    public Ride createRide(Ride ride){
        if (ride.getOriginCoordinates() == null || ride.getDestinationCoordinates() == null) {
            throw new RuntimeException("Coordinates are required");
        }

        if (ride.getPrice() == null) {
            throw new RuntimeException("Price is required");}

        ride.setStatus(Status.REQUESTED);

        return rideRepository.save(ride);
    }

    //GET
    public Page<Ride> getRidesByPassanger(Long passangerId, int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return rideRepository.findByPassengerId(passangerId,pageable);
    }

    //DELETE
    public void deleteRide(Long id){
        if(!rideRepository.existsById(id)){
            throw new RuntimeException("Ride not found");
        }
        rideRepository.deleteById(id);
    }

    //PATCH /ride/{rideId}/assign/{driverId}
    public Ride assignDriver(Long rideId, Long driverId){
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(()-> new RuntimeException("Ride not found"));
        Driver driver = driverRepository(driver);
        ride.setDriver(driver);
        ride.setStatus(Status.ACCEPTED);
        return rideRepository.save(ride);
    }

    //PATCH /ride/{id}
    public Ride updateRide(Long id, Ride updatedRide) {

        Ride ride = rideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        // actualizas solo lo necesario
        if (updatedRide.getPrice() != null) {
            ride.setPrice(updatedRide.getPrice());
        }
        if (updatedRide.getOriginName() != null) {
            ride.setOriginName(updatedRide.getOriginName());
        }
        if (updatedRide.getDestinationName() != null) {
            ride.setDestinationName(updatedRide.getDestinationName());
        }
        if (updatedRide.getStatus() != null) {
            ride.setStatus(updatedRide.getStatus());
        }
        if (updatedRide.getArrivalDate() != null) {
            ride.setArrivalDate(updatedRide.getArrivalDate());
        }
        if (updatedRide.getDepartureDate() != null) {
            ride.setDepartureDate(updatedRide.getDepartureDate());
        }
        return rideRepository.save(ride);
    }
}
