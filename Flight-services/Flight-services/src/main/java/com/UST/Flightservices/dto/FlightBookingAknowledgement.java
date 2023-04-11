package com.UST.Flightservices.dto;

import com.UST.Flightservices.entity.Passengerinfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightBookingAknowledgement {
    private String status;
    private double amount;
    private String pnrno;
    private Passengerinfo passengerinfo;
}
