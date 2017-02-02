import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

//~~~~~~~~~~~~~~~~~~~Glossary~~~~~~~~~~~~~~
//~~~Classes
//Contact: Contains all contact info
//Reader: reads content from a file (csv) and returns arrayList (AKA Load)
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

		if (OSDetector.isWindows()) {
			bookLocation = System.getProperty("user.dir") + "\\" + "AddressBooks\\";
			exportLocation = System.getProperty("user.dir") + "\\" + "Exports\\";
			System.out.println(bookLocation);
			File f = new File(bookLocation);
			if (!f.exists()) {
				System.out.print("File Doesn't Exists. Creating Folder");
				new File(bookLocation).mkdir();
				new File(exportLocation).mkdir();

			} else {
				System.out.println("File Exits");

				File folder = new File(bookLocation);
				File[] listOfFiles = folder.listFiles();
				System.out.println("In main. List of files names as added to arrayList: ");
				for (int i = 0; i < listOfFiles.length; i++) {
					AddressBookNames.add(listOfFiles[i].getName());
					System.out.println(listOfFiles[i].getName());
				}
			}
		} else {
			bookLocation = System.getProperty("user.dir") + "/" + "AddressBooks/";
			exportLocation = System.getProperty("user.dir") + "/" + "Exports/";
			System.out.println(bookLocation);
			File f1 = new File(bookLocation);
			if (!f1.exists()) {
				System.out.println("File Doesn't Exist. Creating Folder");
				exportLocation = System.getProperty("user.dir") + "/" + "Exports/";
				new File(bookLocation).mkdir();
				new File(exportLocation).mkdir();
			} else {
				System.out.println("File Exists");

				File folder = new File(bookLocation);
				File[] listOfFiles = folder.listFiles();

				for (int i = 0; i < listOfFiles.length; i++) {
					AddressBookNames.add(listOfFiles[i].getName());
					System.out.println(listOfFiles[i].getName());
				}
			}
		}

		Menu frame = new Menu(AddressBookNames);
		frame.setBookLoc(bookLocation);
		frame.setExportLoc(exportLocation);
		frame.setVisible(true);
	}

}
