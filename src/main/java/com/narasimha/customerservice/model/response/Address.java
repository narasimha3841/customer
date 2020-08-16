package com.narasimha.customerservice.model.response;

public class Address {
	
    private Integer addressId;
    private String street;
    private String postalcode;
    private String city;
    private String province;
    private String country;
    
	public Address() {
		super();
	}

	public Address(Integer addressId, String street, String postalcode, String city, String province, String country) {
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
		return "Address [addressId=" + addressId + ", street=" + street + ", postalcode=" + postalcode + ", city="
				+ city + ", province=" + province + ", country=" + country + "]";
	}

}
