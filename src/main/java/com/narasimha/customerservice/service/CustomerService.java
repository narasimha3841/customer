package com.narasimha.customerservice.service;

import java.util.List;

import com.narasimha.customerservice.dto.AddressDTO;
import com.narasimha.customerservice.dto.CustomerDTO;
import com.narasimha.customerservice.model.response.CustomerResponse;
import com.narasimha.customerservice.model.response.JSONResponse;

public interface CustomerService {

	CustomerResponse createCustomer(CustomerDTO customerDTO);

	List<CustomerResponse> retrieveAllCustomers();

	CustomerResponse retrieveCustomerById(Integer customerId);

	JSONResponse updateCustomerAddress(Integer customerId, AddressDTO addressDTO);

	List<CustomerResponse> searchCustomersByFirstNameOrLastName(String searchKeyword);

}
