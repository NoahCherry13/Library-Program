package bigBrain;

import java.awt.Dialog.ModalityType;

import javax.swing.*;
import BreezySwing.*;

public class LibraryGUI extends GBFrame {

	JButton enter = addButton("Enter a new book", 1, 1, 1, 1);
	JButton checkOut = addButton("Check Out a Book", 1, 2, 1, 1);
	JButton returnBook = addButton("return a book", 2, 1, 1, 1);
	JButton outputButton = addButton("Check Availability", 2, 2, 1, 1);
	JButton overdueButton = addButton("Check OverdueBooks", 3, 1, 1, 1);
	JButton searchButton = addButton("Search for a Book", 3, 2, 1, 1);
	JButton exitButton = addButton("Exit",4,3,1,1);

	public static void main(String[] args) {
		JFrame frm = new LibraryGUI();
		frm.setTitle("Ace Program");
		frm.setSize(700, 500);
		frm.setVisible(true);
	}

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enter) {
			Search dialog = new Search(this);
			dialog.setModalityType(ModalityType.APPLICATION_MODAL);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
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
