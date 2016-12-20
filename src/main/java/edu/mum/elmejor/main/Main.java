package edu.mum.elmejor.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.elmejor.domain.Address;
import edu.mum.elmejor.domain.Customer;
import edu.mum.elmejor.service.CustomerService;

public class Main {

	final static Logger logger = LoggerFactory.getLogger(Main.class);
	private static ApplicationContext ctx;

	public static void main(String[] args) {

		ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
		CustomerService customerService = (CustomerService) ctx.getBean("customerServiceImpl");

		/**
		 * To add customer to the database
		 */
		addUser(customerService);

		/**
		 * to search user with given email address
		 */
		Customer customer = lookUserByEmail(customerService);
		logger.info("****** Customer ******");
		logger.info(customer.toString());

		customer.setFirstName("Updated Mark");
		customerService.update(customer);
		logger.info("---> User updated successfully !!");

		customerService.delete(customer.getId());
		logger.info("---> User deleted successfully !!");

	}

	public static void addUser(CustomerService customerService) {
		Customer customer = new Customer();
		customer.setFirstName("Mark");
		customer.setLastName("Henry");
		customer.setEmail("mark.henry@gmail.com");
		
		Address address = new Address();
		address.setCity("Fairfield");
		address.setMember(customer);
		address.setState("Iowa");
		address.setZipCode("52557");
		address.setStreet("1000N Street");
		
		customer.setAddress(address);
		customerService.save(customer);
		logger.info("Customer saved successfully!!");

	}

	public static Customer lookUserByEmail(CustomerService userService) {
		return userService.findByEmail("mark.henry@gmail.com");

	}

}