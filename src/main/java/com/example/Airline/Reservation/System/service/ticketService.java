package com.example.Airline.Reservation.System.service;

import com.example.Airline.Reservation.System.dto.ticketDto;
import com.example.Airline.Reservation.System.repository.ticketRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ticketService {
    private ticketRepo ticketRepository;

    public ticketDto createTicket(ticketDto ticket) {
        if (ticketRepository.existsById(ticket.getId())) {
            throw new IllegalArgumentException("Ticket with this ID already exists.");
        }
        return ticketRepository.createTicket(ticket);
    }

    public Optional<ticketDto> getTicketById(String id) {
        return ticketRepository.getTicketById(id);
    }

    public String deleteTicket(String id) {
        if (!ticketRepository.existsById(id)) {
            throw new IllegalArgumentException("Ticket not found.");
        }
        return ticketRepository.deleteTicket(id);
    }
}
