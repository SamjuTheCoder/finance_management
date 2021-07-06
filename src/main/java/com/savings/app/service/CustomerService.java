package com.savings.app.service;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savings.app.dto.CustomerTransaction;
import com.savings.app.dto.TransactionResponse;
import com.savings.app.models.Customer;
import com.savings.app.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer findCustomerEmail(String email)
	{
		return customerRepository.findCustomerByEmail(email);
	}
	
	public void saveCustomerDetails(Customer customer)
	{
		//customer.setPassword(bCryptPasswordEncoder.encode(register.getPassword()));
		//customer.setActive(1);
		 // userRole = roleRespository.findByRole("USER");
		//customer.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		  
		 customerRepository.save(customer);
	}
	
	public List<Customer> getAllCustomers()
	{
		return (List<Customer>) customerRepository.findAll();
	}
	
	public Collection<TransactionResponse> getCustomersTransctions()
	{
		return (Collection<TransactionResponse>) customerRepository.getJoinInformation();
	}
	
	public Long countAllCustomers()
	{
		return customerRepository.count();
	}
	
	public Collection<CustomerTransaction> getIndividualTransctions(int id)
	{
		return (Collection<CustomerTransaction>) customerRepository.getCustomerTransaction(id);
	}
	
}
