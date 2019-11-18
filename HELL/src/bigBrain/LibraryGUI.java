package bigBrain;

import javax.swing.*;
import BreezySwing.*;

public class LibraryGUI extends GBFrame {

	JButton enter = addButton("Enter a new book", 1, 1, 1, 1);
	JButton checkOut = addButton("Check Out a Book", 1, 2, 1, 1);
	JButton returnBook = addButton("return a book", 1, 3, 1, 1);
	JButton outputButton = addButton("Check Availability", 1, 4, 1, 1);
	JButton overdueButton = addButton("Check OverdueBooks", 1, 5, 1, 1);
	JButton searchButton = addButton("Search for a Book", 1, 6, 1, 1);

	public static void main(String[] args) {
		JFrame frm = new LibraryGUI();
		frm.setTitle("Ace Program");
		frm.setSize(700, 500);
		frm.setVisible(true);
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enter) {

		}
		if (buttonObj == checkOut) {

		}
		if (buttonObj == returnBook) {

		}
		if (buttonObj == outputButton) {

		}
		if (buttonObj == overdueButton) {

		}
		if (buttonObj == searchButton) {

		}
	}

}
