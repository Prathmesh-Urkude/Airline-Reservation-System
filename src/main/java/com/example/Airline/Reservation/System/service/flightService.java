package com.example.Airline.Reservation.System.service;

import com.example.Airline.Reservation.System.dto.flightDto;
import com.example.Airline.Reservation.System.repository.flightRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class flightService {
    private final flightRepo flightRepo;

    public flightService(flightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    public List<flightDto> getAllFlights() {
        return flightRepo.getAllFlights();
    }
}
