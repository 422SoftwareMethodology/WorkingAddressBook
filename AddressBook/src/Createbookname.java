import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
		super("Please enter the addressbook name!");
		namepanel = new JPanel(new GridLayout(1, 3)); // only one panel in this
														// interface
		bookname = new JTextField();
		setInputaddressbook(bookname.getText());
		System.out.println(bookname.getText().toString());
		prompt = new JLabel("             New addressbook name:");
		submit = new JButton("submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // jump to the
															// addressbook
															// interface
				dispose(); // after customer click the button, close the current
							// window
				// String fileLoc = new
				// File(bookname.getText().toString()).getAbsolutePath(); //
				// Default Save Path
				fileLocation = booksLocation + bookname.getText().toString();
				Frame1 f1 = new Frame1(fileLocation);
				f1.setLocation(200, 50);
				// f1.save(fileLocation);
				String locationWithTSV = fileLocation + ".tsv";
				Menu.addAddressBook(locationWithTSV);
			}
		});

		namepanel.add(prompt); // add allthings to the panel
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
		this.inputaddressbook = inputaddressbook;
	}

	public static String getFileLocation() {
		return fileLocation;
	}
}
