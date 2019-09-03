import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Class for the right hand panel that has the 
 * list of points and place to make new ones
 */
public class PointExplorer extends JPanel {
	private JTextArea pointArea;
	private JTextField newX,newY;
	private JButton addPoint;
	private DataList dataList;
	
	public PointExplorer(DataList d, ActionListener parent) {
		/*
		 * Keep a reference to the data
		 */
		this.dataList = d;
		
		/* 
		 * Create an internal panel that has 2 rows 
		 */
		JPanel internalPanel = new JPanel(new GridLayout(2,0));
		
		/* 
		 * Create a text area (20 rows, 20 columns)
		 * and add it to the first row of internalPanel
		 */
		pointArea = new JTextArea(20,20);
		internalPanel.add(pointArea);
		
		/* 
		 * Create a panel for the fields and button
		 * Create and add the Textfields (width 5) and the button
		 */
		JPanel fieldPanel = new JPanel(new FlowLayout());
		newX = new JTextField(5);
		fieldPanel.add(newX);
		newY = new JTextField(5);
		fieldPanel.add(newY);
		addPoint = new JButton("Add point");
		fieldPanel.add(addPoint);
		
		/*
		 * Add the Plotter frame as the actionListener
		 * for the button
		 */
		addPoint.addActionListener(parent);
		
		/*
		 * Add the fieldPanel to the bottom of internalPanel
		 */
		internalPanel.add(fieldPanel);
		
		/*
		 * Set the text in the textArea
		 */
		updateArea();
		
		/*
		 * Add internalPanel to this panel
		 */
		this.add(internalPanel);
	}
	/*
	 * Method that updates the text area
	 * It resets the text in the text area to whatever is in the list
	 */
	public void updateArea() {
		pointArea.setText(dataList.toString());
	}
	/*
	 * Method to return a reference to the button
	 * the Plotter class needs this to check if the action
	 * has come from here 
	 */
	public JButton getAddButton() {
		return addPoint;
	}
	/*
	 * Method to grab the values in the 
	 * text fields and turn them into a new point
	 * This is called by the Plotter class when someone clicks
	 * on the add button 
	 */
	public Point getNewPoint() {
		int x = Integer.parseInt(newX.getText());
		int y = Integer.parseInt(newY.getText());
		newX.setText("");
		newY.setText("");
		return new Point(x,y);
	}
}
