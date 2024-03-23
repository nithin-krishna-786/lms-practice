package com.nithin.lmsaipractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nithin.lmsaipractice.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
