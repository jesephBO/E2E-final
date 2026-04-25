package org.e2e.labe2e01.passenger.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.e2e.labe2e01.passenger.infrastructure.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;


    public Passenger mostrarPassenger(Long id){
        return passengerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Pasajero no encontrado"));
    }

    public Passenger patchPassenger(Long id, Coordinate coordinate){
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Pasajero no encontrado"));
        passenger.setCoordinate(coordinate);
        return passengerRepository.save(passenger);
    }

    public List<Coordinate> getbyPlace(Long id){
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Pasajero no encontrado"));
        return passenger.getPlacesList();
    }

    public void deletePassenger(Long id){
        passengerRepository.deleteById(id);
    }

    public void deletebyCoordinateId(Long id, Long coordinateId){
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Pasajero no encontrado"));
        Coordinate coordinateTemp = new Coordinate();
        coordinateTemp.setId(coordinateId);
        passenger.removePlace(coordinateTemp);
        passengerRepository.save(passenger);
    }

}
