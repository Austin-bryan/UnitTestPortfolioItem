// Author: Austin Bryan
// StudentId: 2798128

package test;

import org.junit.jupiter.api.*;

import TaskMaster.Contact;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
	private Contact contact;
	
	@BeforeEach
	public void setUp() {
		contact = new Contact("720", "Austin", "Bryan", "6031112222", "2500 North River Road");
	}
	
	@AfterEach
	public void tearDown() {
		// Not strictly needed, but I'm doing this for demonstrating the idea of a tearDown
		contact = null;
	}
	
	@Test
	public void testContactCreationValidFields() {
		assertEquals("720", contact.getContactId());
		assertEquals("Austin", contact.getFirstName());
		assertEquals("Bryan", contact.getLastName());
		assertEquals("6031112222", contact.getPhone());
		assertEquals("2500 North River Road", contact.getAddress());
	}
	
	@Test
    public void testContactCreationInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Austin", "Bryan", "6031112222", "2500 North River Road"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("", "Austin", "Bryan", "6031112222", "2500 North River Road"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Austin", "Bryan", "6031112222", "2500 North River Road"));
    }

    @Test
    public void testContactCreationInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", null, "Bryan", "6031112222", "2500 North River Road"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "", "Bryan", "6031112222", "2500 North River Road"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "SomeReallyLongFirstName", "Bryan", "6031112222", "2500 North River Road"));
    }

    @Test
    public void testContactCreationInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "Austin", null, "6031112222", "2500 North River Road"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "Austin", "", "6031112222", "2500 North River Road"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "Austin", "SomeReallyLongLastName", "6031112222", "2500 North River Road"));
    }

    @Test
    public void testContactCreationInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "Austin", "Bryan", null, "2500 North River Road"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "Austin", "Bryan", "", "2500 North River Road"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "Austin", "Bryan", "603111", "2500 North River Road"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "Austin", "Bryan", "6031112223333", "2500 North River Road"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "Austin", "Bryan", "603-ABCDE", "2500 North River Road"));
    }

    @Test
    public void testContactCreationInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "Austin", "Bryan", "6031112222", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "Austin", "Bryan", "6031112222", ""));
        assertThrows(IllegalArgumentException.class, () -> new Contact("7201", "Austin", "Bryan", "6031112222", "123 Elm Street, Apartment 456, Some City, Some State, 12345"));
    }

    @Test
    public void testSettersValidInput() {
        contact.setFirstName("Harry");
        assertEquals("Harry", contact.getFirstName());

        contact.setLastName("Potter");
        assertEquals("Potter", contact.getLastName());

        contact.setPhone("9787281546");
        assertEquals("9787281546", contact.getPhone());

        contact.setAddress("424 Abbott Farm Lane");
        assertEquals("424 Abbott Farm Lane", contact.getAddress());
    }

    @Test
    public void testSettersInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(""));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("SomeLongFirstName"));

        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(""));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("SomeLongLastName"));

        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(""));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("720"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("720720720720720720"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("720-abc"));

        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(""));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("720 Basic Street Name, Apartment 123, City, State, 99999"));
    }
}