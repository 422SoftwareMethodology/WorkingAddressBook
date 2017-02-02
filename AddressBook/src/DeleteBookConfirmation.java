import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DeleteBookConfirmation extends JFrame {
	private JPanel labelpanel, buttonpanel;
	private JButton Yes, No;
	private JLabel confirmation;

	public DeleteBookConfirmation(int rowToDelete, String bookName) {
		labelpanel = new JPanel(new GridLayout(2, 1));
		buttonpanel = new JPanel(new GridLayout(1, 2));

		confirmation = new JLabel("            Are you sure you want to delete this address book?");

		Yes = new JButton("Yes");
		Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookLocation = Menu.bookFolderLoc + bookName + ".tsv";
				File f = new File(bookLocation);
				f.delete();
				Menu.addressBookNames.remove(bookName + ".tsv");
				Menu.refreshTable(Menu.addressBookNames);
				dispose();
			}
		});

		No = new JButton("No");
		No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		labelpanel.add(confirmation);
		buttonpanel.add(Yes);
		buttonpanel.add(No);

		add(labelpanel, BorderLayout.NORTH);
		add(buttonpanel, BorderLayout.CENTER);

		setSize(350, 90);
		setVisible(true);

	}

}