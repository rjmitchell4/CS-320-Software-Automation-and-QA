package test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import contact.Contact;
import contact.ContactService;

class ContactServiceTest {
	
	private static ContactService contactService;
	
	@BeforeAll
	static void setup() {
		contactService = ContactService.getService();
	}
	
	@Test
	void testAddingContact() {
		Contact contact = new Contact("0", "firstname", "lastName", "1234567890", "address");
		assertTrue(contactService.addContact(contact));
		
		Contact cachedContact = contactService.getContact(contact.getId());
		assertTrue(cachedContact != null);
		assertTrue(cachedContact.getId().equals("0"));
		assertTrue(cachedContact.getFirstName().equals("firstname"));
		assertTrue(cachedContact.getLastName().equals("lastName"));
		assertTrue(cachedContact.getPhone().equals("1234567890"));
		assertTrue(cachedContact.getAddress().equals("address"));
			
	}

	@Test
	void testAddContactDuplicateIdFail() {
		Contact contact1 = new Contact("123466", "Ryan", "Mitchell", "0000000000", "address");	
		Contact contact2 = new Contact("123466", "Ryan", "Mitchell", "0000000000", "address");	

		assertTrue(contactService.addContact(contact1));
		assertFalse(contactService.addContact(contact2));
	}
	
	@Test
	void testGetContactAndUpdateSuccess() {
		Contact contact = new Contact("123459", "Ryan", "Mitchell", "0000000000", "address");	
		assertTrue(contactService.addContact(contact));
		
		Contact updatedContact = contactService.getContact(contact.getId());
		contactService.updateFirstName("123459","Bryan");
		contactService.updateLastName("123459","Mitchelll");
		contactService.updatePhone("123459","1111111111");
		contactService.updateAddress("123459", "otherAddress");
		
		updatedContact = contactService.getContact(updatedContact.getId());

		assertTrue(updatedContact.getFirstName().equals("Bryan"));
		assertTrue(updatedContact.getLastName().equals("Mitchelll"));
		assertTrue(updatedContact.getPhone().equals("1111111111"));
		assertTrue(updatedContact.getAddress().equals("otherAddress"));
	}
	
	@Test
	void testGetContactAndDeleteSuccess() {
		Contact contact = new Contact("123460", "Ryan", "Mitchell", "0000000000", "address");	

		assertTrue(contactService.addContact(contact));
		
		contact = contactService.getContact(contact.getId());
		assertTrue(contact != null);
		
		assertTrue(contactService.deleteContact(contact.getId()));
		assertTrue(contactService.getContact(contact.getId()) == null);
	}
	
	@Test
	void testDeleteInvalidContactFail() {
		String invalidContactId = "123";

		assertFalse(contactService.deleteContact(invalidContactId));
	}
	
}