package com.unwe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unwe.model.Spent;

@Repository

public interface SpentRepository extends JpaRepository<Spent, Long> {

}