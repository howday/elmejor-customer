package edu.mum.elmejor.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.elmejor.dao.CustomerDao;
import edu.mum.elmejor.domain.Customer;

@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

	public CustomerDaoImpl() {
		super.setDaoType(Customer.class);
	}

	@PersistenceContext
	protected EntityManager entityManager;

	public Customer findByEmail(String email) {

		Query query = entityManager.createQuery("select u from Customer u  where u.email =:email");
		return (Customer) query.setParameter("email", email).getSingleResult();

	}

}