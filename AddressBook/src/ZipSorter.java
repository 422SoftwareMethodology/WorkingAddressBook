import java.util.Comparator;

public class ZipSorter implements Comparator<Contact> {
	@Override
	public int compare(Contact c1, Contact c2) {
		if (Frame1.resortZIP == true) {
			if ((c1.get_zip().compareTo(c2.get_zip())) > 0) {
				return 1;
			} else {
				return -1;
			}
		} else {
			if ((c1.get_zip().compareTo(c2.get_zip())) > 0) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}
