package library;

import java.util.ArrayList;

import BreezySwing.*;
import javax.swing.*;

public class Search extends GBDialog {
	ArrayList<Books> books;
	String searchInput;
	boolean inList = false;
	Books bookFound;
	JTextField searchField = addTextField("", 2, 1, 2, 1);
	JButton searchButton = addButton("Search", 3, 1, 1, 1);
	JTextArea bookInfoArea = addTextArea("", 4, 1, 2, 2);
	JLabel searchlbl = addLabel ("Search Title: ",1,1,2,1);
	JButton close = addButton ("Close",3,2,1,1);
	Date d = new Date ();
	
	public Search(JFrame parent, ArrayList<Books> b) {
		super(parent);
		books = b;
		this.setVisible(true);
		this.setSize(400,400);
	}
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == searchButton) {
			findBook();
			if (inList) {
				output();
			}else messageBox("There is no book with this name");
		}else if(buttonObj == close) {
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

	public void output() {
		bookInfoArea.setText("Title: "+ bookFound.getTitle());
		bookInfoArea.setText(bookInfoArea.getText()+'\n' +("Author: " + bookFound.getAuthor()));
		bookInfoArea.setText(bookInfoArea.getText()+ '\n' + ("Available: " + bookFound.getLoaned()));
		if (!bookFound.getLoaned()){
			bookInfoArea.setText(bookInfoArea.getText()+'\n' +("Borrower: "+bookFound.getBorrower()));
			bookInfoArea.setText(bookInfoArea.getText()+'\n' +("Date Borrowed: "+ bookFound.getMonth()+'/'+bookFound.getDay()+'/'+bookFound.getYear()));
			if (d.setTimeMili()-bookFound.getTimeInMili()>1209600000) 
				bookInfoArea.setText(bookInfoArea.getText()+'\n' +("Status: Overdue"));
		}
		
	}
}
