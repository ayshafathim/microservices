package com.UST.Flightservices.service;

import com.UST.Flightservices.dto.BookingRequest;
import com.UST.Flightservices.dto.FlightBookingAknowledgement;
import com.UST.Flightservices.entity.Passengerinfo;
import com.UST.Flightservices.entity.Paymentinfo;
import com.UST.Flightservices.exception.InsufficientAmountException;
import com.UST.Flightservices.repo.Passengerrepo;
import com.UST.Flightservices.repo.Paymentrepo;
import com.UST.Flightservices.util.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    private Passengerrepo passengerrepo;
    @Autowired
    private Paymentrepo paymentrepo;
    public FlightBookingAknowledgement bookingFlightTicket(BookingRequest request) throws InsufficientAmountException {
        Passengerinfo passengerinfo=request.getPassengerinfo();
        passengerinfo=passengerrepo.save(passengerinfo);
        Paymentinfo paymentinfo=request.getPaymentinfo();
        PaymentUtils.validateCreditLimit(paymentinfo.getAccountNo(),passengerinfo.getFare());
        paymentinfo.setPassengerId(passengerinfo.getPId());
        paymentinfo.setAmount(passengerinfo.getFare());
        paymentrepo.save(paymentinfo);
        return new FlightBookingAknowledgement("success",passengerinfo.getFare(),
                UUID.randomUUID().toString().split("-")[0],passengerinfo);
    }


}
