package com.example.Airline.Reservation.System.repository;

import com.example.Airline.Reservation.System.dto.flightDto;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Component

public class flightRepo {
    private final List<flightDto> flight = new ArrayList<>();

    @PostConstruct
    public void init() {
        flight.add(new flightDto(1, "AirIndia", "Nagpur", "Hyderabad",
                "2025-03-21 T 22:00:00", "2025-03-22 T 01:00:00", 4000.0));
    }

    public List<flightDto> getAllFlights() {
        return flight;
    }
}
