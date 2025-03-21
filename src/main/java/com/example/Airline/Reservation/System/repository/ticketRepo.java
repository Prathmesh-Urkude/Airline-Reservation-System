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

    public Optional<ticketDto> getTicketById(String id) {
        return Optional.ofNullable(tickets.get(id));
    }

    public boolean existsById(String id) {
        return tickets.containsKey(id);
    }

    public String deleteTicket(String id) {
        return tickets.remove(id) != null ? "Ticket deleted successfully" : "Ticket not found";
    }
}
