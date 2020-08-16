package com.narasimha.customerservice.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narasimha.customerservice.entity.CustomerEntity;
import com.narasimha.customerservice.persistence.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	/** variable to hold CustomerRepository object */
	@Autowired
	private CustomerRepository customerRepository;

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
	public List<CustomerEntity> searchCustomersByFirstNameOrLastName(String searchKeyword) {
		return customerRepository.searchCustomersByFirstNameOrLastName(searchKeyword);
	}

}
