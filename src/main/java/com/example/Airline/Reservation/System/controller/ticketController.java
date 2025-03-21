package com.example.Airline.Reservation.System.controller;

import com.example.Airline.Reservation.System.dto.ticketDto;
import com.example.Airline.Reservation.System.service.ticketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.*;

@RestController
@RequestMapping("/tickets")
public class ticketController {
    private ticketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<ticketDto> createTicket(@Valid @RequestBody ticketDto ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ticketDto> getTicketById(@PathVariable String id) {
        Optional<ticketDto> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable String id) {
        try {
            return ResponseEntity.ok(ticketService.deleteTicket(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
