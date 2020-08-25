package com.narasimha.customerservice.persistence.dao;

import java.util.List;

import com.narasimha.customerservice.entity.CustomerEntity;

public interface CustomerDao {

	CustomerEntity createCustomer(CustomerEntity customerEntity);

	List<CustomerEntity> getAllCustomers();

	CustomerEntity retrieveCustomerById(Integer customerId);

	boolean isExistsCustomerId(Integer customerId);

	List<CustomerEntity> searchCustomersByFirstNameOrLastName(String fname , String lname);

}
