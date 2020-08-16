package com.narasimha.customerservice.model.response;

public class CustomerResponse {
	
	private Integer customerId;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private Address address;

	public CustomerResponse() {
		super();
	}

	public CustomerResponse(Integer customerId, String firstName, String lastName, Integer age, Address address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerResponse [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", address=" + address + "]";
	}

}
