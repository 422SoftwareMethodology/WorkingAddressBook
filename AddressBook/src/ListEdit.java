
import java.util.ArrayList;

public class ListEdit {
	public static void finder(ArrayList<Contact> arrayList, String searchKey) {

		// store index of Contact objects for multiple last names
		ArrayList<Contact> foundArrayList = new ArrayList<>();

		int arrayListSize = arrayList.size();

		// Very simple search. Room for improvement..
		for (int i = 0; i < arrayListSize; i++) {
			Contact focusContact = arrayList.get(i); // contact were looking at

			String currentLastName = focusContact.get_lastName();
			String currentFirstName = focusContact.get_firstName();
			String currentPhoneNumber = focusContact.get_phoneNumber();
			String currentAddress = focusContact.get_address();
			String currentAddress2 = focusContact.get_address2();
			String currentCity = focusContact.get_city();
			String currentState = focusContact.get_state();
			String currentZip = focusContact.get_zip();

			if ((currentLastName.equals(searchKey))) {
				foundArrayList.add(focusContact);
			}

			else if ((currentFirstName.equals(searchKey))) {
				foundArrayList.add(focusContact);
			}

			else if ((currentLastName.equals(searchKey))) {
				foundArrayList.add(focusContact);
			}

			else if ((currentPhoneNumber.equals(searchKey))) {
				foundArrayList.add(focusContact);
			}

			else if ((currentAddress.equals(searchKey))) {
				foundArrayList.add(focusContact);
			}

			else if ((currentAddress2.equals(searchKey))) {
				foundArrayList.add(focusContact);
			}

			else if ((currentCity.equals(searchKey))) {
				foundArrayList.add(focusContact);
			}

			else if ((currentState.equals(searchKey))) {
				foundArrayList.add(focusContact);
			}

			else if ((currentZip.equals(searchKey))) {
				foundArrayList.add(focusContact);
			}
		}

		// didn't find anything
		if (foundArrayList.isEmpty()) {
			System.out.println("\n\nDidn't find anything");
		}
		// found some names
		else {
			System.out.println("\n\nWe found the contact. Huzzah!");
			Display.display(foundArrayList);
		}

		FoundFrame f1 = new FoundFrame(foundArrayList);
		f1.setLocation(200, 200);

		return;
	}

}