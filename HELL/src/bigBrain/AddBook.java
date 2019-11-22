package bigBrain;

import java.util.ArrayList;

import javax.swing.*;

import BreezySwing.GBDialog;

public class AddBook extends GBDialog{
	
	JLabel titlelbl = addLabel("Title:",1,1,1,1);
	JTextField titleFld = addTextField("",1,2,1,1);
	JLabel authorlbl = addLabel ("Author",2,1,1,1);
	JTextField authorFld = addTextField("",2,2,1,1);
	JLabel borrowerlbl = addLabel ("Name of Borrower",3,1,1,1);
	JTextField borowerFld = addTextField("",3,2,1,1);
	JLabel daylbl = addLabel ("Day Borrowed",4,1,1,1);
	JTextField dayFld = addTextField("",4,2,1,1);
	JLabel monthlbl = addLabel ("Month Borrowed",5,1,1,1);
	JTextField monthFld = addTextField("",5,2,1,1);
	JLabel yearlbl = addLabel ("Year Borrowed",6,1,1,1);
	JTextField yearFld = addTextField("",6,2,1,1);
	JButton enterButton = addButton("Search",7,1,1,1); 
	
	ArrayList<Books> books;
	
	public AddBook(JFrame parent, ArrayList <Books> list) {	
		super(parent);
		books = list;
	}
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enterButton) {
			
		}
	}

}
