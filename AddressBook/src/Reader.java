import java.io.*;
import java.util.ArrayList;

/**
 * Read content from a .tsv file
 * 
 */

public class Reader {
	public static ArrayList<Contact> reader(String fileLocation) {
		String tsvFile = fileLocation + ".tsv";
		String line = "";
		String tsvSplitBy = "\t";	
		ArrayList<Contact> tempContactList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(tsvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
					String[] infoArr = line.split(tsvSplitBy);
					String[] contactInfo = { "", "", "", "", "", "", "", "", "", "", "", ""};
					for (int i = 0; i < infoArr.length; i++) {
						contactInfo[i] = infoArr[i];
					}
					if (contactInfo[5].isEmpty() && contactInfo[6].isEmpty()) {
						continue;
					} else {
						if (infoArr.length <= 8) {
							Contact tempContact = new Contact(contactInfo[0], contactInfo[1], contactInfo[2],
								contactInfo[3], contactInfo[4], contactInfo[5], contactInfo[6], contactInfo[7], " ",
								" ");
							tempContactList.add(tempContact);
						
						} else {
						Contact tempContact = new Contact(contactInfo[0], contactInfo[1], contactInfo[2], contactInfo[3], contactInfo[4],
								contactInfo[5], contactInfo[6], contactInfo[7], contactInfo[8], contactInfo[9]);
						tempContactList.add(tempContact);
						}
					}
			}
		} catch (IOException e) {}
		return tempContactList;
	}
}