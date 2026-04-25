package org.e2e.labe2e01.driver.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.driver.infrastructure.DriverRepository;
import org.e2e.labe2e01.vehicle.domain.Vehicle;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public Driver mostrarDriver(Long id){
        return driverRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Conductor no encontrado"));
    }

    public Driver post(Driver driver){
        return driverRepository.save(driver);
    }

    public void deleteDriver(Long id){
        driverRepository.deleteById(id);
    }

    public Driver putDriver(Long id,Driver driver){
        Driver actual = driverRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Conductor no encontrado"));
        driver.setId(actual.getId());
        return driverRepository.save(driver);
    }

    public Driver patchbyLatLon(Long id, double latitude, double longitude){
        Driver driver = driverRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Conductor no encontrado"));
        Coordinate coord = driver.getCoordinate();
        coord.setLatitude(latitude);
        coord.setLongitude(longitude);
        driver.setCoordinate(coord);
        return driverRepository.save(driver);
    }

    public Driver patchbyCar(Long id, Vehicle vehicle){
        Driver driver = driverRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Conductor no encontrado"));
        driver.setVehicle(vehicle);
        return driverRepository.save(driver);
    }

}
