import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class deleteconfirmation extends JFrame {
	private JPanel labelpanel, buttonpanel;
	private JButton Yes, No;
	private JLabel confirmation;

	public deleteconfirmation(int rowToDelete) {
		labelpanel = new JPanel(new GridLayout(2, 1));
		buttonpanel = new JPanel(new GridLayout(1, 2));

		confirmation = new JLabel("            Are you sure you want to delete contact?");

		Yes = new JButton("Yes");
		Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame1.AddContactToTable();
				Frame1.deleteSelectedRow(rowToDelete);
				Frame1.save(Createbookname.bookname.getText().toString());
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
