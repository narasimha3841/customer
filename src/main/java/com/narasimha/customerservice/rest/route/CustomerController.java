package com.narasimha.customerservice.rest.route;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.narasimha.customerservice.dto.AddressDTO;
import com.narasimha.customerservice.dto.CustomerDTO;
import com.narasimha.customerservice.model.response.CustomerResponse;
import com.narasimha.customerservice.model.response.JSONResponse;
import com.narasimha.customerservice.model.response.ServiceResponse;
import com.narasimha.customerservice.service.CustomerService;

/**
 * Primary controller for exposing the customer service through a REST interface
 * 
 * @author Narasimha Rao Attota
 */
@RestController
@CrossOrigin("*")
public class CustomerController {
	
	/** variable to hold customer service obj */
	@Autowired
	private CustomerService customerService;
	
	/** variable to hold logger object */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	
	/**
	 * Want to  add a new customer
	 *
	 * @param CustomerDTO customerDTO
	 * @return  ResponseEntity
	 */
	@PostMapping("/cusomters")
	public ResponseEntity<ServiceResponse<CustomerResponse>> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.createCustomer(customerDTO),  HttpStatus.CREATED);
	}
	
	/**
	 * Retrieve all customers
	 *
	 * @param CustomerDTO customerDTO
	 * @return  ResponseEntity
	 */
	@GetMapping("/cusomters")
	public ResponseEntity<ServiceResponse<List<CustomerResponse>>>  retrieveAllCustomers() {
        return new ResponseEntity<>(customerService.retrieveAllCustomers(),  HttpStatus.OK);
	}
	
	/**
	 * Retrieve one customer by it's identifier
	 *
	 * @param CustomerDTO customerDTO
	 * @return  ResponseEntity
	 */
	@GetMapping("/cusomters/{customerId}")
	public ResponseEntity<ServiceResponse<CustomerResponse>>  retrieveCustomerById(@PathVariable(value="customerId") Integer customerId) {
        return new ResponseEntity<>(customerService.retrieveCustomerById(customerId),  HttpStatus.OK);
	} 
	
	/**
	 * Search customers by first name and/or last name
	 *
	 * @param CustomerDTO customerDTO
	 * @return  ResponseEntity
	 */
	@GetMapping("/cusomters/search/{searchKeyword}")
	public ResponseEntity<ServiceResponse<List<CustomerResponse>>>  searchCustomersByFirstNameOrLastName(@PathVariable(value="searchKeyword") String searchKeyword) {
        return new ResponseEntity<>(customerService.searchCustomersByFirstNameOrLastName(searchKeyword),  HttpStatus.OK);
	}
	
	/**
	 * Update the living address
	 *
	 * @param CustomerDTO customerDTO
	 * @return  ResponseEntity
	 */
	@PutMapping("/cusomters/{customerId}/address")
	public ResponseEntity<ServiceResponse<JSONResponse>> updateAddress(@PathVariable("customerId") Integer customerId, @Valid @RequestBody AddressDTO addressDTO) {
        return new ResponseEntity<>(customerService.updateCustomerAddress(customerId, addressDTO),  HttpStatus.OK);
	}

}
