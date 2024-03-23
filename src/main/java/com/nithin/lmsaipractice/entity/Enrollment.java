package com.nithin.lmsaipractice.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "enrollment")
@Data
public class Enrollment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User enrolledStudent;

    @ManyToOne(cascade = CascadeType.ALL)
    private Subject subject;

   // Constructors, getters, and setters
}