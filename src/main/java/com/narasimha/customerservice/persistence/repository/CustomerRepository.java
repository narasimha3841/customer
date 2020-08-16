package com.narasimha.customerservice.persistence.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.narasimha.customerservice.entity.CustomerEntity;

@Transactional
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{

	@Query("FROM CustomerEntity customer WHERE customer.firstName LIKE %?1% OR customer.lastName LIKE %?1% ")
	List<CustomerEntity> searchCustomersByFirstNameOrLastName(String searchKeyword);

}
