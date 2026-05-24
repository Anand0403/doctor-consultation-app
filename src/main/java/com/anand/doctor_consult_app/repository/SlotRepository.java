package com.anand.doctor_consult_app.repository;


import com.anand.doctor_consult_app.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {

    List<Slot> findByDoctorIdAndBookedFalse(Long doctorId);
}
