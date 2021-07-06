package com.savings.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.savings.app.models.SavingType;

@Repository
public interface SavingstypeRepository extends CrudRepository<SavingType, Long> {
	
	//public SavingType geSavingType(); 
}
