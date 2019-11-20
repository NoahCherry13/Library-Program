package bigBrain;

import javax.swing.*;

import BreezySwing.GBDialog;

public class Search extends GBDialog{

	public Search(JFrame parent) {	
		super(parent);
		JTextField searchFld = addTextField("",1,1,1,1);
		JButton enterButton = addButton("Search",1,2,1,1); 
		
	}

}
