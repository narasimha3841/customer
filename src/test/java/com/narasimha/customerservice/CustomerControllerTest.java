package com.narasimha.customerservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.narasimha.customerservice.dto.AddressDTO;
import com.narasimha.customerservice.dto.CustomerDTO;
import com.narasimha.customerservice.model.response.Address;
import com.narasimha.customerservice.model.response.CustomerResponse;
import com.narasimha.customerservice.model.response.JSONResponse;
import com.narasimha.customerservice.rest.route.CustomerController;
import com.narasimha.customerservice.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerService customerService;

	@Before
	public void init() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	@Test
	public void testCreateCustomer() {
		AddressDTO address1 = new AddressDTO("Van ruysbroekstraat", "2531TJ", "Den Haage", "Zuid-Holland", "Netherlands");
		CustomerDTO customerDTO = new CustomerDTO("Edwin", "Kuiper", 38, address1);

		
		Address address = new Address(1, "Van rynostraat", "2531TJ", "Den Haage", "Zuid-Holland", "Netherlands");
		CustomerResponse customer = new CustomerResponse(1, "Edwin", "Kuiper", 38, address);

		when(customerService.createCustomer(any(CustomerDTO.class))).thenReturn(customer);

		ResponseEntity<CustomerResponse> responseEntity = customerController.createCustomer(customerDTO);

		assertEquals(responseEntity.getStatusCodeValue(), HttpStatus.CREATED.value());
		assertNotNull(responseEntity.getBody().getCustomerId());
		assertEquals(customerDTO.getFirstName(), responseEntity.getBody().getFirstName());
		assertEquals(customerDTO.getLastName(), responseEntity.getBody().getLastName());

	}

	@Test
	public void testCreateCustomer_badRequest() {
		ResponseEntity<CustomerResponse> responseEntity = null;
		try {
			AddressDTO addressDTO = new AddressDTO("Van ruysbroekstraat", "2531TJ", "Den Haage", "Zuid-Holland","Netherlands");
			CustomerDTO customerDTO = new CustomerDTO("", "Kuiper", 38, addressDTO);

			Address address = new Address(1, "Van rynostraat", "2531TJ", "Den Haage", "Zuid-Holland", "Netherlands");
			CustomerResponse customer = new CustomerResponse(1, "Edwin", "Kuiper", 38, address);

			when(customerService.createCustomer(any(CustomerDTO.class))).thenReturn(customer);

			responseEntity = customerController.createCustomer(customerDTO);

		} catch (Exception e) {
			assertEquals(responseEntity.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
		}

	}
	
	@Test
	public void testRetrieveAllCustomers() {
		
		List<CustomerResponse> list = new ArrayList<>();
		Address address1 = new Address(1, "Van ruysbroekstraat", "2531TJ", "Den Haage", "Zuid-Holland", "Netherlands");
		CustomerResponse customer1 = new CustomerResponse(1, "Edwin", "Kuiper", 38, address1);
		
		Address address2 = new Address(1, "straat", "3521", "Rijswijk", "south-Holland", "Netherlands");
		CustomerResponse customer2 = new CustomerResponse(1, "Erik", "Van", 44, address2);
		
		list.add(customer1);
		list.add(customer2);
		
		when(customerService.retrieveAllCustomers()).thenReturn(list);

		ResponseEntity<List<CustomerResponse>> responseEntity = customerController.retrieveAllCustomers();

		assertEquals(responseEntity.getStatusCodeValue(), HttpStatus.OK.value());
		assertFalse(responseEntity.getBody().isEmpty());

	}
	
	
	@Test
	public void testRetrieveCustomerById() {
		
		Address address1 = new Address(1, "Van ruysbroekstraat", "2531TJ", "Den Haage", "Zuid-Holland", "Netherlands");
		CustomerResponse customer1 = new CustomerResponse(1, "Edwin", "Kuiper", 38, address1);

		when(customerService.retrieveCustomerById(any(Integer.class))).thenReturn(customer1);
		Integer customerId = 1;

		ResponseEntity<CustomerResponse> responseEntity = customerController.retrieveCustomerById(customerId);

		assertEquals(responseEntity.getStatusCodeValue(), HttpStatus.OK.value());
		assertNotNull(responseEntity.getBody().getCustomerId());
		assertNotNull(responseEntity.getBody().getFirstName());

	}
	
	@Test
	public void testSearchCustomersByFirstNameOrLastName() {
		List<CustomerResponse> list = new ArrayList<>();
		Address address1 = new Address(1, "Van ruysbroekstraat", "2531TJ", "Den Haage", "Zuid-Holland", "Netherlands");
		CustomerResponse customer1 = new CustomerResponse(1, "Edwin", "Kuiper", 38, address1);

		list.add(customer1);
		

		when(customerService.searchCustomersByFirstNameOrLastName(any(String.class))).thenReturn(list);
		String keyword = "Edwin";

		ResponseEntity<List<CustomerResponse>> responseEntity = customerController.searchCustomersByFirstNameOrLastName(keyword);

		assertEquals(responseEntity.getStatusCodeValue(), HttpStatus.OK.value());
		assertFalse(responseEntity.getBody().isEmpty());

	}
	
	@Test
	public void testUpdateAddress() {
		when(customerService.updateCustomerAddress(any(Integer.class), any(AddressDTO.class))).thenReturn(new JSONResponse("Address has been updated"));
		Integer customerId = 1;

		AddressDTO addressDTO = new AddressDTO("Van ruysbroekstraat", "2531TJ", "Den Haage", "Zuid-Holland", "Netherlands");
		ResponseEntity<JSONResponse> responseEntity = customerController.updateAddress(customerId, addressDTO);

		assertEquals(responseEntity.getStatusCodeValue(), HttpStatus.OK.value());

	}
}
