package bigBrain;

import BreezySwing.*;

import java.util.ArrayList;

import javax.swing.*;

public class returnBook extends GBDialog {
	JTextField titleFld = addTextField("", 1, 1, 1, 1);
	JButton enterButton = addButton("Return", 2, 1, 1, 1);
	Books foundBook;
	boolean found;
	ArrayList<Books> books;

	public returnBook(JFrame parent, ArrayList<Books> list) {
		super(parent);
		books = list;
		this.setVisible(true);
		this.setSize(400, 400);
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enterButton) {
			if (!checkName(titleFld.getText())) {
				findBook();
			} else {
				messageBox("Name is Blank");
				return;
			}

			Date d = new Date(0, 0, 0);

			foundBook.setDate(d);
			foundBook.setBorrower(null);

			checkOut();
		}

	}

	public void findBook() {
		String title = titleFld.getText();
		for (Books item : books) {
			if (title.equalsIgnoreCase(item.getTitle())) {
				foundBook = item;
				found = true;
			}

		}
	}

	public void checkOut() {
		if (!found) {
			messageBox("There is no book with this title");
		} else if (found && !foundBook.getLoaned()) {
			messageBox(titleFld.getText() + " was returned");
			foundBook.setLoaned();
		} else if (found && foundBook.getLoaned()) {
			messageBox(titleFld.getText() + " is not loaned out");
		}
	}

	public boolean checkName(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isWhitespace(s.charAt(i)))
				return false;
		}
		return true;
	}

}
