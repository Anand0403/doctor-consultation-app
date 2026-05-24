package com.anand.doctor_consult_app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private LocalDateTime slotTime;

    @ManyToOne
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;
}