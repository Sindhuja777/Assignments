package com.maveric.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {
	
	List<Contact> contactList = new ArrayList<Contact>();
	
	// to Add a contact
	public void addContact(Contact contact) throws DuplicateContact{
		if (!contactList.contains(contact)) {
			contactList.add(contact);
		} else {
			throw new DuplicateContact("Contact already Exists");
		}
	}
	
	// search by name
	public List<Contact> searchByName(String name){
		List<Contact> filteredList = contactList.stream().filter(i -> i.getName().matches("(?i)" + name + "(.*)"))
				.collect(Collectors.toList());
		return filteredList;
	}
	
	// search by organization
	public List<Contact> searchByOrganization(String org){

		List<Contact> filteredList = contactList.stream()
				.filter(i -> i.getOrganization().matches("(?i)" + org + "(.*)")).collect(Collectors.toList());
		return filteredList;
	}
	
	// update
	public void updateContact(String name, Contact contact) throws DuplicateNameException, LengthException{
		if (contact.getName() != name ) {
			contact.setName(name);
		} else {
			throw new DuplicateNameException("Cannot Update Same Name already Exists");
		}
	}
	
	// delete
	 public void deleteContact(String name) {
		Contact toBeDeleted = null;
		for (Contact i : contactList) {
			if (i.getName().equals(name)) {
				toBeDeleted = i;
			}
		}
		if(toBeDeleted!=null) {
			contactList.remove(toBeDeleted);
		}
		else {
			System.out.println("Invalid name, Try to delete again");
		}
	}
}
