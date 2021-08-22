package contact;

import java.util.HashMap;
import java.util.Map;
import contact.Contact;

public class ContactService {
	
	
	private static ContactService reference = new ContactService();
	private final Map<String, Contact> contacts;
	
	ContactService() {
		this.contacts = new HashMap<String, Contact>();
	}
	
	//Create a singleton Contact Service
	public static ContactService getService() {
			 return reference;
	}
	
	public boolean addContact(Contact contact) {
		boolean isSuccess = false;
		 
		 if(!contacts.containsKey(contact.getId())) {
			 contacts.put(contact.getId(), contact);
			 isSuccess = true;
		 }
		 return isSuccess;
	}
	
	public boolean deleteContact(String contactId) {
		return contacts.remove(contactId) != null;
	}
	
	public Contact getContact(String contactId) {
		 return contacts.get(contactId);
	 }
	
	public void updateFirstName(String contactId, String newFirstName) {
		contacts.get(contactId).setFirstName(newFirstName);
	}
	public void updateLastName(String contactId, String newLastName) {
		contacts.get(contactId).setLastName(newLastName);
	}
	public void updatePhone(String contactId, String newPhone) {
		contacts.get(contactId).setPhone(newPhone);
	}
	public void updateAddress(String contactId, String newAddress) {
		contacts.get(contactId).setAddress(newAddress);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}