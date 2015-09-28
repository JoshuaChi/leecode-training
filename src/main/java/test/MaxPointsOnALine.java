package test;

public class MaxPointsOnALine {

	public int maxPoints(Point[] points) {
		Array[] collection = new Array
		for(int i=0; i<points.length; i++) {
			for(int j=i+1; j<points.length; j++) {
				Point p1 = points[i];
				Point p2 = points[j];
				if ()
			}
		}
		return 0;
	}

	public float getAngle(Point p1, Point p2) {
		float angle = (float) Math.toDegrees(Math.atan2(p1.y - p2.y, p1.x - p2.x));

		if(angle < 0){
			angle += 360;
		}

		return angle;
	}

	public static void main(String[] args) {
		MaxPointsOnALine s = new MaxPointsOnALine();
		Point[] points = {
				new Point(1,2),
				new Point(10,200),
				new Point(1,22),
				new Point(1000,2)
		};
		s.maxPoints(points);

	}

}
