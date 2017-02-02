
//package addressbook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {
	static String header = new String("CITY" + '\t' + "STATE" + '\t' + "ZIP" + '\t' + "Delivery" +
            '\t' + "Second" + '\t' + "LastName" + '\t' + "FirstName" +
            '\t' + "Phone" + '\n');
	public static void writer(ArrayList<Contact> contactArrayList, String fileLoc) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(new File(fileLoc + ".tsv").getAbsolutePath())) {
			StringBuilder sb = new StringBuilder();
			pw.write(header);
			int arrayListSize = contactArrayList.size();
			for (int i = 0; i < arrayListSize; i++) {
				Contact focusContact = contactArrayList.get(i);
				sb.append(focusContact.get_city());
				sb.append('\t');
				sb.append(focusContact.get_state());
				sb.append('\t');
				sb.append(focusContact.get_zip());
				sb.append('\t');
				sb.append(focusContact.get_address());
				sb.append('\t');
				sb.append(focusContact.get_address2());
				sb.append('\t');
				sb.append(focusContact.get_lastName());
				sb.append('\t');
				sb.append(focusContact.get_firstName());
				sb.append('\t');
				sb.append(focusContact.get_phoneNumber());
				sb.append('\t');
				sb.append(focusContact.get_email()); // email 8
				sb.append('\t');
				sb.append(focusContact.get_website()); // website 9
				sb.append('\n'); // end of contact
			}

			pw.write(sb.toString());
		}
		System.out.println("done!");
	}

	public static void saveAsWriter(ArrayList<Contact> contactArrayList, String path) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(new File(path + ".tsv"))) {
			StringBuilder sb = new StringBuilder();
			pw.write(header);
			int arrayListSize = contactArrayList.size();
			for (int i = 0; i < arrayListSize; i++) {
				Contact focusContact = contactArrayList.get(i);
				sb.append(focusContact.get_city());
				sb.append('\t');
				sb.append(focusContact.get_state());
				sb.append('\t');
				sb.append(focusContact.get_zip());
				sb.append('\t');
				sb.append(focusContact.get_address());
				sb.append('\t');
				sb.append(focusContact.get_address2());
				sb.append('\t');
				sb.append(focusContact.get_lastName());
				sb.append('\t');
				sb.append(focusContact.get_firstName());
				sb.append('\t');
				sb.append(focusContact.get_phoneNumber());
				sb.append('\t');
				sb.append(focusContact.get_email()); // email 8
				sb.append('\t');
				sb.append(focusContact.get_website()); // website 9
				sb.append('\n'); // end of contact
			}

			pw.write(sb.toString());
		}
		System.out.println("done!");
	}

	public static void exportWriter(ArrayList<Contact> contactArrayList, String path) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(new File(path + ".tsv"))) {
			StringBuilder sb = new StringBuilder();
			pw.write(header);
			int arrayListSize = contactArrayList.size();

			for (int i = 0; i < arrayListSize; i++) {
				Contact focusContact = contactArrayList.get(i);
				sb.append(focusContact.get_city());
				sb.append('\t');
				sb.append(focusContact.get_state());
				sb.append('\t');
				sb.append(focusContact.get_zip());
				sb.append('\t');
				sb.append(focusContact.get_address());
				sb.append('\t');
				sb.append(focusContact.get_address2());
				sb.append('\t');
				sb.append(focusContact.get_lastName());
				sb.append('\t');
				sb.append(focusContact.get_firstName());
				sb.append('\t');
				sb.append(focusContact.get_phoneNumber());
				sb.append('\n');
			}

			pw.write(sb.toString());
		}
		System.out.println("done!");
	}

}
