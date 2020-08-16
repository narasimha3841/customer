package com.narasimha.customerservice.service;

import java.util.List;

import com.narasimha.customerservice.dto.AddressDTO;
import com.narasimha.customerservice.dto.CustomerDTO;
import com.narasimha.customerservice.model.response.CustomerResponse;
import com.narasimha.customerservice.model.response.JSONResponse;
import com.narasimha.customerservice.model.response.ServiceResponse;

public interface CustomerService {

	ServiceResponse<CustomerResponse> createCustomer(CustomerDTO customerDTO);

	ServiceResponse<List<CustomerResponse>> retrieveAllCustomers();

	ServiceResponse<CustomerResponse> retrieveCustomerById(Integer customerId);

	ServiceResponse<JSONResponse> updateCustomerAddress(Integer customerId, AddressDTO addressDTO);

	ServiceResponse<List<CustomerResponse>> searchCustomersByFirstNameOrLastName(String searchKeyword);

}
