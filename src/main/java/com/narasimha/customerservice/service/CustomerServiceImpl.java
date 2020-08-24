package com.narasimha.customerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narasimha.customerservice.dto.AddressDTO;
import com.narasimha.customerservice.dto.CustomerDTO;
import com.narasimha.customerservice.entity.AddressEntity;
import com.narasimha.customerservice.entity.CustomerEntity;
import com.narasimha.customerservice.model.response.CustomerResponse;
import com.narasimha.customerservice.model.response.JSONResponse;
import com.narasimha.customerservice.persistence.dao.AddressDao;
import com.narasimha.customerservice.persistence.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	/** variable to hold CustomerDao object */
	private CustomerDao customerDao;
	
	/** variable to hold AddressDao object */
	private AddressDao addressDao;
	
	
	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao, AddressDao addressDao) {
		super();
		this.customerDao = customerDao;
		this.addressDao = addressDao;
	}

	public CustomerServiceImpl() {

	}

	/** variable to hold ModelMapper object */
	@Autowired
	private ModelMapper modelMapper;
	
	/** variable to hold logger object */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	/**
	 * Create a new Customer
	 *
	 * @param CustomerDTO customerDTO
	 * @return  ServiceResponse
	 */
	@Override
	public CustomerResponse createCustomer(CustomerDTO customerDTO) {
		
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setFirstName(customerDTO.getFirstName());
		customerEntity.setLastName(customerDTO.getLastName());
		customerEntity.setAge(customerDTO.getAge());
		
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setStreet(customerDTO.getAddress().getStreet());
		addressEntity.setProvince(customerDTO.getAddress().getProvince());
		addressEntity.setPostalcode(customerDTO.getAddress().getPostalcode());
		addressEntity.setCity(customerDTO.getAddress().getCity());
		addressEntity.setCountry(customerDTO.getAddress().getCountry());
		
		customerEntity.setAddress(addressEntity);
		
		
		CustomerEntity entity = customerDao.createCustomer(customerEntity);
		
		return modelMapper.map(entity, CustomerResponse.class);
	}

	/**
	 * Retrieve all customers
	 *
	 * @return  ServiceResponse the list of customers
	 */
	@Override
	public List<CustomerResponse> retrieveAllCustomers() {
		
		List<CustomerResponse> list = new ArrayList<>();
		List<CustomerEntity> customerEntityList = customerDao.getAllCustomers();
		customerEntityList.forEach( e -> list.add(modelMapper.map(e, CustomerResponse.class)));
		
		return  list;
	}

	
	/**
	 * Retrieve customer by id
	 * @param customerId
	 * @return  ServiceResponse
	 */
	@Override
	public CustomerResponse retrieveCustomerById(Integer customerId) {
		
		if(! customerDao.isExistsCustomerId(customerId)) {
			throw new IllegalArgumentException("Customer Id: "+ customerId +" doesn't exists");
		}
		
		return modelMapper.map(customerDao.retrieveCustomerById(customerId), CustomerResponse.class);
	}

	/**
	 * update customer address by customer id
	 * @param customerId
	 * @param addressDTO customer address
	 * @return  ServiceResponse
	 */
	@Override
	public JSONResponse updateCustomerAddress(Integer customerId, AddressDTO addressDTO) {
		try {
		if(! customerDao.isExistsCustomerId(customerId)) {
			throw new IllegalArgumentException("Customer Id: "+ customerId +" doesn't exists");
		}
		
		CustomerEntity customerEntity = customerDao.retrieveCustomerById(customerId);
		
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressId(customerEntity.getAddress().getAddressId());
		addressEntity.setStreet(addressDTO.getStreet());
		addressEntity.setProvince(addressDTO.getProvince());
		addressEntity.setPostalcode(addressDTO.getPostalcode());
		addressEntity.setCity(addressDTO.getCity());
		addressEntity.setCountry(addressDTO.getCountry());
		
		AddressEntity entity = addressDao.updateAddress(addressEntity);
		
		if(entity.getAddressId() != null) {
			return new JSONResponse("Address has been updated successfully");
		}
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		catch(Exception e) {
			return new JSONResponse("Address has not updated due to system issue, Please try again later..");
		}
		
		return null;
	}
	
	/**
	 * Search customer by first name or last name
	 * @param searchKeyword String
	 * @return  ServiceResponse the list of customers
	 */
	@Override
	public List<CustomerResponse>  searchCustomersByFirstNameOrLastName(String searchKeyword) {
		List<CustomerResponse> list = new ArrayList<>();
		List<CustomerEntity> customerEntityList = customerDao.searchCustomersByFirstNameOrLastName(searchKeyword);
		
		if(customerEntityList.isEmpty()) {
			throw new IllegalArgumentException("No customers found with search keyword :"+searchKeyword);
		}

		customerEntityList.forEach( e -> list.add(modelMapper.map(e, CustomerResponse.class)));
		
		return  list;
	}

}
