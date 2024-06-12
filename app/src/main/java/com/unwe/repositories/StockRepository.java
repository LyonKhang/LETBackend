package com.unwe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unwe.entities.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
}