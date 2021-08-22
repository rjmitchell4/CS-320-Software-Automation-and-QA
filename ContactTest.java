package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact newContact = new Contact("1","Ryan", "Mitchell", "3106666666", "911 House Ln, Simi Valley CA");
		assertTrue(newContact.getId().equals("1"));
		assertTrue(newContact.getFirstName().equals("Ryan"));
		assertTrue(newContact.getLastName().equals("Mitchell"));
		assertTrue(newContact.getPhone().equals("3106666666"));
		assertTrue(newContact.getAddress().equals("911 House Ln, Simi Valley CA"));
	}
	@Test
	void testUpdateFirstName() {
		Contact newContact = new Contact("2","Ryan", "Mitchell", "3106666666", "911 House Ln, Simi Valley CA");
		newContact.setFirstName("Bryan");
		
		assertTrue(newContact.getFirstName().equals("Bryan"));
	}
	
	@Test
	void testUpdateLastName() {
		Contact newContact = new Contact("3","Ryan", "Mitchell", "3106666666", "911 House Ln, Simi Valley CA");
		newContact.setLastName("Bryan");
		
		assertTrue(newContact.getLastName().equals("Bryan"));
	}
	
	@Test
	void testUpdatePhoneNumber() {
		Contact newContact = new Contact("4","Ryan", "Mitchell", "3106666666", "911 House Ln, Simi Valley CA");
		newContact.setPhone("1111111111");
		
		assertTrue(newContact.getPhone().equals("1111111111"));
	}
	
	@Test
	void testUpdateAddress() {
		Contact newContact = new Contact("5","Ryan", "Mitchell", "3106666666", "911 House Ln, Simi Valley CA");
		newContact.setAddress("I don't live in a house");
		
		assertTrue(newContact.getAddress().equals("I don't live in a house"));
	}
	
	@Test
	void testContactClassInvalidUpdates() {
		Contact newContact = new Contact("6","Ryan", "Mitchell", "3106666666", "911 House Ln, Simi Valley CA");
		newContact.setFirstName("Let's see, my name should be Ryan for this section");
		newContact.setLastName("And my last name in this case is definitely Mitchell");
		
		assertTrue(newContact.getFirstName().equals("Ryan"));
		assertTrue(newContact.getLastName().equals("Mitchell"));
	}
	
	@Test
	void testContactClassInvalidId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("11111111111", "Test", "Test", "TestTestTe", "Test");
		});		}
	
	@Test
	void testContactClassInvalidFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "RyanRyanRyan", "Test", "TestTestTe", "Test");
		});		}
	
	@Test
	void testContactClassInvalidLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Test", "MitchellMitchell", "TestTestTe", "Test");
		});		}
	
	@Test
	void testContactClassInvalidPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Test", "Test", "310666666666", "Test");
		});		}
	
	@Test
	void testContactClassInvalidAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Test", "Test", "TestTestTe", "AddressAddressAddressAddressAddressAddress");
		});		}
	
	
}
