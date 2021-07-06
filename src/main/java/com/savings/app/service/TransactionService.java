package com.savings.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.savings.app.models.Transaction;
import com.savings.app.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public void addDebit(Transaction transaction)
	{
		transactionRepository.save(transaction);
	}
	
	public void addCredit(Transaction transaction)
	{
		transactionRepository.save(transaction);
	}
	
	public List<Transaction> getAllTransaction()
	{
		return (List<Transaction>) transactionRepository.findAll();
	}
	
	public int getTotalCredit()
	{
		return  transactionRepository.sumCredit();
	}
	
	public int getTotalDebit()
	{
		return  transactionRepository.sumDebit();
	}
	
	
}
