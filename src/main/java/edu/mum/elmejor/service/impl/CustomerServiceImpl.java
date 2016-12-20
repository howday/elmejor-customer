package edu.mum.elmejor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.elmejor.dao.CustomerDao;
import edu.mum.elmejor.domain.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements edu.mum.elmejor.service.CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public void save(Customer customer) {
		customerDao.save(customer);
	}

	public List<Customer> findAll() {
		return (List<Customer>) customerDao.findAll();
	}

	public Customer findByEmail(String email) {
		return customerDao.findByEmail(email);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public void delete(Long  id) {
		customerDao.delete(id);
		
	}

}
