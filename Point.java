/*
 * Class to hold the position of a single point
 * 
 */
public class Point implements Comparable<Point>{
	private int x;
	private int y;
	public Point(int x,int y)  {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String toString() {
		return String.format("%d\t%d",x,y);
	}
	/*
	 * Implements the compareTo method so that
	 * we can use Java's own sorting methods 
	 * to sort our points.
	 * We choose to sort them by their x value
	 */
	public int compareTo(Point other) {
		if (this.x >= other.getX()) {
			return 1;
		} else {
			return -1;
		}
	}
}
