import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class BasicPlot extends JComponent {
	private MouseListener mouseListener;
	private DataList dataList;
	private final int radius = 6;
	public BasicPlot(DataList dataList, MouseListener mouseListener) {
		this.dataList = dataList;
		this.mouseListener = mouseListener;
		/*
		 * Tell Java which class will be responsible for handling mouse clicks
		 * on this component. In this case it will be the Plotter class, a reference
		 * to which is stored in mouseListener
		 */
		this.addMouseListener(this.mouseListener);
	}
	/*
	 * paintComponent method that is called by Java whenever someone calls repaint
	 * on the component, or when it gets moved / resized etc
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		/* 
		 * Make a big white rectangle that covers the whole of this component
		 */
		int width = this.getWidth();
		int height = this.getHeight();
		/*
		 * (0,0) is the top left, (width,height) is the bottom right
		 */
		Rectangle r = new Rectangle(0,0,width,height);
		g2.draw(r);
		g2.setPaint(Color.WHITE);
		g2.fill(r);
		
		
		/*
		 *  Set the color to red
		 */
		g2.setPaint(Color.RED);
		
		/*
		 *  Plot the points
		 */	
		for(int i=0;i<this.dataList.getN();i++) {
			// Get the ith point
			Point p = this.dataList.getPoint(i);
			// Get its x and y values
			int x = p.getX();
			int y = p.getY();
			
			// make the ellipse object
			Ellipse2D.Double e = new Ellipse2D.Double(x-radius, y-radius, radius*2, radius*2);
			
			// draw and fill
			g2.draw(e);
			g2.fill(e);
		}
	}

}
