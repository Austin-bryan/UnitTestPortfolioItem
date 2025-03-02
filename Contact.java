// Author: Austin Bryan
// StudentId: 2798128

package TaskMaster;

public class Contact {
	private final String contactId;
	private String firstName, lastName, phone, address;
	
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		// Validate strings are valid
		validateString(contactId, 10, "Contact ID");
		validateString(firstName, 10, "First name");
		validateString(lastName, 10, "Last name");
		validateString(address, 30, "Address");
		validatePhone(phone);
		
		// Assign only if all strings are valid
	    this.contactId = contactId;
	    this.firstName = firstName;
        this.lastName  = lastName;
        this.phone     = phone;
        this.address   = address;
	}
	
	private void validateString(String string, int maxLength, String errorMessage) {
		if (string == null || string.trim().isEmpty() || string.length() > maxLength) {
			throw new IllegalArgumentException(errorMessage + " must not be null, empty, or exceed " + maxLength + " characters.");
		}
	}
	
    private void validatePhone(String phone) {
        validateString(phone, 10, "Phone number");  // Null and length validation
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
    }
    
    // Getters
	public String getContactId() { return contactId; }
	public String getFirstName() { return firstName; }
	public String getLastName()  { return lastName; } 
	public String getPhone()     { return phone; }
	public String getAddress()   { return address; }
	
	// Setters
	public void setFirstName(String firstName) {
		validateString(firstName, 10, "First name");
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		validateString(lastName, 10, "Last name");
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		validatePhone(phone);
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		validateString(address, 30, "Address");
		this.address = address;
	}
}
