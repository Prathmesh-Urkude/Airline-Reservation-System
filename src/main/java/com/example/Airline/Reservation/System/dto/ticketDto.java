package com.example.Airline.Reservation.System.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ticketDto {
    private String id = UUID.randomUUID().toString(); // to auto-generate ticket id

    @NotBlank(message = "Flight id is required.")
    private String flightId;

    @NotBlank(message = "Passenger name is required.")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Passenger name should contain only alphabets.")
    private String passengerName;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email format.")
    private String email;

    @NotBlank(message = "Phone number is required.")
    private String phone;

    @NotBlank(message = "Seat number is required.")
    @Pattern(regexp = "^[A-Z]{1}\\d{1,2}$", message = "Invalid seat format. Example: A1, B12.")
    private String seatNumber;

    @NotNull(message = "Status cannot be null")
    private String status;
}