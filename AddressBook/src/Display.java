import java.util.ArrayList;

public class Display {
	public static void display(ArrayList<Contact> contactArrayList) {
		int arrayListSize = contactArrayList.size();

		for (int i = 0; i < arrayListSize; i++) {
			Contact focusContact = contactArrayList.get(i); // contact were
															// looking at
			System.out.println("\n~~~~Contact #" + i + " ~~~~\n");
			System.out.println("First Name: " + focusContact.get_firstName());
			System.out.println("Last Name: " + focusContact.get_lastName());
			System.out.println("Phone Number: " + focusContact.get_phoneNumber());
			System.out.println("Address: " + focusContact.get_address());
			System.out.println("Address2: " + focusContact.get_address2());
			System.out.println("City: " + focusContact.get_city());
			System.out.println("State: " + focusContact.get_state());
			System.out.println("Zip Code: " + focusContact.get_zip());
		}
	}
}
