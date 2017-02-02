
//package addressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {

	public static ArrayList<Contact> sortByLastname(ArrayList<Contact> sortArrayList) {

		Collections.sort(sortArrayList);

		return sortArrayList;
	}

	public static ArrayList<Contact> sortByZip(ArrayList<Contact> sortArrayList) {

		Collections.sort(sortArrayList, new ZipSorter());
		// Collections.sort(sortArrayList);

		return sortArrayList;
	}

}
