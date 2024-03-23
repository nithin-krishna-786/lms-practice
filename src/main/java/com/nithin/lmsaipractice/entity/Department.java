package com.nithin.lmsaipractice.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name")
    private String departmentName;

    @OneToOne(cascade = CascadeType.ALL)
    private User hod;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Subject> subjects;

}