package com.narasimha.customerservice.dto;

import javax.validation.constraints.NotNull;

public class AddressDTO {
	
	@NotNull(message="street should not be empty")
	private String street;
	
	@NotNull(message="postal code should not be empty")
	private String postalcode;
	
	@NotNull(message="city should not be empty")
	private String city;
	
	private String province;
	
	@NotNull(message="country should not be empty")
	private String country;
	
	public AddressDTO() {

	}

	public AddressDTO(String street, String postalcode, String city, String province, String country) {
		super();
		this.street = street;
		this.postalcode = postalcode;
		this.city = city;
		this.province = province;
		this.country = country;
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
		return "AddressDTO [street=" + street + ", postalcode=" + postalcode + ", city=" + city + ", province="
				+ province + ", country=" + country + "]";
	}
}
