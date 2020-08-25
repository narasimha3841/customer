package com.narasimha.customerservice.persistence.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narasimha.customerservice.entity.CustomerEntity;
import com.narasimha.customerservice.persistence.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	/** variable to hold CustomerRepository object */
	private CustomerRepository customerRepository;
	
	/** variable to hold logger object */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);
	
	@Autowired
	public CustomerDaoImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public CustomerEntity createCustomer(CustomerEntity customerEntity) {
		return customerRepository.save(customerEntity);

	}

	@Override
	public List<CustomerEntity> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public CustomerEntity retrieveCustomerById(Integer customerId) {
		return customerRepository.getOne(customerId);
	}

	@Override
	public boolean isExistsCustomerId(Integer customerId) {
		return customerRepository.existsById(customerId);
	}

	@Override
	public List<CustomerEntity> searchCustomersByFirstNameOrLastName(String fname , String lname) {
		return customerRepository.searchCustomersByFirstNameOrLastName(fname , lname);
	}

}
