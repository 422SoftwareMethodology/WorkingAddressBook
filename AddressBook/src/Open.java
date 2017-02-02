import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class Open {
	public static Desktop d = Desktop.getDesktop();

	public static boolean FOpen() {
		try {
			if (OSDetector.isWindows()) {
				d.open(new File("C:\\"));
				return true;
			} else if (OSDetector.isLinux() || OSDetector.isMac()) {
				d.open(new File("/users/"));
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return false;
		}
	}

	public static void openURI(URI uri) {
		try {
			d.browse(uri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
