package com.savings.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savings.app.models.SavingType;
import com.savings.app.repository.SavingstypeRepository;

@Service
public class SavingstypeService {

	@Autowired
	private SavingstypeRepository savingstypeRepository;
	
	
	public List<SavingType> getAllSavingType()
	{
		return (List<SavingType>) savingstypeRepository.findAll();
	}
}
