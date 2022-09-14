package com.maveric.addressbook;

import java.util.ArrayList;
import java.util.List;

public class Contact {
	
	private String name;
	private String organization;
	private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
	private List<Address> addresses = new ArrayList<Address>();
	
	public void setOrganization(String organization) {
		if(organization.length() < 255) {
			this.organization = organization;
		}
	}
	
	public void setName(String name) throws LengthException{
		if(name.matches("^[a-zA-Z\\s]{1,255}$")) {
			this.name = name;
		}
		else {
			throw new LengthException("Invalid name, length should be in the range of (1...255)");
		}
	}
	public String getName() {
		return name;
	}
	
	public String getOrganization() {
		return organization;
	}
	
	public List<PhoneNumber> getPhoneNumbers() {
		return  phoneNumbers;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
	public List<PhoneNumber> addPhoneNumber(PhoneNumber PhoneNumber) {
		phoneNumbers.add(PhoneNumber);
		return phoneNumbers;
	}
	
	public List<Address> addAddress(Address Address) {
		addresses.add(Address);
		return addresses;
	}
}
