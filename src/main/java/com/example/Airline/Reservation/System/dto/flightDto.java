package com.example.Airline.Reservation.System.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString

public class flightDto {
    private Integer id;
    private String airline;
    private String source;
    private String destination;
    private String arrivalTime;
    private String departureTime;
    private double price;

}
