package com.example.Airline.Reservation.System.controller;

import com.example.Airline.Reservation.System.dto.ticketDto;
import com.example.Airline.Reservation.System.service.ticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tickets")
public class ticketController {
    @Autowired
    private ticketService ticketService;

    @PostMapping("/create")
    public ticketDto createTicket(@RequestBody ticketDto ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ticketDto> getTicketById(@PathVariable String id) {
        ticketDto ticket = ticketService.getTicketById(id);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable String id) {
        return ticketService.deleteTicket(id);
    }
}
