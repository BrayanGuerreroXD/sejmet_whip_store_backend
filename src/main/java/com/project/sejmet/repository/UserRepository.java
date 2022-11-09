package com.project.sejmet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sejmet.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
}
