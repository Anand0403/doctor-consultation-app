package com.anand.doctor_consult_app.repository;

import com.anand.doctor_consult_app.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {


}
