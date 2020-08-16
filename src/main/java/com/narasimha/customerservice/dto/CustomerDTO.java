package com.narasimha.customerservice.dto;

import javax.validation.constraints.NotNull;

public class CustomerDTO {
	
	@NotNull(message="first name should not be empty")
	private String firstName;
	
	@NotNull(message="last name should not be empty")
	private String lastName;
	
	@NotNull(message="age should not be empty")
	private Integer age;
	
	@NotNull(message="address should not be empty")
	private AddressDTO address;
	
	public CustomerDTO() {

	}

	public CustomerDTO(String firstName, String lastName, Integer age, AddressDTO address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDTO [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address="
				+ address + "]";
	}
}
