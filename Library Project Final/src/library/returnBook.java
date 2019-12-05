package library;

import BreezySwing.*;

import java.util.ArrayList;

import javax.swing.*;

public class returnBook extends GBDialog {
	JLabel titlelbl = addLabel ("Title:",1,1,1,1);
	JLabel infolbl = addLabel ("Book information:",1,2,1,1);
	JList<String> bookList = addList(2, 1, 1, 1);
	JTextArea infoArea = addTextArea("", 2, 2, 1, 1);
	JButton enterButton = addButton("Return", 3, 1, 1, 1);
	JButton close = addButton("Close", 3, 2, 1, 1);
	Books foundBook = null;
	boolean found = true;
	ArrayList<Books> books;

	public returnBook(JFrame parent, ArrayList<Books> list) {
		super(parent);
		books = list;
		populateList();
		this.setSize(400, 400);
		this.setVisible(true);

	}

	private void populateList() {
		DefaultListModel DLM = new DefaultListModel();
		for (Books b : books) {
			DLM.addElement(b.getTitle());
		}
		bookList.setModel(DLM);
	}

	public void listDoubleClicked(JList<String> list, String itemSelected) {
		if (books.get(list.getSelectedIndex()).getLoaned()) {
			infoArea.setText("Book Selected:\n" + books.get(list.getSelectedIndex()).toStringAvail());
			foundBook = books.get(list.getSelectedIndex());
			found = false;
			revalidate();
			return;
		} else {
			infoArea.setText("Book Selected:\n" + books.get(list.getSelectedIndex()).toStringBorrowed());
			foundBook = books.get(list.getSelectedIndex());
			revalidate();

		}
	}

	public void listItemSelected(JList<String> list, String itemSelected) {
		if (books.get(list.getSelectedIndex()).getLoaned()) {
			infoArea.setText("Book Selected:\n" + books.get(list.getSelectedIndex()).toStringAvail());
		} else {
			infoArea.setText("Book Selected:\n" + books.get(list.getSelectedIndex()).toStringBorrowed());
			return;
		}
		revalidate();
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enterButton) {

			if (foundBook == null) {
				messageBox("Please Select a Book to Return");
				return;
			}
			if (foundBook.getLoaned()) {
				messageBox("This book is not currently checked out");
				return;
			}
			Date d = new Date(0, 0, 0);
			foundBook.setLoaned();
			foundBook.setDate(d);
			foundBook.setBorrower(null);
			messageBox(foundBook.getTitle() + " was returned");
		} else if (buttonObj == close) {
			dispose();
		}

	}

//	public void findBook() {
//		String title = titleFld.getText();
//		for (Books item : books) {
//			if (title.equalsIgnoreCase(item.getTitle())) {
//				foundBook = item;
//				found = true;
//			}
//
//		}
//	}

//	public void checkOut() {
//		if (!found) {
//			messageBox("There is no book with this title");
//		} else if (found && !foundBook.getLoaned()) {
//			messageBox(titleFld.getText() + " was returned");
//			foundBook.setLoaned();
//		} else if (found && foundBook.getLoaned()) {
//			messageBox(titleFld.getText() + " is not loaned out");
//		}
//	}

	public boolean checkName(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isWhitespace(s.charAt(i)))
				return false;
		}
		return true;
	}

}
