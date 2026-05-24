package com.anand.doctor_consult_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data

public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime slotTime;

    private boolean booked = false;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @JsonIgnore
    @OneToOne(
            mappedBy = "slot",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Booking booking;
}