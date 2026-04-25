package org.e2e.labe2e01.passenger.application;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.passenger.domain.Passenger;
import org.e2e.labe2e01.passenger.domain.PassengerService;
import org.e2e.labe2e01.passenger.infrastructure.PassengerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService service;

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassenger(@PathVariable Long id){
        Passenger passengerobt = service.getPassenger(id);
        return ResponseEntity.status(HttpStatus.OK).body(passengerobt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<void> deletebyId(@PathVariable Long id){
        service.deletebyId(id);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Passenger> patchPassenger(@PathVariable Long id, @RequestBody Coordinate coordinate){
        Passenger passengeract = service.patchPassenger(id,coordinate);
        return ResponseEntity.status(HttpStatus.OK).body(passengeract);
    }

    @GetMapping("/{id}/places")
    public ResponseEntity<List<Coordinate>> getbyPlace(@PathVariable Long id){
        List<Coordinate> listadrivers= service.geybyPlace(id);
        return ResponseEntity.status(HttpStatus.OK).body(listadrivers);
    }

    @DeleteMapping("/{id}/places/{coordinateId}")
    public ResponseEntity<void> deletebyCoordinateId(@PathVariable Long id, Long coordinateId){
        service.deletebyCoordinateId(id,coordinateId);
        return ResponseEntity.notFound().build();
    }


}
