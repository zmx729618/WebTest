package zmx.hashcode.test;

import java.util.HashSet;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static void main(String[] args) {
		HashSet<Point> hs2 = new HashSet<Point>();
		Point p21 = new Point(3, 3);
		Point p22 = new Point(3, 5);
		hs2.add(p21);
		hs2.add(p22);
		p22.setY(7);
		hs2.remove(p22);
		System.out.println(hs2.size());
	}

}
