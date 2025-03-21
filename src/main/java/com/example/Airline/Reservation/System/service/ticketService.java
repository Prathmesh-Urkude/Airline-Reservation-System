package com.example.Airline.Reservation.System.service;

import com.example.Airline.Reservation.System.dto.ticketDto;
import com.example.Airline.Reservation.System.repository.ticketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ticketService {
    @Autowired
    private ticketRepo ticketRepository;

    public ticketDto createTicket(ticketDto ticket) {
        return ticketRepository.createTicket(ticket);
    }

    public ticketDto getTicketById(String id) {
        return ticketRepository.getTicketById(id);
    }

    public String deleteTicket(String id) {
        return ticketRepository.deleteTicket(id);
    }
}
