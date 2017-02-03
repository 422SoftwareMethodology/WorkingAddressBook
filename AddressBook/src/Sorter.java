import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {
public static ArrayList<Contact> sortByLastname(ArrayList<Contact> sortArrayList) {
		
		for (int i = 0; i < sortArrayList.size(); i++){			
			Contact contact = sortArrayList.get(i);
			String lastname = contact.get_lastName();
			lastname = lastname.substring(0,1).toUpperCase() + lastname.substring(1);
			contact.set_lastName(lastname);
			
		}
		
		Collections.sort(sortArrayList, new Comparator<Contact>() {
		        public int compare(Contact c1, Contact c2) {
		            int result =  c1.get_lastName().compareToIgnoreCase(c2.get_lastName());
		            if (result != 0) {
		            	return result;
		            }
		            return c1.get_firstName().compareToIgnoreCase(c2.get_firstName());
		        }
	    });
		return sortArrayList;
	}

	public static ArrayList<Contact> sortByZip(ArrayList<Contact> sortArrayList) {
		Collections.sort(sortArrayList, new ZipSorter());
		Frame1.resortZIP = !Frame1.resortZIP;
		return sortArrayList;
	}
}