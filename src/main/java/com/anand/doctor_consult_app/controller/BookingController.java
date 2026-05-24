package com.anand.doctor_consult_app.controller;

import com.anand.doctor_consult_app.entity.Booking;
import com.anand.doctor_consult_app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> bookSlot(
            @RequestParam Long slotId,
            @RequestParam String userName
    ){
        try{
            Booking booking = bookingService
                    .bookSlot(slotId, userName);

            return ResponseEntity.ok(booking);
        } catch(IllegalStateException e){
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getBookings() {

        return ResponseEntity.ok(
                bookingService.getAllBookings()
        );
    }
}
