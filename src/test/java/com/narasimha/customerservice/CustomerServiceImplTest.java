package com.narasimha.customerservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.narasimha.customerservice.dto.AddressDTO;
import com.narasimha.customerservice.dto.CustomerDTO;
import com.narasimha.customerservice.entity.AddressEntity;
import com.narasimha.customerservice.entity.CustomerEntity;
import com.narasimha.customerservice.model.response.Address;
import com.narasimha.customerservice.model.response.CustomerResponse;
import com.narasimha.customerservice.model.response.JSONResponse;
import com.narasimha.customerservice.model.response.ServiceResponse;
import com.narasimha.customerservice.persistence.dao.AddressDao;
import com.narasimha.customerservice.persistence.dao.CustomerDao;
import com.narasimha.customerservice.service.CustomerService;
import com.narasimha.customerservice.service.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
	
	/**. class variable to hold CustomerService obj */
	@InjectMocks
	CustomerService customerService = new CustomerServiceImpl();
	
	/**.class variable to hold mock CustomerDao obj */
	@Mock
	CustomerDao customerDao;
	
	/**.class variable to hold mock CustomerDao obj */
	@Mock
	AddressDao addressDao;
	
	/**.class variable to hold mock ModelMapper obj */
	@Mock
	ModelMapper modelMapper;
	
	@Test
	public void tesCreateCustomer() {
		
		AddressEntity addressEntity = new AddressEntity(1, "Volmerlaan", "2288 GC", "Rijswijk", "Zuid-Holland", "Netherlands");
		CustomerEntity customerEntity = new CustomerEntity(1, "Edwin", "Kuiper", 38, addressEntity);
		
		when(customerDao.createCustomer(any(CustomerEntity.class))).thenReturn(customerEntity);
		
		
		AddressDTO address1 = new AddressDTO("Van rynostraat", "2531TJ", "Den Haage", "Zuid-Holland", "Netherlands");
		CustomerDTO customerDTO = new CustomerDTO("Edwin", "Kuiper", 38, address1);
		
		Address address = new Address(1, "Volmerlaan", "2288 GC", "Rijswijk", "Zuid-Holland", "Netherlands");
		CustomerResponse customerResponse = new CustomerResponse(1, "Edwin", "Kuiper", 38, address);
		when(modelMapper.map(any(), any())).thenReturn(customerResponse);
		
		CustomerResponse response = customerService.createCustomer(customerDTO);
		
		assertNotNull(response.getCustomerId());
		assertEquals(customerDTO.getFirstName(), response.getFirstName());
		assertEquals(customerDTO.getLastName(), response.getLastName());
		
	}
	
	@Test
	public void testRetrieveAllCustomers() {
		AddressEntity addressEntity1 = new AddressEntity(1, "Volmerlaan", "2288 GC", "Rijswijk", "Zuid-Holland", "Netherlands");
		CustomerEntity customerEntity1 = new CustomerEntity(1, "Edwin", "Kuiper", 38, addressEntity1);
		
		AddressEntity addressEntity2 = new AddressEntity(1, "Volmerlaan", "2288 GC", "Rijswijk", "Zuid-Holland", "Netherlands");
		CustomerEntity customerEntity2 = new CustomerEntity(1, "Edwin", "Kuiper", 38, addressEntity2);
		
		List<CustomerEntity> list = new ArrayList<>();
		list.add(customerEntity1);
		list.add(customerEntity2);
		
		when(customerDao.getAllCustomers()).thenReturn(list);
		
		Address address = new Address(1, "Volmerlaan", "2288 GC", "Rijswijk", "Zuid-Holland", "Netherlands");
		CustomerResponse customerResponse = new CustomerResponse(1, "Edwin", "Kuiper", 38, address);
		when(modelMapper.map(any(), any())).thenReturn(customerResponse);
		
		List<CustomerResponse> resp = customerService.retrieveAllCustomers();
		
		assertFalse(resp.isEmpty());
	}
	
	@Test
	public void testRetrieveCustomerById() {

		AddressEntity addressEntity = new AddressEntity(1, "Volmerlaan", "2288 GC", "Rijswijk", "Zuid-Holland", "Netherlands");
		CustomerEntity customerEntity = new CustomerEntity(1, "Edwin", "Kuiper", 38, addressEntity);
		
		when(customerDao.isExistsCustomerId(any(Integer.class))).thenReturn(true);
		when(customerDao.retrieveCustomerById(any(Integer.class))).thenReturn(customerEntity);
		
		Address address = new Address(1, "Volmerlaan", "2288 GC", "Rijswijk", "Zuid-Holland", "Netherlands");
		CustomerResponse customerResponse = new CustomerResponse(1, "Edwin", "Kuiper", 38, address);
		when(modelMapper.map(any(), any())).thenReturn(customerResponse);
		
		Integer customerId = 1;
		CustomerResponse response = customerService.retrieveCustomerById(customerId);
		
		assertNotNull(response.getCustomerId());
		assertNotNull(response.getFirstName());
		
	}
	
	@Test
	public void testRetrieveCustomerWithUnknowId() {

		assertThrows(IllegalArgumentException.class, () -> {
		
		when(customerDao.isExistsCustomerId(any(Integer.class))).thenReturn(false);
		Integer customerId = 1;
		customerService.retrieveCustomerById(customerId);
		
		});
	}
	
	@Test
	public void testUpdateAddress() {
		AddressEntity addressEntity = new AddressEntity(1, "Volmerlaan", "2288 GC", "Rijswijk", "Zuid-Holland", "Netherlands");
		CustomerEntity customerEntity = new CustomerEntity(1, "Edwin", "Kuiper", 38, addressEntity);
		
		when(customerDao.isExistsCustomerId(any(Integer.class))).thenReturn(true);
		when(customerDao.retrieveCustomerById(any(Integer.class))).thenReturn(customerEntity);
		
		when(addressDao.updateAddress(any(AddressEntity.class))).thenReturn(addressEntity);
		
		
		Integer customerId = 1;
		AddressDTO addressDTO = new AddressDTO("Van ruysbroekstraat", "2531TJ", "Den Haage", "Zuid-Holland", "Netherlands");
		JSONResponse response = customerService.updateCustomerAddress(customerId, addressDTO);
		
		assertNotNull(response.getMessage());
	}
	
	@Test
	public void testSearchCustomersByFirstNameOrLastName() {
		
		AddressEntity addressEntity1 = new AddressEntity(1, "Volmerlaan", "2288 GC", "Rijswijk", "Zuid-Holland", "Netherlands");
		CustomerEntity customerEntity1 = new CustomerEntity(1, "Edwin", "Kuiper", 38, addressEntity1);
		
		AddressEntity addressEntity2 = new AddressEntity(1, "Volmerlaan", "2288 GC", "Rijswijk", "Zuid-Holland", "Netherlands");
		CustomerEntity customerEntity2 = new CustomerEntity(1, "Edwin", "Kuiper", 38, addressEntity2);
		
		List<CustomerEntity> list = new ArrayList<>();
		list.add(customerEntity1);
		list.add(customerEntity2);
		
		when(customerDao.searchCustomersByFirstNameOrLastName(any(String.class))).thenReturn(list);
		
		Address address = new Address(1, "Volmerlaan", "2288 GC", "Rijswijk", "Zuid-Holland", "Netherlands");
		CustomerResponse customerResponse = new CustomerResponse(1, "Edwin", "Kuiper", 38, address);
		when(modelMapper.map(any(), any())).thenReturn(customerResponse);
		
		String searchKeyword = "Edwin";
		List<CustomerResponse> resp = customerService.searchCustomersByFirstNameOrLastName(searchKeyword);
		
		assertFalse(resp.isEmpty());
		
		
	}
	
	@Test
	public void testSearchCustomersByFirstNameOrLastNameNotFound() {
		assertThrows(IllegalArgumentException.class, () -> {
		List<CustomerEntity> list = new ArrayList<>();
		
		when(customerDao.searchCustomersByFirstNameOrLastName(any(String.class))).thenReturn(list);
		
		String searchKeyword = "Edwin";
		List<CustomerResponse> resp = customerService.searchCustomersByFirstNameOrLastName(searchKeyword);
		
		assertTrue(resp.isEmpty());
		});
		
	}

}
