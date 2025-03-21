package com.example.Airline.Reservation.System.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class flightDto {
    private int id;
    private String airline;
    private String arrivalTime;
    private String departureTime;
    private String source;
    private String destination;
    private double price;
}
