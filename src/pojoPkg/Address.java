package pojoPkg;

public class Address {

	int doorNo;
	String Street,city,state;
	int pinCode;
	
	
	public Address() {}
	
	public Address(int doorNo, String street, String city, String state, int pinCode) {
		super();
		this.doorNo = doorNo;
		Street = street;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	public int getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	


	@Override
	public String toString() {
		return " \n---------------------------------"
				+ "\n doorNo - " + doorNo + ""
				+ "\n Street - " + Street + ""
				+ "\n city - " + city + ""
				+ "\n state - " + state + ""
				+ "\npinCode - "+ pinCode + ""
				+ "\n---------------------------------";
	}
	
}
