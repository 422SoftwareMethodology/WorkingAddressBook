import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//person info interface
@SuppressWarnings("serial")
public class PersonInfoEdit extends JFrame {
	private JPanel InfoPanel;
	private JLabel FirstName, LastName, phonenumber, ZIP_code, city, state, address1, address2, email, website;
	private JTextField fname, lname, phonenum, zip, c, s, a1, a2, em, f;
	private JButton Done, Cancel;
	private Contact tempContact;

	public PersonInfoEdit(ArrayList<Contact> openContactList, int rowSelected, String editFirstName,
			String editLastName, String editPhoneNumber, String editAddress1, String editAddress2, String editCity,
			String editState, String editZip, String editEmail, String editWebsite) {
		super("Contact Info!");
		Frame1.isEdited = true;
		tempContact = new Contact(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ");
		setLayout(new BorderLayout());

		InfoPanel = new JPanel(new GridLayout(11, 2)); // one panel in this
														// interface

		FirstName = new JLabel("            First Name"); // all attributes
															// labels
		LastName = new JLabel("            Last Name");
		phonenumber = new JLabel("            Phone Number");
		address1 = new JLabel("            Address");
		address2 = new JLabel("            Address 2");
		city = new JLabel("            City");
		state = new JLabel("            State");
		ZIP_code = new JLabel("            ZIP");
		email = new JLabel("            Email");
		website = new JLabel("            Website");

		fname = new JTextField(editFirstName); // all text areas
		lname = new JTextField(editLastName);
		phonenum = new JTextField(editPhoneNumber);
		zip = new JTextField(editZip);
		c = new JTextField(editCity);
		s = new JTextField(editState);
		a1 = new JTextField(editAddress1);
		a2 = new JTextField(editAddress2);
		em = new JTextField(editEmail);
		f = new JTextField(editWebsite);

		Done = new JButton("Done"); // click this button to save the info
		Done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int checknum = 0;
				if (phonenum.getText().isEmpty())
					checknum += 1;
				if (a1.getText().isEmpty())
					checknum += 1;
				if (a2.getText().isEmpty())
					checknum += 1;
				if (c.getText().isEmpty())
					checknum += 1;
				if (s.getText().isEmpty())
					checknum += 1;
				if (zip.getText().isEmpty())
					checknum += 1;
				if (em.getText().isEmpty())
					checknum += 1;
				if (f.getText().isEmpty())
					checknum += 1;
				if (fname.getText().isEmpty() && lname.getText().isEmpty()) {
					Prompt1 p1 = new Prompt1();
					p1.setLocation(300, 200);
				} else if (checknum == 8) {
					Prompt1 p1 = new Prompt1();
					p1.setLocation(300, 200);
				}

				else {
					if (zip.getText().isEmpty()) {
						tempContact.set_firstName(fname.getText());
						tempContact.set_lastName(lname.getText());
						tempContact.set_phoneNumber(phonenum.getText());
						tempContact.set_address(a1.getText());
						tempContact.set_address2(a2.getText());
						tempContact.set_city(c.getText());
						tempContact.set_state(s.getText());
						tempContact.set_zip(zip.getText());
						tempContact.set_email(em.getText());
						tempContact.set_website(f.getText());
						openContactList.add(tempContact);
						Frame1.AddContactToTable();
						Frame1.deleteSelectedRow(rowSelected);
						Frame1.AddTableToContact();
						dispose(); // after customer click the button, close the
									// current window and save data
					}

					else if ((zip.getText().isEmpty() == false) && (checkzip(zip.getText()) == false)) {
						promptzip p2 = new promptzip(openContactList, rowSelected, editFirstName, editLastName,
								editPhoneNumber, editAddress1, editAddress2, editCity, editState, editZip);
						p2.setLocation(500, 200);
					}

					else {
						tempContact.set_firstName(fname.getText());
						tempContact.set_lastName(lname.getText());
						tempContact.set_phoneNumber(phonenum.getText());
						tempContact.set_address(a1.getText());
						tempContact.set_address2(a2.getText());
						tempContact.set_city(c.getText());
						tempContact.set_state(s.getText());
						tempContact.set_zip(zip.getText());
						tempContact.set_email(em.getText());
						tempContact.set_website(f.getText());
						openContactList.add(tempContact);
						Frame1.AddContactToTable();
						Frame1.deleteSelectedRow(rowSelected);
						Frame1.AddTableToContact();
						dispose(); // after customer click the button, close the
									// current window and save data
					}
				}

			}
		});
		Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // after customer click the button, close the current
							// window and do not save data
			}
		});

		InfoPanel.add(FirstName); // add allthings to the panel
		InfoPanel.add(fname);
		InfoPanel.add(LastName);
		InfoPanel.add(lname);
		InfoPanel.add(phonenumber);
		InfoPanel.add(phonenum);
		InfoPanel.add(address1);
		InfoPanel.add(a1);
		InfoPanel.add(address2);
		InfoPanel.add(a2);
		InfoPanel.add(city);
		InfoPanel.add(c);
		InfoPanel.add(state);
		InfoPanel.add(s);
		InfoPanel.add(ZIP_code);
		InfoPanel.add(zip);
		InfoPanel.add(email);
		InfoPanel.add(em);
		InfoPanel.add(website);
		InfoPanel.add(f);
		InfoPanel.add(Done);
		InfoPanel.add(Cancel);

		InfoPanel.setBackground(Color.green); // set background color of panel

		add(InfoPanel, BorderLayout.CENTER); // set panel location
		setSize(500, 500); // set frame size
		setVisible(true);

	}

	public boolean checkzip(String s) {
		if (s.length() == 5 || s.length() == 10) {
			if (s.length() == 5) {
				String digit5 = "\\d{5}";
				boolean b1 = s.matches(digit5);
				return b1;
			} else if (s.length() == 10) {
				String digit10 = "\\d{5}" + "-" + "\\d{4}";
				boolean b2 = s.matches(digit10);
				return b2;
			}
		}
		return false;
	}

	class promptzip extends JFrame {
		private JButton SaveButton, NoButton;
		private JLabel Warning;
		private JPanel panel, buttonpanel;

		public promptzip(ArrayList<Contact> openContactList, int rowSelected, String editFirstName, String editLastName,
				String editPhoneNumber, String editAddress1, String editAddress2, String editCity, String editState,
				String editZip) {
			panel = new JPanel(new GridLayout(1, 1));
			buttonpanel = new JPanel(new GridLayout(1, 2));
			Warning = new JLabel("                      ");
			SaveButton = new JButton("Save");
			SaveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tempContact.set_firstName(fname.getText());
					tempContact.set_lastName(lname.getText());
					tempContact.set_phoneNumber(phonenum.getText());
					tempContact.set_address(a1.getText());
					tempContact.set_address2(a2.getText());
					tempContact.set_city(c.getText());
					tempContact.set_state(s.getText());
					tempContact.set_zip(zip.getText());
					tempContact.set_email(em.getText());
					tempContact.set_website(f.getText());
					openContactList.add(tempContact);
					Frame1.AddContactToTable();
					Frame1.deleteSelectedRow(rowSelected);
					Frame1.AddTableToContact();
					dispose();
					Cancel.doClick();
				}
			});
			NoButton = new JButton("No");
			NoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			panel.add(Warning);
			buttonpanel.add(SaveButton);
			buttonpanel.add(NoButton);
			add(panel, BorderLayout.NORTH);
			add(buttonpanel, BorderLayout.CENTER);
			setSize(450, 90);
			setVisible(true);
		}
	}
}