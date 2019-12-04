package library;

import BreezySwing.*;
import javax.swing.*;
import java.util.ArrayList;

public class OutputBooks extends GBDialog {
	ArrayList<Books> books;
	JTextArea checkedOutArea = addTextArea("", 2, 1, 1, 1);
	JTextArea availableBooks = addTextArea("", 2, 2, 1, 1);
	JButton outputButton = addButton("Output", 3, 1, 1, 1);
	JButton close = addButton("Close",3,2,1,1);
	JLabel notAvailable = addLabel ("Not Available:",1,1,1,1);
	JLabel Available = addLabel ("Available:",1,2,1,1);
	public OutputBooks(JFrame parent, ArrayList<Books> list) {
		super(parent);
		books = list;
		this.setVisible(true);
		this.setSize(400, 400);
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == outputButton) {
			for (Books item : books) {
				if (!item.getLoaned()) {
					System.out.println("CheckedOut");
					checkedOutArea.setText(checkedOutArea.getText() + "Book: " + item.getTitle()
							+ "\n Name of Borrower: " + item.getBorrower() + "\n Date Checked Out: " + item.getMonth()
							+ '/' + item.getDay() + '/' + item.getYear());
				} else {
					availableBooks.setText(availableBooks.getText() + "Book: " + item.getTitle()
							+ "\n Name of Borrower: " + item.getBorrower() + "\n Date Checked Out: Null" );
				}
			}
		}else if(buttonObj == close) {
			dispose();
		}
	}
}
