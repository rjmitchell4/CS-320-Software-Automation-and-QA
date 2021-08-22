package contact;

public class Contact {

	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		boolean isValid = validateInput(id, 10);
		
		if(isValid) {
			this.id = id;
		}
		
		isValid = isValid && validateInput(firstName, 10);
		isValid = isValid && validateInput(lastName, 10);
		isValid = isValid && validatePhone(phone);
		isValid = isValid && validateInput(address, 30);
		
		if(!isValid) {
			throw new IllegalArgumentException("Invalid input");
		} else {
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.address = address;
		}
		
	}
	
	public void setFirstName(String newFirstName) {
		boolean isValid = validateInput(newFirstName, 10);
		
		if(isValid) {
			this.firstName = newFirstName;
		}
	}
	
	public void setLastName(String newLastName) {
		boolean isValid = validateInput(newLastName, 10);
		
		if(isValid) {
			this.lastName = newLastName;
		}
	}
	
	public void setPhone(String newPhone) {
		boolean isValid = validatePhone(newPhone);
		if (isValid) {
			this.phone = newPhone;
		}
	}
	
	public void setAddress(String newAddress) {
		boolean isValid = validateInput(newAddress, 30);
		
		if(isValid) {
			this.address = newAddress;
		}
	}
	
	
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	
	
	private boolean validateInput(String item, int length) {
		return (item != null && item.length() <= length);
	}
	private boolean validatePhone(String item) {
		return (item != null && item.length() == 10);
	}
}
	
	
	

