package com.narasimha.customerservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
*
* Entity class that maps with the table 'ADDRESS'.
*
*/
@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "ADDRESS_SEQ")
    @Column(name = "ADDRESS_ID")
    private Integer addressId;
    
    @Column(name = "STREET")
    private String street;
    
    @Column(name = "POSTAL_CODE")
	private String postalcode;
    
    @Column(name = "CITY")
	private String city;
    
    @Column(name = "PROVINCE")
	private String province;
    
    @Column(name = "COUNTRY")
	private String country;
    
    
	public AddressEntity() {
		
	}

	public AddressEntity(Integer addressId, String street, String postalcode, String city, String province,
			String country) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.postalcode = postalcode;
		this.city = city;
		this.province = province;
		this.country = country;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "AddressEntity [addressId=" + addressId + ", street=" + street + ", postalcode=" + postalcode + ", city="
				+ city + ", province=" + province + ", country=" + country + "]";
	}
}
