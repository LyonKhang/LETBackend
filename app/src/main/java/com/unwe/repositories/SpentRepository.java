package com.unwe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unwe.entities.Spent;

@Repository
public interface SpentRepository extends CrudRepository<Spent, Long> {
}