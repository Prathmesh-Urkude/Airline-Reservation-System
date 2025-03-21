package com.example.Airline.Reservation.System.controller;

import com.example.Airline.Reservation.System.dto.flightDto;
import com.example.Airline.Reservation.System.service.flightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class flightController {
    private final flightService flightService;

    @Autowired

    public flightController(flightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<flightDto> getAllFlights(@RequestParam(required = false, defaultValue = "asc") String sort) {
        return flightService.getAllFlights(sort);
    }

    @GetMapping("/{id}")
    public ResponseEntity<flightDto> getFlightById(@PathVariable Integer id) {
        Optional<flightDto> flight = flightService.getFlightById(id);
        return flight.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/schedules")
    public ResponseEntity<List<flightDto>> getFlightSchedules(@PathVariable Integer id, @RequestParam String dates) {
        List<flightDto> schedules = flightService.getFlightSchedules(id, dates);
        return schedules.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(schedules);
    }

    @PostMapping("/add")
    public ResponseEntity<flightDto> addFlight(@RequestBody flightDto flight) {
        flightDto savedFlight = flightService.addFlight(flight);
        return ResponseEntity.ok(savedFlight);
    }
}
