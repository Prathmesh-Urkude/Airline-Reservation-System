package com.example.Airline.Reservation.System.service;

import com.example.Airline.Reservation.System.dto.flightDto;
import com.example.Airline.Reservation.System.repository.flightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class flightService {

    @Autowired

    public flightService(flightRepo flightRepo) {
    }

    public List<flightDto> getAllFlights(String sortOrder) {
        return com.example.Airline.Reservation.System.repository.flightRepo.getAllFlightsSorted(sortOrder);
    }

    public Optional<flightDto> getFlightById(Integer id) {
        return com.example.Airline.Reservation.System.repository.flightRepo.getFlightById(id);
    }

    public List<flightDto> getFlightSchedules(Integer id, String date) {
        return flightRepo.findByIdAndDepartureDate(id, date);
    }

    public flightDto addFlight(flightDto flight) {
        return flightRepo.save(flight);
    }
}
