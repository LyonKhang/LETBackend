package com.unwe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unwe.entities.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

}
