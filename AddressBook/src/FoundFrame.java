import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class FoundFrame extends JFrame {
	private JPanel buttonPanel1, TextPanel;
	private JScrollPane scroll;
	private static JTable table1;
	private static DefaultTableModel tableModel;
	public int rowSelected = -1;
	public static ArrayList<Contact> foundContactList = new ArrayList<Contact>(); //found search items
	
	public FoundFrame(ArrayList<Contact> newContactList) { // main interface of AddressBook
		super("AddressBook");
		setLayout(new BorderLayout());
		foundContactList = newContactList;
		buttonPanel1 = new JPanel(new GridLayout(1, 5)); // panel for buttons
		TextPanel = new JPanel(new GridLayout(1, 3)); // panel for search
														new JPanel(new GridLayout(1, 1));
		String[] columnNames = { "firstname", "lastname", "phonenumber", "address", "address2", "city", "state",
				                 "zipcode" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table1 = new JTable(tableModel);
		TableColumn column = null;
		int colunms = table1.getColumnCount();
		for (int i = 0; i < colunms; i++) {
			column = table1.getColumnModel().getColumn(i);
			column.setPreferredWidth(100);
		}
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scroll = new JScrollPane(table1);

		add(buttonPanel1, BorderLayout.NORTH); // set panel location
		add(TextPanel, BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);

		// Mouse Interactions~~~~~~~~~~~~~
		table1.addMouseListener(new MouseAdapter() { // click on cell
			public void mousePressed(MouseEvent e) {

				int row = table1.rowAtPoint(e.getPoint());
				table1.getSelectionModel().setSelectionInterval(row, row);
				rowSelected = row;
			}
		});

		// Click header to sort
		table1.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int col = table1.columnAtPoint(e.getPoint());
				if (col == 1) {
					Sorter.sortByLastname(foundContactList);
					AddContactToFoundTable();
				}
				if (col == 7) {
					Sorter.sortByZip(foundContactList);
					AddContactToFoundTable();
				}
			}

		});

		AddContactToFoundTable(); // This is the display refresh
		setSize(1000, 500); // set frame size
		setVisible(true);
	}

	public static void AddContactToFoundTable() {
		if (tableModel.getRowCount() > 0) {
			for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
				tableModel.removeRow(i);
			}
		}
		String firstName = " ", lastName = " ", phoneNumber = " ", address = " ", address2 = " ", city = " ",
			   state = " ", zip = " ";
		for (int i = 0; i < foundContactList.size(); ++i) {
			firstName = foundContactList.get(i).get_firstName();
			lastName = foundContactList.get(i).get_lastName();
			phoneNumber = foundContactList.get(i).get_phoneNumber();
			address = foundContactList.get(i).get_address();
			address2 = foundContactList.get(i).get_address2();
			city = foundContactList.get(i).get_city();
			state = foundContactList.get(i).get_state();
			zip = foundContactList.get(i).get_zip();

			Object[] data = { firstName, lastName, phoneNumber, address, address2, city, state, zip };
			FoundFrame.tableModel.addRow(data);
		}
	}

	public static ArrayList<Contact> AddTableToFoundContact() {
		int nRow = tableModel.getRowCount(), nCol = tableModel.getColumnCount();
		ArrayList<Contact> tempContactList = new ArrayList<>();
		String[] contactInfo = new String[nCol + 1];

		for (int i = 0; i < nRow; i++) {
			for (int j = 0; j < nCol; j++) {
				contactInfo[j] = (String) tableModel.getValueAt(i, j);
			}
			Contact tempContact = new Contact(contactInfo[0], contactInfo[1], contactInfo[2], contactInfo[3],
					contactInfo[4], contactInfo[5], contactInfo[6], contactInfo[7], contactInfo[8], contactInfo[9]);
			tempContactList.add(tempContact);
		}
		return tempContactList;
	}
}