import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ZipSorter implements Comparator<Contact> {
	@Override
	public int compare(Contact c1, Contact c2) {
		if ((c1.get_zip().compareTo(c2.get_zip())) > 0) {
			return -1;
		} else {
			return 1;
		}
	}

}
