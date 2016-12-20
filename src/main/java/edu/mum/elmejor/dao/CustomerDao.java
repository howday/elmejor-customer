package edu.mum.elmejor.dao;

import edu.mum.elmejor.domain.Customer;

public interface CustomerDao extends GenericDao<Customer> {
      
	public Customer findByEmail(String email);
}
