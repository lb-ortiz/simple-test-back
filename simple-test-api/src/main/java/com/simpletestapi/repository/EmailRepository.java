package com.simpletestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simpletestapi.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{
}
