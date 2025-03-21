package com.example.Airline.Reservation.System.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ticketDto {
    private String id;
    private String flightId;
    private String passengerName;
    private String email;
    private String phone;
    private String seatNumber;
    private String status;
}