import java.util.Comparator;

public class Contact implements Comparable<Contact> {
	private String _firstName;
	private String _lastName;
	private String _phoneNumber;
	private String _address;
	private String _address2;
	private String _city;
	private String _state;
	private String _zip;
	private String _email;
	private String _website;

	public Contact(String city, String state, String zip, String address, String address2, String lastName,
			String firstName, String phoneNumber, String email, String website) {

		set_firstName(firstName);
		set_lastName(lastName);
		set_phoneNumber(phoneNumber);
		set_address(address);
		set_address2(address2);
		set_city(city);
		set_state(state);
		set_zip(zip);
		set_email(email);
		set_website(website);

	}

	public String get_firstName() {
		return _firstName;
	}

	public void set_firstName(String firstName) {
		this._firstName = firstName;
	}

	public String get_lastName() {
		return _lastName;
	}

	public void set_lastName(String lastName) {
		this._lastName = lastName;
	}

	public String get_phoneNumber() {
		return _phoneNumber;
	}

	public void set_phoneNumber(String phoneNumber) {
		this._phoneNumber = phoneNumber;
	}

	public String get_address() {
		return _address;
	}

	public void set_address(String address) {
		this._address = address;
	}

	public String get_address2() {
		return _address2;
	}

	public void set_address2(String address2) {
		this._address2 = address2;
	}

	public String get_city() {
		return _city;
	}

	public void set_city(String city) {
		this._city = city;
	}

	public String get_state() {
		return _state;
	}

	public void set_state(String state) {
		this._state = state;
	}

	public String get_zip() {
		return _zip;
	}

	public void set_zip(String zip) {
		this._zip = zip;
	}

	public String get_email() {
		return _email;
	}

	public void set_email(String zip) {
		this._email = zip;
	}

	public String get_website() {
		return _website;
	}

	public void set_website(String zip) {
		this._website = zip;
	}

	@Override
	public int compareTo(Contact c) {
		return (this._lastName).compareTo(c._lastName);
	}

}