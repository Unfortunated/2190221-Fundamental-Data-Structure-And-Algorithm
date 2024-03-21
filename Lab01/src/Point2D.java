
public class Point2D {
	private double x;
	private double y;
	public Point2D(double x,double y) {
		// Store x,y in this.x,this.y

		// Put your code here 
		setX(x);
		setY(y);
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double distance(Point2D other) {
		// Return a double that is the distance between this and other
		
		
		// Put your code here
		double distance = Math.sqrt(Math.pow(getX()-other.getX(),2)+Math.pow(getY()-other.getY(),2));
		return distance;
	}
}
