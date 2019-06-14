
public class Circle implements Shape2D{
	
	private double radius;
	
	public Circle(double radius) {
		if(radius > 0) this.radius = radius;
		else this.radius = 0;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public String toString() {
		return "Circle of radius " + radius;
	}
}
