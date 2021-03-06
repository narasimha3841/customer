package com.narasimha.customerservice.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narasimha.customerservice.entity.AddressEntity;
import com.narasimha.customerservice.persistence.repository.AddressRepository;

@Repository
public class AddressDaoImpl implements AddressDao{

	/** variable to hold AddressRepository object */
	private AddressRepository addressRepository;
	
	@Autowired
	public AddressDaoImpl(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public AddressEntity updateAddress(AddressEntity addressEntity) {
		return addressRepository.save(addressEntity);
	}

}
