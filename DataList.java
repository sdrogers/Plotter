import java.util.ArrayList;
import java.util.Collections;
/*
 * Class to hold a list of points
 * Keeps the points in an ArrayList
 * Whenever a point is added, resorts
 * to ensure they are in x-order
 */
public class DataList {
	private ArrayList<Point> points;
	public DataList() {
		points = new ArrayList<Point>();
	}
	/*
	 * Two overloaded addPoint methods
	 * one takes the x y co-ordinate, makes
	 * a Point and then calls the other...
	 * ...which takes a Point as input and 
	 * adds it to the list
	 */
	public void addPoint(int x, int y) {
		Point p = new Point(x,y);
		addPoint(p);	
	}
	/*
	 * Add a point and then sort
	 */
	public void addPoint(Point p) {
		points.add(p);
		Collections.sort(points);
	}
	/*
	 * Get the ith point
	 */
	public Point getPoint(int i) {
		return points.get(i);
	}
	/*
	 * Get the total number of points
	 */
	public int getN() {
		return points.size();
	}
	/*
	 * Turn the whole thing into a string
	 */
	public String toString() {
		String s = "";
		for(Point p: points) {
			s += p.toString() + "\n";
		}
		return s;
	}

}
