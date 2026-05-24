package com.anand.doctor_consult_app.repository;

import com.anand.doctor_consult_app.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    // extends JpaRepository<Doctor, Long> --> Gives automatic methods like save(), findAll(), findById(), deleteById(), count()
    // Doctor -> Entity Type, Long -> Primary key datatype

    List<Doctor> findBySpecialization(String specialization);
}
