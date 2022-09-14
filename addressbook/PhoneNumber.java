package com.maveric.addressbook;

class PhoneNumber {
	
	private String label;
	private String phoneNumber;
	
	public String getLabel() {
		return label;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setLabel(String label)throws LengthException{
		if(label.matches("\\D{1,255}")) {
			this.label = label;
		}
		else {
			throw new LengthException("Invalid label, length should be in the range of(1...255");
		}
	}
	public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException{
		if(phoneNumber.matches("\\d{10}")) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new InvalidPhoneNumberException("Phone Number should contain exactly 10 digits.");
		}
	}
	
	@Override
	public String toString(){
		return  "PhoneNumber [label=" + label + ", phoneNumber=" + phoneNumber + "]";
	}
}
