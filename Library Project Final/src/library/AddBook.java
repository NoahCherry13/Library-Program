package library;

import java.util.ArrayList;
import javax.swing.*;
import BreezySwing.*;

public class AddBook extends GBDialog {

	JLabel titlelbl = addLabel("Title:", 1, 1, 1, 1);
	JTextField titleFld = addTextField("", 1, 2, 1, 1);
	JLabel authorlbl = addLabel("Author", 2, 1, 1, 1);
	JTextField authorFld = addTextField("", 2, 2, 1, 1);
	JButton enterButton = addButton("Enter", 7, 1, 1, 1);
	JButton close = addButton("Close",7,2,1,1);
	ArrayList<Books> books;

	public AddBook(JFrame parent, ArrayList<Books> list) {
		super(parent);
		books = list;
	}

	public void buttonClicked(JButton buttonObj) {
		
		if (buttonObj == enterButton) {
			if (checkName(titleFld.getText())){
				messageBox("Please Enter a title");
				return;
			}
			if (checkName(authorFld.getText())){
				messageBox("Please Enter the Author's Name");
				return;
			}
			String title = titleFld.getText();
			String author = authorFld.getText();
			books.add(new Books (title, author));
			dispose();
		}else if(buttonObj == close) {
			dispose();
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
