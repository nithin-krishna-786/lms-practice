package com.nithin.lmsaipractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nithin.lmsaipractice.entity.Department;
import com.nithin.lmsaipractice.entity.Enrollment;
import com.nithin.lmsaipractice.entity.Subject;
import com.nithin.lmsaipractice.entity.User;
import com.nithin.lmsaipractice.repository.*;

import jakarta.persistence.EntityManager;

@Component
public class CommandLineRunnerDemo implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager; // Inject EntityManager

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        User faculty1 = new User();
        faculty1.setName("CSE Faculty");
        faculty1.setPassword("45678");
        faculty1.setEmail("csehod@hotmail.com");
        userRepository.save(faculty1);

        User faculty2 = new User();
        faculty2.setName("ECE Faculty");
        faculty2.setPassword("45678");
        faculty2.setEmail("ecehod@hotmail.com");
        userRepository.save(faculty2);

        Department cse = new Department();
        cse.setDepartmentName("CSE");
        cse = entityManager.merge(cse); // Merge to ensure entity is managed
        departmentRepository.save(cse);

        Department ece = new Department();
        ece.setDepartmentName("ECE");
        ece = entityManager.merge(ece); // Merge to ensure entity is managed
        departmentRepository.save(ece);

        cse.setHod(faculty1);
        ece.setHod(faculty2);

        Subject cse1 = new Subject();
        cse1.setName("CSE1");
        cse1.setDepartment(cse);
        cse1.setFaculty(faculty1);

        Subject cse2 = new Subject();
        cse2.setName("CSE2");
        cse2.setDepartment(cse);

        Subject ece1 = new Subject();
        ece1.setName("ECE1");
        ece1.setDepartment(ece);
        ece1.setFaculty(faculty2);

        Subject ece2 = new Subject();
        ece2.setName("ECE2");
        ece2.setDepartment(ece);

        Subject ece3 = new Subject();
        ece3.setName("ECE3");
        ece3.setDepartment(ece);

        subjectRepository.save(cse1);
        subjectRepository.save(cse2);
        subjectRepository.save(ece1);
        subjectRepository.save(ece2);
        subjectRepository.save(ece3);

        User student1 = new User();
        student1.setName("cse-student");
        student1.setPassword("12345");
        student1.setEmail("cse-student@hotmail.com");
        userRepository.save(student1);

        User student2 = new User();
        student2.setName("ece-student");
        student2.setPassword("12345");
        student2.setEmail("ece-student@hotmail.com");
        userRepository.save(student2);

        Enrollment enrollment1 = new Enrollment();
        enrollment1.setEnrolledStudent(student1);
        enrollment1.setSubject(cse1);
        enrollmentRepository.save(enrollment1);

        Enrollment enrollment2 = new Enrollment();
        enrollment2.setEnrolledStudent(student2);
        enrollment2.setSubject(ece1);
        enrollmentRepository.save(enrollment2);
    }
}