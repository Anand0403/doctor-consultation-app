package com.anand.doctor_consult_app.service;

import com.anand.doctor_consult_app.entity.Booking;
import com.anand.doctor_consult_app.entity.Slot;
import com.anand.doctor_consult_app.repository.BookingRepository;
import com.anand.doctor_consult_app.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // BOOK SLOT
    public Booking bookSlot(
            Long slotId,
            String userName
    ) {

        // Find slot
        Slot slot = slotRepository
                .findById(slotId)
                .orElseThrow(() ->
                        new RuntimeException("Slot not found"));

        // Prevent double booking
        if (slot.isBooked()) {

            throw new IllegalStateException(
                    "Slot Already Booked!"
            );
        }

        // Mark slot booked
        slot.setBooked(true);

        slotRepository.save(slot);

        // Create booking
        Booking booking = new Booking();

        booking.setUserName(userName);

        booking.setDoctor(slot.getDoctor());

        booking.setSlotTime(slot.getSlotTime());

        // IMPORTANT
        booking.setSlot(slot);

        // Save booking
        return bookingRepository.save(booking);
    }

    // GET ALL BOOKINGS
    public List<Booking> getAllBookings() {

        return bookingRepository.findAll();
    }
}