package com.example.Airline.Reservation.System.repository;

import com.example.Airline.Reservation.System.dto.flightDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component

public class flightRepo {
    private static final List<flightDto> flight = new ArrayList<>();

    @PostConstruct
    public void init() {
        flight.add(new flightDto(1, "AirIndia", "Nagpur", "Hyderabad",
                "2025-03-21 T 22:00:00", "2025-03-22 T 01:00:00", 4000.0));

        flight.add(new flightDto(2, "IndiGo", "Delhi", "Bangalore",
                "2025-03-22 T 10:30:00", "2025-03-22 T 12:30:00", 3500.0));

        flight.add(new flightDto(3, "SpiceJet", "Mumbai", "Chennai",
                "2025-03-23 T 15:00:00", "2025-03-23 T 16:30:00", 3000.0));

        flight.add(new flightDto(4, "Vistara", "Kolkata", "Pune",
                "2025-03-24 T 08:00:00", "2025-03-24 T 09:30:00", 4500.0));
    }

    public static List<flightDto> getAllFlightsSorted(String sortOrder) {
        return flight.stream()
                .sorted(Comparator.comparing(flightDto::getId,
                        "desc".equalsIgnoreCase(sortOrder) ? Comparator.reverseOrder() : Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    public List<flightDto> getAllFlights() {
        return flight;
    }

    public static Optional<flightDto> getFlightById(Integer id) {
        return flight.stream().filter(flight -> flight.getId().equals(id)).findFirst();
    }

    public static List<flightDto> findByIdAndDepartureDate(Integer id, String date) {
        return flight.stream()
                .filter(flight -> flight.getId().equals(id) && flight.getDepartureTime().startsWith(date))
                .collect(Collectors.toList());
    }

    public static flightDto save(flightDto flights) {
        flight.add(flights);
        return flights;
    }
}
