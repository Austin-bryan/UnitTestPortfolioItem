package test;

// Author: Austin Bryan
// StudentId: 2798128

import org.junit.jupiter.api.*;

import TaskMaster.Contact;
import TaskMaster.ContactService;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
	private ContactService contactService;
	private Contact contact;
	
	@BeforeEach
	public void setUp() {
		contactService = new ContactService();
		contact = new Contact("720", "Austin", "Bryan", "6031112222", "2500 North River Road");
        contactService.addContact(contact);
    }
	
	@AfterEach
	public void tearDown() {
		// Not strictly needed, but I'm doing this for demonstration
		contactService = null;
		contact = null;
	}
	
    @Test
    public void testAddContact() {
        Contact newContact = new Contact("7", "Harry", "Potter", "9787281546", "Hogwarts");
        contactService.addContact(newContact);
        assertEquals(newContact, contactService.getContact("7"));
    }
    
    @Test
    public void testAddDuplicateContact() {
    	assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact));
    }
    
    @Test
    public void testAddDiplicateId() {
    	Contact newContact = new Contact("720", "Harry", "Potter", "9787281546", "Hogwarts");
    	assertThrows(IllegalArgumentException.class, () -> contactService.addContact(newContact));
    }
    
    @Test
    public void testDeleteContact() {
        contactService.deleteContact(contact.getContactId());
        assertThrows(IllegalArgumentException.class, () -> contactService.getContact(contact.getContactId()));
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("999"));
    }
    
    @Test
    public void testUpdateContact() {
        contactService.updateContact("720", "Harry", "Potter", "9787281546", "Hogwarts");
        Contact updatedContact = contactService.getContact("720");
        assertEquals("Harry", updatedContact.getFirstName());
        assertEquals("Potter", updatedContact.getLastName());
        assertEquals("9787281546", updatedContact.getPhone());
        assertEquals("Hogwarts", updatedContact.getAddress());
    }

    @Test
    public void testUpdateContactPartialFields() {
        contactService.updateContact("720", null, "Potter", null, "Hogwarts");
        Contact updatedContact = contactService.getContact("720");
        
        assertEquals("Austin", updatedContact.getFirstName()); // Unchanged
        assertEquals("Potter", updatedContact.getLastName());  // Updated
        assertEquals("6031112222", updatedContact.getPhone()); // Unchanged
        assertEquals("Hogwarts", updatedContact.getAddress()); // Updated
    }
}





























