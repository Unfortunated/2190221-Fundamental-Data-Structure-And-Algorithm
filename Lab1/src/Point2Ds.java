import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Point2Ds {
	private Point2D[] points;
	
	public Point2D getPoint(int i) {
		// Return the point object at index i 
		
		// Put your code here 
		return this.points[i];
	}
	
	public void readFromFile(String filename) throws FileNotFoundException {
		// Read all points stored in filename
		// Store them in the array points 
		
		// Put your code here 
		String fileDirectory = "C:\\Users\\Thany\\eclipse-workspace\\Lab1\\src\\" + filename;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileDirectory))){
			String line;
			while ((line = reader.readLine()) != null) {
				if (this.points == null) {
					this.points = new Point2D[1];
					this.points[0] = new Point2D(Double.parseDouble(line.split(" ")[0]),
											Double.parseDouble(line.split(" ")[1]));
				} else {
					int temp = this.points.length + 1;
					Point2D[] newpoints = new Point2D[temp];
					int i = 0;
					while ( i < this.points.length) {
						newpoints[i] = this.points[i];
						i++;
					}
					newpoints[i] = new Point2D(Double.parseDouble(line.split(" ")[0]),
												Double.parseDouble(line.split(" ")[1]));
					this.points = newpoints;
				}	
			}
		} catch (IOException e) {
            e.printStackTrace();
		}
	}
	
	public Point2D getClosestPointToOrigin() {
		// Return the point that is closest to the origin 
		
		// Put your code here 
		double[] distance = new double[points.length];
		Point2D origin = new Point2D(0,0);
		Point2D closest = points[0];
		distance[0] = points[0].distance(origin);
		for (int i = 1; i < points.length; i++) {
			distance[i] = points[i].distance(origin);
			System.out.println(distance[i]);
			if (distance[0] > distance[i]){
				distance[0] = distance[i];
				closest = points[i];
			}
		}
		return closest;
	}

	public Point2D getClosestPoint(double x,double y) {
		// Return the point that is closest to x,y 

		// Put your code here 
		double[] distance = new double[points.length];
		Point2D other = new Point2D(x,y);
		Point2D closest = points[0];
		distance[0] = points[0].distance(other);
		for (int i = 1; i < points.length; i++) {
			distance[i] = points[i].distance(other);
			System.out.println(distance[i]);
			if (distance[0] > distance[i]){
				distance[0] = distance[i];
				closest = points[i];
			}
		}
		return closest;
	}
}
