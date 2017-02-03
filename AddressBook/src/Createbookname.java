import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//create new addressbook name interface
@SuppressWarnings("serial")
public class Createbookname extends JFrame {
	private JLabel prompt;
	private JPanel namepanel;
	public static JTextField bookname;
	private JButton submit;
	private static String inputaddressbook;
	public static String fileLocation = "";

	public Createbookname(String booksLocation) {
		super("Please enter an address book name");
		namepanel = new JPanel(new GridLayout(1, 3)); // only one panel in this
														// interface
		bookname = new JTextField();
		setInputaddressbook(bookname.getText());
		prompt = new JLabel("             New addressbook name:");
		submit = new JButton("submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // jump to the
															// addressbook
															// interface
				dispose();
				fileLocation = booksLocation + bookname.getText().toString();
				Frame1 f1 = new Frame1(fileLocation);
				f1.setLocation(200, 50);
				// f1.save(fileLocation);
				String locationWithTSV = fileLocation + ".tsv";
				Menu.addAddressBook(locationWithTSV);
			}
		});

		namepanel.add(prompt); // add all things to the panel
		namepanel.add(bookname);
		namepanel.add(submit);
		add(namepanel, BorderLayout.CENTER); // set panel location
		setSize(700, 70); // set frame size
		setVisible(true);
	}

	public static String getInputaddressbook() {
		return inputaddressbook;
	}

	public void setInputaddressbook(String inputaddressbook) {
		Createbookname.inputaddressbook = inputaddressbook;
	}

	public static String getFileLocation() {
		return fileLocation;
	}
}