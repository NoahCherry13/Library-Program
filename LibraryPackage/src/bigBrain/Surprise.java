package bigBrain;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Surprise extends GBDialog{
	JPanel contentPane;
	JLabel imageLabel = new JLabel();
	JLabel headerLabel = new JLabel();

	public Surprise(JFrame parent) {
	        try {
	            contentPane = (JPanel) getContentPane();
	            contentPane.setLayout(new BorderLayout());
	            // add the header label
	            headerLabel.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 16));
	            headerLabel.setText("   Your job crashed during the save process!");
	            contentPane.add(headerLabel, java.awt.BorderLayout.NORTH);
	            // add the image label
	            ImageIcon ii = new ImageIcon(this.getClass().getResource(
	                    "snoopy_dancing.gif"));
	            imageLabel.setIcon(ii);
	            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
	            // show it
	            this.setLocationRelativeTo(null);
	            this.setVisible(true);
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
}
