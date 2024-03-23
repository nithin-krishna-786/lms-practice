package com.nithin.lmsaipractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nithin.lmsaipractice.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
}