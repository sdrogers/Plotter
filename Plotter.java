import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Main class. Acts as the controller and the main view.
 * Extends JFrame -- it is a frame
 * Implements ActionListener and MouseListener..i.e. it handles all button and mouse clicks
 */

public class Plotter extends JFrame implements ActionListener, MouseListener {
	
	/*
	 * Attributes -- this class has access to the data,
	 * the point explorer panel and the plot component
	 */
	private PointExplorer pointExplorer;
	private DataList plotData;
	private BasicPlot scatter;
	
	
	public Plotter() {
		// Standard JFrame things...
		this.setSize(1000,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Create the main panel. This will have two columns
		 * The left will be used for the plot, the right
		 * for the pointExplorer
		 */
		JPanel mainPanel = new JPanel(new GridLayout(0,2));
		
		/*
		 * Create the DataList and add some initial points.
		 */
		plotData = new DataList();
		plotData.addPoint(10, 10);
		plotData.addPoint(50, 5);
		plotData.addPoint(200, 110);
		
		/*
		 * Create the scatter plot component and add it to
		 * mainPanel
		 */
		scatter = new BasicPlot(plotData,this);
		mainPanel.add(scatter);		
		
		/*
		 * Create the pointExplorer and add it to mainPanel
		 */
		pointExplorer = new PointExplorer(plotData,this);
		mainPanel.add(pointExplorer);
		
		/*
		 * Add mainPanel to the frame
		 */
		this.add(mainPanel);
		
		/*
		 * Make the frame visible
		 */
		this.setVisible(true);
	}
	
	
	/*
	 * Button click controller for the pointExplorer object
	 * We will reach this when a button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 *  Check that the action came from the expected button
		 *  we don't strictly need to do this, but its good practice
		 *  as if you add more buttons you'll need it
		 */
		
		if(e.getSource() == pointExplorer.getAddButton()) {
			// Get the data that has been entered as a Point
			Point p = pointExplorer.getNewPoint();
			// Add the point to the dataset
			plotData.addPoint(p);
			// Redraw the plot
			scatter.repaint();
			// Update the pointExplorer
			pointExplorer.updateArea();
		}
		
	}
	
	/*
	 * Mouse click controller for the scatter component
	 * Only the plot component has this class as a Mouse Listener
	 * So we will only enter this method if the mouse is clicked
	 * on the scatter component
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Clicked inside the scatter object
		// Step1: get the position of the click...
		int clickX = e.getX();
		int clickY = e.getY();
		// Make a new point
		Point p = new Point(clickX,clickY);
		// Add it to the data
		plotData.addPoint(p);
		// Redraw the plot
		scatter.repaint();
		// Update the pointExplorer
		pointExplorer.updateArea();
		
		
	}
	/* 
	 * Following methods are essential to have
	 * if a class implements mouseListener
	 * They are left blank
	 */
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * Main method -- creates the Plotter object
	 */
	public static void main(String[] args) {
		new Plotter();
	}


}
