
public class Rectangle implements Shape2D{
	
	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		
		if(length < 0 || width < 0) {
			this.length = 0;
			this.width = 0;
		}else {
			this.length = length;
			this.width = width;
		}
	}

	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public double getPerimeter() {
		return (2 * width) + (2 * length);
	}

	public String toString() {
		return "Rectangle of width " + width + " and length " + length;
	}
}
