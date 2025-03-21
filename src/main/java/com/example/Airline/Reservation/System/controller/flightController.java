package com.example.Airline.Reservation.System.controller;

import com.example.Airline.Reservation.System.dto.flightDto;
import com.example.Airline.Reservation.System.service.flightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class flightController {
    private final flightService flightService;

    public flightController(flightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<flightDto> getAllFlights() {
        return flightService.getAllFlights();
    }
}
