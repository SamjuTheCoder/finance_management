package com.savings.app.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.savings.app.models.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
	@Query("SELECT SUM(debit) FROM Transaction")
	public int sumDebit();
	
	@Query("SELECT SUM(credit) FROM Transaction")
	public int sumCredit();
}