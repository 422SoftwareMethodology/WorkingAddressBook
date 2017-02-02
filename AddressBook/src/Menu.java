import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JFileChooser;

//Menu Interface
@SuppressWarnings("serial")
public class Menu extends JFrame {
	private JButton newbutton, openbutton, quitbutton, deletebutton, importbutton, exportbutton, editbutton;
	private JScrollPane sc;
	private JLabel titlelabel;
	private JTextArea text;
	private JTable table;
	private int rowSelected = -1;
	public static String bookFolderLoc = System.getProperty("user.dir");
	private String exportFolderLoc = System.getProperty("user.dir");
	private ArrayList<Contact> importContacts;
	private ArrayList<Contact> exportContacts;
	public static ArrayList<String> addressBookNames;
	private static DefaultTableModel tableModel;

	public Menu(ArrayList<String> addressNames) {
		super("Welcome!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setLayout(new BorderLayout());
		addressBookNames = addressNames;
		JFileChooser chooser = new JFileChooser();

		// Container c= getContentPane();
		// c.setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel(new GridLayout(1, 7)); // panel for
																// buttons
		// JPanel titlepanel = new JPanel(new GridLayout(1, 1)); //panel in the
		// center, we may change it to a display field that shows all
		// addressbooks exists.
		// titlepanel.setBackground(Color.yellow);
		newbutton = new JButton("New");
		newbutton.setBackground(Color.green);
		newbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // jump to the create
															// addressbook name
															// window.
				Createbookname c1 = new Createbookname(bookFolderLoc);
				c1.setLocation(100, 50);
				/*
				 * Frame1 f1 = new Frame1(c1.fileLocation); f1.setLocation(200,
				 * 50); f1.save(c1.fileLocation);
				 * addressBookNames.add(c1.getFileLocation());
				 * refreshTable(addressBookNames);
				 */
			}
		});

		openbutton = new JButton("Open");
		openbutton.setBackground(Color.green);
		openbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // jump to the
															// addressbook
															// interface.
				String fileName = (String) table.getValueAt(rowSelected, 0);
				// fileName = addTSV(fileName);
				String fileLoc = bookFolderLoc + fileName;
				System.out.println(fileLoc);
				Frame1 f1 = new Frame1(fileLoc);
				f1.setLocation(150, 50);
			}
		});

		deletebutton = new JButton("Delete");
		deletebutton.setBackground(Color.green);
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = (String) table.getValueAt(rowSelected, 0);
				DeleteBookConfirmation deleteBook = new DeleteBookConfirmation(rowSelected, fileName);
				
				/*
				
				fileName = addTSV(fileName);
				String trimmed = trimTSV(fileName);
				String fileLocation = bookFolderLoc + fileName;
				File f = new File(fileLocation);
				f.delete();
				addressBookNames.remove(fileName);
				refreshTable(addressBookNames);
				*/
			}
		});
		
		editbutton = new JButton("Edit");
		editbutton.setBackground(Color.green);
		editbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				 String currentName = (String) table.getValueAt(rowSelected, 0);
				 EditAddressName editWindow = new EditAddressName(currentName);
			}
		});


		importbutton = new JButton("Import");
		importbutton.setBackground(Color.green);
		importbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = chooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION){
				System.out.println(chooser.getSelectedFile());
				String path = chooser.getSelectedFile().getAbsolutePath();
				
				path = trimTSV(path);
				importContacts = Reader.reader(path);
				System.out.println("importContacts length: " + Integer.toString(importContacts.size()));
				String FileName = getFileName(chooser.getSelectedFile().getAbsolutePath());
				String trimmed = trimTSV(FileName);
				String newFileLocation = bookFolderLoc + trimmed;
				try {
					Writer.writer(importContacts, bookFolderLoc + trimmed);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				addressBookNames.add(FileName);
				refreshTable(addressBookNames);
				Frame1 f2 = new Frame1(newFileLocation);
				f2.setLocation(150, 50);

				System.out.println(FileName);
				}
			}
		});

		exportbutton = new JButton("Export");
		exportbutton.setBackground(Color.green);
		exportbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = (String) table.getValueAt(rowSelected, 0);
				//String trimmed = trimTSV(fileName);
				String fileLoc = bookFolderLoc + fileName;
				exportContacts = Reader.reader(fileLoc);
				try {
					Writer.exportWriter(exportContacts, exportFolderLoc + fileName);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		quitbutton = new JButton("Quit");
		quitbutton.setBackground(Color.green);
		quitbutton.addActionListener(new ActionListener() { // end the program.
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		Object[][] obj = new Object[addressNames.size()][1];
		for (int i = 0; i < addressNames.size(); i++) {
			for (int j = 0; j < 1; j++) {
				String temp = addressNames.get(i);
				obj[i][j] = temp;
			}
		}

		// text = new JTextArea();
		String[] columnNames = { "Address books				" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		table.setEnabled(false);
		TableColumn column = null;
		int colunms = table.getColumnCount();
		for (int i = 0; i < colunms; ++i) {
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(700);
		}

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sc = new JScrollPane(table);
		refreshTable(addressBookNames);

		// bookmenu = new JMenuBar();

		// titlelabel = new JLabel();
		// titlelabel.setText(Createbookname.getInputaddressbook());
		// titlelabel.setFont(new java.awt.Font("Dialog", 1, 25)); //setfont
		// size and style.
		buttonPanel.add(newbutton); // add all buttons to the panel
		buttonPanel.add(openbutton);
		buttonPanel.add(deletebutton);
		buttonPanel.add(editbutton);
		buttonPanel.add(importbutton);
		buttonPanel.add(exportbutton);
		buttonPanel.add(quitbutton);
		// titlepanel.add(bookmenu);
		add(buttonPanel, BorderLayout.NORTH); // set panel location
		// add(titlepanel, BorderLayout.CENTER);
		add(sc, BorderLayout.CENTER);
		sc.setVisible(true);
		setSize(700, 500); // set frame size

		table.addMouseListener(new MouseAdapter() { // click on cell
			public void mousePressed(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);
				System.out.println(row);
				rowSelected = row;
			}
		});

	}

	public static void addAddressBook(String fileLoc) {
		String bookName = getFileName(fileLoc);
		System.out.println("This is the file name: " + fileLoc);
		addressBookNames.add(bookName);
		refreshTable(addressBookNames);
	}

	public void setBookLoc(String bookLoc) {
		bookFolderLoc = bookLoc;
	}

	public void setExportLoc(String exportLoc) {
		exportFolderLoc = exportLoc;
	}

	public static String getFileName(String fileLocation) {
		int length = fileLocation.length();
		String fileName = "";
		String tempString = "";
		for (int i = length - 1; i > 1; i--) {
			tempString = fileLocation.substring(i, i + 1);
			if (tempString.equals("\\") || tempString.equals("/")) {
				break;
			} else {
				fileName = tempString + fileName;
			}
		}
		return fileName;
	}

	public static String trimTSV(String fileName) {
		int length = fileName.length();
		String returnName = fileName.substring(0, length - 4);
		System.out.println(returnName);
		return returnName;
	}

	public static String addTSV(String fileName) {
		return fileName + ".tsv";
	}

	public static void refreshTable(ArrayList<String> bookNames) {
		if (tableModel.getRowCount() > 0) {
			for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
				tableModel.removeRow(i);
			}
		}
		String bookName = "";
		for (int i = 0; i < bookNames.size(); i++) {
			bookName = bookNames.get(i);
			bookName = trimTSV(bookName);
			Object[] data = { bookName };
			Menu.tableModel.addRow(data);

		}

	}
	
	public static void setNewAddressBookName(String newName, String oldName){
		Path oldPath = Paths.get(bookFolderLoc + oldName + ".tsv" );
		Path newPath = Paths.get(bookFolderLoc + newName + ".tsv");
		try {
			Files.move(oldPath, oldPath.resolveSibling(newPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addressBookNames.remove(oldName + ".tsv");
		addressBookNames.add(newName + ".tsv");
		refreshTable(addressBookNames);
	}

}
