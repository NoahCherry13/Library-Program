package library;

import BreezySwing.*;

import java.util.ArrayList;

import javax.swing.*;

public class CheckOverdue extends GBDialog {
	JLabel overduelbl = addLabel("Overdue:",1,1,1,1);
	JLabel notOverduelbl = addLabel("Overdue:",1,2,1,1);
	JButton closeButton = addButton("Close",3,1,1,1);
	JTextArea overdueArea = addTextArea("", 2, 1, 1, 1);
	JTextArea notOverdueArea = addTextArea("", 2, 2, 1, 1);
	ArrayList<Books> books;
	Date d = new Date();

	public CheckOverdue(JFrame parent, ArrayList<Books> list) {
		super(parent);
		books = list;
		setTextArea();
		this.setVisible(true);
		this.setSize(400, 400);
		overdueArea.setEditable(false);
		notOverdueArea.setEditable(false);
	}

	public void setTextArea() {
		for (Books item : books) {
			if (!item.getLoaned()) {
				if (d.setTimeMili() - item.getTimeInMili() > 1209600000) {
					overdueArea.setText(overdueArea.getText() + item.getTitle() + '\n');
				} else
					notOverdueArea.setText(notOverdueArea.getText() + item.getTitle() + '\n');
			}else notOverdueArea.setText(notOverdueArea.getText() + item.getTitle() + '\n');
		}
	}
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == closeButton) {
			dispose();
		}
	}
}
