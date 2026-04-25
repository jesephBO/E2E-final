package org.e2e.labe2e01.driver.application;


import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.driver.domain.Driver;
import org.e2e.labe2e01.driver.domain.DriverService;
import org.e2e.labe2e01.driver.infrastructure.DriverRepository;
import org.e2e.labe2e01.vehicle.domain.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService service;

    @GetMapping("/{id}")
    public ResponseEntity<Driver> mostrarDriver(@PathVariable Long id){
        Driver driverobtenido = service.mostrarDriver(id);
        return ResponseEntity.status(HttpStatus.OK).body(driverobtenido);
    }

    @PostMapping
    public ResponseEntity<Driver> save(@RequestBody Driver driver){
        Driver driverguardado = service.save(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(driverguardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id){
        service.deleteDriver(id);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> putDriver(@RequestBody Driver driver,@PathVariable Long id){
        Driver driveractualizado = service.putDriver(id,driver);
        return ResponseEntity.status(HttpStatus.OK).body(driveractualizado);
    }


    @PatchMapping("/{id}/location")
    public ResponseEntity<Driver> patchbyLatLon(@PathVariable Long id,@RequestParam double latitude, @RequestParam double longitude){
        Driver driveractualizado = service.patchbyLatLon(id,latitude,longitude);
        return ResponseEntity.status(HttpStatus.OK).body(driveractualizado);
    }
    @PatchMapping("/{id}/car")
    public ResponseEntity<Driver> patchbyCar(@PathVariable Long id,@RequestBody Vehicle vehicle){
        Driver driveractualizado = service.patchbyCar(id,vehicle);
        return ResponseEntity.status(HttpStatus.OK).body(driveractualizado);
    }

}
