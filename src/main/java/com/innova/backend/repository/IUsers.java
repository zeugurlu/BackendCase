package com.innova.backend.repository;

import com.innova.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsers extends JpaRepository<Users, Integer> {
}
