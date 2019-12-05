package library;

import java.util.ArrayList;

import BreezySwing.*;
import javax.swing.*;

public class Search extends GBDialog {
	ArrayList<Books> books;
	String searchInput;
	boolean inList = false;
	Books bookFound;
	JList<String> bookList = addList(2, 1, 1, 1);
	JTextArea infoArea = addTextArea("", 2, 2, 1, 1);
	JTextField searchField = addTextField("", 1, 2, 1, 1);
	JButton searchButton = addButton("Search", 3, 1, 1, 1);
	JLabel searchlbl = addLabel("Search Title: ", 1, 1, 1, 1);
	JButton close = addButton("Close", 3, 2, 1, 1);
	Date d = new Date();

	public Search(JFrame parent, ArrayList<Books> b) {
		super(parent);
		books = b;
		this.setVisible(true);
		this.setSize(400, 400);
	}

	public boolean checkName(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isWhitespace(s.charAt(i)))
				return false;
		}
		return true;
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == searchButton) {
			if (checkName(searchField.getText())) {
				messageBox("Please enter a Title");
				return;
			}
			if (!findBook()) {
				messageBox("There are no books with the title " + searchField.getText());
				return;
			}
			populateList();
		} else if (buttonObj == close) {
			dispose();
		}
	}

	public boolean findBook() {
		searchInput = searchField.getText();
		for (Books item : books) {
			if (searchInput.equalsIgnoreCase(item.getTitle())) {
				inList = true;
				bookFound = item;
			}
		}
		return inList;
	}

	private void populateList() {
		DefaultListModel DLM = new DefaultListModel();
		for (Books b : books) {
			if (b.getTitle().equalsIgnoreCase(searchField.getText()))
				DLM.addElement(b.getTitle());
		}
		bookList.setModel(DLM);
	}

	public void output() {
		infoArea.setText("Title: " + bookFound.getTitle());
		infoArea.setText(infoArea.getText() + '\n' + ("Author: " + bookFound.getAuthor()));
		infoArea.setText(infoArea.getText() + '\n' + ("Available: " + bookFound.getLoaned()));
		if (!bookFound.getLoaned()) {
			infoArea.setText(infoArea.getText() + '\n' + ("Borrower: " + bookFound.getBorrower()));
			infoArea.setText(infoArea.getText() + '\n' + ("Date Borrowed: " + bookFound.getMonth() + '/'
					+ bookFound.getDay() + '/' + bookFound.getYear()));
			if (d.setTimeMili() - bookFound.getTimeInMili() > 1209600000)
				infoArea.setText(infoArea.getText() + '\n' + ("Status: Overdue"));
		}

	}

	public void listDoubleClicked(JList<String> list, String itemSelected) {
		if (books.get(list.getSelectedIndex()).getLoaned()) {
			infoArea.setText("Book Selected:\n" + books.get(list.getSelectedIndex()).toStringAvail());
			revalidate();
		} else {
			infoArea.setText("Book Selected:\n" + books.get(list.getSelectedIndex()).toStringBorrowed());
			revalidate();
			return;
		}
	}

}
