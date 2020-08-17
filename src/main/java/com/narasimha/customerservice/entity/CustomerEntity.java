package com.narasimha.customerservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
*
* Entity class that maps with the table 'CUSTOMER'.
*
*/
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "CUSTOMER_SEQ", sequenceName = "CUSTOMER_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "CUSTOMER_SEQ")
	@Column(name = "CUSTOMER_ID")
	private Integer customerId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "AGE")
	private Integer age;

	
    @JoinColumn(name = "ADDRESS_ID")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private AddressEntity address;

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(Integer customerId, String firstName, String lastName, Integer age, AddressEntity address) {
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

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", address=" + address + "]";
	}
	
}
