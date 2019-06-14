
public class Driver {

	public static void main(String[] args) {
		
		Circle circle1 = new Circle(5);
		System.out.println(circle1);
		System.out.println("Circle 1's Area is: " + circle1.getArea());
		System.out.println("Circle 1's Perimeter is: " + circle1.getPerimeter());
		System.out.println();
		
		Circle circle2 = new Circle(8.9);
		System.out.println(circle2);
		System.out.println("Circle 2's Area is: " + circle2.getArea());
		System.out.println("Circle 2's Perimeter is: " + circle2.getPerimeter());
		System.out.println();
		
		Circle circle3 = new Circle(-100.5);
		System.out.println(circle3);
		System.out.println("Circle 3's Area is: " + circle3.getArea());
		System.out.println("Circle 3's Perimeter is: " + circle3.getPerimeter());
		System.out.println();
		
		Rectangle rectangle1 = new Rectangle(4.5, 8);
		System.out.println(rectangle1);
		System.out.println("Rectangel 1's Area is: " + rectangle1.getArea());
		System.out.println("Rectangle 1's Perimeter is: " + rectangle1.getPerimeter());
		System.out.println();
		
		Rectangle rectangle2 = new Rectangle(5.4, 7.4);
		System.out.println(rectangle2);
		System.out.println("Rectangle 2's Area is: " + rectangle2.getArea());
		System.out.println("Rectangle 2's Perimeter is: " + rectangle2.getPerimeter());
		System.out.println();
		
		Rectangle rectangle3 = new Rectangle(-4.8, 7.4);
		System.out.println(rectangle3);
		System.out.println("Rectangle 3's Area is: " + rectangle3.getArea());
		System.out.println("Rectangle 3's Perimeter is: " + rectangle3.getPerimeter());	
	}

}
