package com.maveric.addressbook;

import java.util.List;

public class AddressBookDemo {
	//
	static void printList(List<Contact> list) {
		for (Contact i : list) {
			System.out.println("Name: " + i.getName() + " Organization: " + i.getOrganization());
			System.out.println(i.getAddresses().toString());
			System.out.println(i.getPhoneNumbers().toString());
		}
	}

	public static void main(String[] args) throws LengthException {

		try {
			PhoneNumber phn1 = new PhoneNumber();
			phn1.setLabel("work");
			phn1.setPhoneNumber("9912535647");
			
			PhoneNumber phn2 = new PhoneNumber();
			phn2.setLabel("home");
			phn2.setPhoneNumber("9876543201");

			Address addr1 = new Address();
			addr1.setLabel("Work Address");
			addr1.setAddress("Pune");

			Address addr2 = new Address();
			addr2.setLabel("Home Address");
			addr2.setAddress("KKD");

			Contact ct1 = new Contact();
			ct1.setName("Sindhu");
			ct1.setOrganization("Maveric");
			ct1.addAddress(addr1);
			ct1.addAddress(addr2);
			ct1.addPhoneNumber(phn2);
			ct1.addPhoneNumber(phn1);

			PhoneNumber phn3 = new PhoneNumber();
			phn3.setLabel("Work");
			phn3.setPhoneNumber("6309263330");
			
			PhoneNumber phn4 = new PhoneNumber();
			phn4.setLabel("Home");
			phn4.setPhoneNumber("9640337825");

			Address addr3 = new Address();
			addr3.setLabel("Home Address");
			addr3.setAddress("Hyderabad");

			Address addr4 = new Address();
			addr4.setLabel("Office address");
			addr4.setAddress("Kharadi");

			Contact ct2 = new Contact();
			ct2.setName("Vicky");
			ct2.setOrganization("Maverick");
			ct2.addAddress(addr3);
			ct2.addAddress(addr4);
			ct2.addPhoneNumber(phn3);
			ct2.addPhoneNumber(phn4);

			// adding to addressbook
			AddressBook addressBook = new AddressBook();
			addressBook.addContact(ct1);
			//addressBook.addContact(ct1);// should raise an exception
			addressBook.addContact(ct2);
			
			// Printing if Contacts are present in contactList
			List<Contact> contactList = addressBook.contactList;

			printList(contactList);
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			
			/*
			 * Testing Methods searchByName() searchByOrganisation() updateContact() deleteContact()
			 */
//			List<Contact> filteredList = addressBook.searchByName("Vickyy");		
//			System.out.println("************************** searchByName *********************************");
//			printList(filteredList);
//
//			List<Contact> filteredList1 = addressBook.searchByOrganization("Mav");
//			System.out.println("******************************** searchByOrganization ***********************************");
//			printList(filteredList1);
//
//			addressBook.updateContact("Vijay Kumar", ct2); 
//			//addressBook.updateContact("VJK", ct2);
//			System.out.println(" **************************** After Updating *******************************");
//			printList(addressBook.contactList);
//
			addressBook.deleteContact("Sindhu");
			System.out.println(" **************************** After Deleting ********************************");
			printList(addressBook.contactList);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}