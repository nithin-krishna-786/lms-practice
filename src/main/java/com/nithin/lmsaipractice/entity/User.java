package com.nithin.lmsaipractice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique = true)
	private String email;

	private String password;

	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
	private Set<Subject> subjectsTeaching;

	@OneToMany(mappedBy = "hod", cascade = CascadeType.ALL)
	private Set<Department> departments;

	// Constructors, getters, and setters
}
