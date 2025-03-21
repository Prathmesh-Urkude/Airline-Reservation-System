package com.example.Airline.Reservation.System.repository;

import com.example.Airline.Reservation.System.dto.ticketDto;
import org.springframework.stereotype.Component;

import java.util.*;

@Component

public class ticketRepo {
    private final Map<String, ticketDto> tickets = new HashMap<>();

    public ticketDto createTicket(ticketDto ticket) {
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public ticketDto getTicketById(String id) {
        return tickets.get(id);
    }

    public String deleteTicket(String id) {
        return tickets.remove(id) != null ? "Ticket deleted successfully" : "Ticket not found";
    }
}
