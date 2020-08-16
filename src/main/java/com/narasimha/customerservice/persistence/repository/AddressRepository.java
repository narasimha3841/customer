package com.narasimha.customerservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narasimha.customerservice.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer>{

}
