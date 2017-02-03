import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import junit.framework.Test;

//~~~~~~~~~~~~~~~~~~~Glossary~~~~~~~~~~~~~~
//~~~Classes
//Contact: Contains all contact info
//Reader: reads content from a file (tsv) and returns arrayList (AKA Load)
//Writer: takes arrayList and writes it to a file (AKA Save)
//Display: unpackages objects and displays them as an array of strings
//Sorter: sorts arrayList by either lastName or zip
//ListEdit: contains find, add, delete, and edit funcitons
//~~~Main Variables
//openContactList: the current working ArrayList

public class AddressBook {

	public static void main(String args[]) throws FileNotFoundException {
		final ArrayList<String> AddressBookNames = new ArrayList<String>();
		String bookLocation;
		String exportLocation;

		//Code to determine operating system and create the necessary folders
		//used by the program if they don't already exist
		if (OSDetector.isWindows()) {
			bookLocation = System.getProperty("user.dir") + "\\" + "AddressBooks\\";
			exportLocation = System.getProperty("user.dir") + "\\" + "Exports\\";
			File f = new File(bookLocation);
			if (!f.exists()) {
				new File(bookLocation).mkdir();
				new File(exportLocation).mkdir();
			} else {
				File folder = new File(bookLocation);
				File[] listOfFiles = folder.listFiles();
				for (int i = 0; i < listOfFiles.length; i++) {
					AddressBookNames.add(listOfFiles[i].getName());
				}
			}
		} else if (OSDetector.isLinux() || OSDetector.isMac()) {
			bookLocation = System.getProperty("user.dir") + "/" + "AddressBooks/";
			exportLocation = System.getProperty("user.dir") + "/" + "Exports/";
			File f1 = new File(bookLocation);
			if (!f1.exists()) {
				exportLocation = System.getProperty("user.dir") + "/" + "Exports/";
				new File(bookLocation).mkdir();
				new File(exportLocation).mkdir();
			} else {
				File folder = new File(bookLocation);
				File[] listOfFiles = folder.listFiles();
				for (int i = 0; i < listOfFiles.length; i++) {
					AddressBookNames.add(listOfFiles[i].getName());
				}
			}
		} else {
			bookLocation = Test.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			exportLocation = Test.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		}
		Menu frame = new Menu(AddressBookNames);
		frame.setBookLoc(bookLocation);
		frame.setExportLoc(exportLocation);
		frame.setVisible(true);
	}
}