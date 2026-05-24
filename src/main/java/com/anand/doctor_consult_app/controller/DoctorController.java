package com.anand.doctor_consult_app.controller;

import com.anand.doctor_consult_app.entity.Doctor;
import com.anand.doctor_consult_app.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin("*")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    // ADD DOCTOR
    @PostMapping
    public Doctor addDoctor(
            @RequestBody Doctor doctor
    ) {

        return doctorRepository.save(doctor);
    }

    // GET ALL / FILTER
    @GetMapping
    public List<Doctor> getDoctors(
            @RequestParam(required = false)
            String specialization
    ) {

        if (specialization != null) {

            return doctorRepository
                    .findBySpecialization(specialization);
        }

        return doctorRepository.findAll();
    }

    // UPDATE DOCTOR
    @PutMapping("/{id}")
    public Doctor updateDoctor(
            @PathVariable Long id,
            @RequestBody Doctor updatedDoctor
    ) {

        Doctor doctor = doctorRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found"));

        doctor.setName(updatedDoctor.getName());
        doctor.setSpecialization(
                updatedDoctor.getSpecialization()
        );
        doctor.setExperience(
                updatedDoctor.getExperience()
        );
        doctor.setFee(updatedDoctor.getFee());

        return doctorRepository.save(doctor);
    }

    // DELETE DOCTOR
    @DeleteMapping("/{id}")
    public String deleteDoctor(
            @PathVariable Long id
    ) {

        doctorRepository.deleteById(id);

        return "Doctor deleted successfully";
    }
}