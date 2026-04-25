package org.e2e.labe2e01.vehicle.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.vehicle.infrastructure.VehicleRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public void save(Vehicle vehicle){vehicleRepository.save(vehicle);}

    /*public Vehicle findById(Long id){
        return vehicleRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Vehicle no encontrado"));
    }*/


}
