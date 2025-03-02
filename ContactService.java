// Author: Austin Bryan
// StudentId: 2798128

package TaskMaster;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>();
	
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists.");
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID does not exist");
		}
		contacts.remove(contactId);
	}
	
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = getContact(contactId);
		
		// Set all non null or blank fields
		setIfValid(firstName, contact::setFirstName);
		setIfValid(lastName, contact::setLastName);
		setIfValid(phone, contact::setPhone);
		setIfValid(address, contact::setAddress);
	}
	
	public Contact getContact(String contactId) {
		Contact contact = contacts.get(contactId);
		if (contact == null) { 
			throw new IllegalArgumentException("Contact ID does not exist.");
		}
		return contact;
	}
	
	private void setIfValid(String value, Consumer<String> updateAction) {
	    if (value != null && !value.isBlank()) {
	        updateAction.accept(value);
	    }
	}
}
