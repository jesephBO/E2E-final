package org.e2e.labe2e01.driver.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.driver.infrastructure.DriverRepository;
import org.e2e.labe2e01.vehicle.domain.Vehicle;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public Driver mostrarDriver(Long id){return driverRepository.findById(id);}

    public Driver save(Driver driver){return repository.save(driver);}

    public void deleteDriver(Long id){
        repository.deleteById(id);
    }

    public Driver putDriver(Long id,Driver driver){
        Driver actual = repository.findById(id);
        driver.setId(actual.getId());
        return repository.save(driver);
    }

    public Driver patchbyLatLon(Long id, double latitude, double longitude){
        Driver driver = repository.findById(id);
        Coordinate coord = driver.getCoordinate();
        coord.setLatitude(latitude);
        coord.setLongitude(longitude);
        driver.setCoordinate(coord);
        return repository.save(driver);
    }

    public Driver patchbyCar(Long id, Vehicle vehicle){
        Driver driver = repository.findById(id);
        driver.setVehicle(vehicle);
        return repository.save(driver);
    }





}
