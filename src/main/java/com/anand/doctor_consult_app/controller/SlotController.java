package com.anand.doctor_consult_app.controller;

import com.anand.doctor_consult_app.entity.Slot;
import com.anand.doctor_consult_app.entity.Doctor;
import com.anand.doctor_consult_app.repository.DoctorRepository;
import com.anand.doctor_consult_app.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slots")
@CrossOrigin("*")
public class SlotController {

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/{doctorId}")
    public Slot addSlot(
            @PathVariable Long doctorId,
            @RequestBody Slot slot
    ){
        Doctor doctor = doctorRepository
                .findById(doctorId)
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found"));
        slot.setDoctor(doctor); // Hibernate -> Stores the docterId(foreign key) in slot table

        return slotRepository.save(slot);
    }

    @GetMapping("/{doctorId}")
    public List<Slot> getSlot(
            @PathVariable Long doctorId
    ){
        return slotRepository.findByDoctorIdAndBookedFalse(doctorId);
    }
}
