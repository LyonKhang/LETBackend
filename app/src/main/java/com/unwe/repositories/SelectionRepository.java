package com.unwe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unwe.model.Selection;

@Repository
public interface SelectionRepository extends CrudRepository<Selection, Long> {

}
