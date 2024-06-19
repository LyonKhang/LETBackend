package com.unwe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unwe.entities.Balance;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {
}
