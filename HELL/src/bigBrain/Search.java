package bigBrain;

import java.util.ArrayList;

import BreezySwing.*;
import javax.swing.*;

public class Search extends GBDialog {
	ArrayList<Books> books;
	String searchInput;
	boolean inList = false;
	Books bookFound;
	
	JTextField searchField = addTextField("",1,1,1,1);
	JButton searchButton = addButton ("",1,2,1,1);
	JTextArea bookInfoArea = addTextArea ("",2,1,1,1);

	public Search(JFrame parent, ArrayList<Books> b) {
		super(parent);
		books = b;
	}

	public boolean findBook() {

		for (Books item : books) {
			if (searchInput.equalsIgnoreCase(item.getTitle())) {
				inList = true;
				bookFound = item;
			}
		}
		return inList;
	}

	public Books getBook() {
		return bookFound;
	}
}
