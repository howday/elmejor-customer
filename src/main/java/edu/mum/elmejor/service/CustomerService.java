package edu.mum.elmejor.service;

import java.util.List;

import edu.mum.elmejor.domain.Customer;
 
public interface CustomerService {

	public void save(Customer customer);
	public List<Customer> findAll();
	public Customer findByEmail(String email);
	public void update(Customer customer);
	public void delete(Long id);
}
