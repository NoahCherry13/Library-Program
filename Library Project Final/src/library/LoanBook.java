package library;

import BreezySwing.*;

import java.util.ArrayList;

import javax.swing.*;

public class LoanBook extends GBDialog {

	JLabel titlelbl = addLabel("Title:", 1, 1, 1, 1);
	JTextField titleFld = addTextField("", 1, 2, 1, 1);
	JLabel borrowerlbl = addLabel("Name of Borrower", 3, 1, 1, 1);
	JTextField borrowerFld = addTextField("", 3, 2, 1, 1);
	JLabel monthlbl = addLabel("Day Borrowed", 4, 1, 1, 1);
	IntegerField dayFld = addIntegerField(0, 4, 2, 1, 1);
	JLabel daylbl = addLabel("Month Borrowed", 5, 1, 1, 1);
	IntegerField monthFld = addIntegerField(0, 5, 2, 1, 1);
	JLabel yearlbl = addLabel("Year Borrowed", 6, 1, 1, 1);
	IntegerField yearFld = addIntegerField(0, 6, 2, 1, 1);
	JButton enterButton = addButton("Enter", 7, 1, 1, 1);
	JButton close = addButton("Close",7,2,1,1);
	ArrayList<Books> books;
	Books foundBook;
	boolean found = false;

	public LoanBook(JFrame parent, ArrayList<Books> list) {
		super(parent);
		books = list;
		this.setVisible(true);
		this.setSize(400,400);
	}

	public boolean checkName(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isWhitespace(s.charAt(i)))
				return false;
		}
		return true;
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enterButton) {
			
			if (books.size()==0){
				messageBox("There are no books in the library");
				return;
			}
			
			if (!checkName(borrowerFld.getText())) {
				findBook();
			} else {
				messageBox("Name is Blank");
				return;
			}
			if(monthFld.getNumber()>12 || monthFld.getNumber()<1) {
				messageBox("Please enter a valid date");
				return;
			}
			Date d = new Date(monthFld.getNumber(), dayFld.getNumber(), yearFld.getNumber());
			try {
				d.checkValid();
			} catch (Exception e) {
				messageBox(e.getMessage());
				return;
			}

			Date current = new Date();

			if (current.setTimeMili() - d.setTimeMili() < 0) {
				messageBox("Date of loan must be before or on current day");
				return;
			}
			foundBook.setDate(d);
			foundBook.setBorrower(borrowerFld.getText());

			
			checkOut();
		}else if(buttonObj == close) {
			dispose();
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
		if (!found)
			messageBox("There is no book with this title");
		else if (foundBook.getLoaned() && found) {
			messageBox(titleFld.getText() + " was loaned out by " + borrowerFld.getText() + " on " + monthFld.getNumber()
			+ "/" + dayFld.getNumber() + "/" + yearFld.getNumber());
			foundBook.setLoaned();
		} else if (!foundBook.getLoaned())
			messageBox("This book is already loaned out");

	}

}
