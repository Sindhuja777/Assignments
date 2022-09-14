package com.maveric.addressbook;

public class DuplicateNameException extends Exception {
	public DuplicateNameException(String errMsg) {
		super(errMsg);
	}
}
