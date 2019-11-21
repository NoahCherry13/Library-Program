package bigBrain;

import java.awt.Dialog.ModalityType;
import java.util.ArrayList;
import javax.swing.*;
import BreezySwing.*;

public class LibraryGUI extends GBFrame {

	JButton addBookButton = addButton("Enter a new book", 1, 1, 1, 1);
	JButton checkOut = addButton("Check Out a Book", 1, 2, 1, 1);
	JButton returnBook = addButton("return a book", 2, 1, 1, 1);
	JButton outputButton = addButton("Check Availability", 2, 2, 1, 1);
	JButton overdueButton = addButton("Check OverdueBooks", 3, 1, 1, 1);
	JButton searchButton = addButton("Search for a Book", 3, 2, 1, 1);
	JButton exitButton = addButton("Exit", 4, 3, 1, 1);

	public static void main(String[] args) {
		JFrame frm = new LibraryGUI();
		frm.setTitle("Ace Program");
		frm.setSize(700, 500);
		frm.setVisible(true);
	}
	ArrayList<Books> books = new ArrayList<Books>(); 
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == addBookButton) {
			AddBook newBook = new AddBook(this);
			newBook.setModalityType(ModalityType.APPLICATION_MODAL);
			newBook.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			newBook.setVisible(true);
		} else if (buttonObj == checkOut) {

		} else if (buttonObj == returnBook) {

		} else if (buttonObj == outputButton) {

		} else if (buttonObj == overdueButton) {

		} else if (buttonObj == searchButton) {

		}
	}

}
