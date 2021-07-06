package com.savings.app.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.savings.app.dto.CustomerResponse;
import com.savings.app.dto.CustomerTransaction;
import com.savings.app.dto.TransactionResponse;
import com.savings.app.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	public Customer findCustomerByEmail(String email);
	
	@Query("SELECT new com.savings.app.dto.TransactionResponse(c.fullname, t.customerid, SUM(t.credit),SUM(t.debit)) FROM Customer AS c JOIN c.transaction AS t GROUP BY c.fullname")
	public Collection<TransactionResponse> getJoinInformation();
	
    @Query("SELECT new com.savings.app.dto.CustomerTransaction(c.fullname, t.customerid,SUM(t.credit),SUM(t.debit), t.transactionDate) FROM Customer AS c JOIN c.transaction AS t WHERE t.customerid = ?1")
	public Collection<CustomerTransaction> getCustomerTransaction(Integer id);
	
	
}
