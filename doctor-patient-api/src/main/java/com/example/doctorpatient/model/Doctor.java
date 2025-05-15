package com.example.doctorpatient.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3)
    private String name;

    @Enumerated(EnumType.STRING)
    private City city;

    @Email
    private String email;

    @Size(min = 10)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;
}