package com.nithin.lmsaipractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nithin.lmsaipractice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
