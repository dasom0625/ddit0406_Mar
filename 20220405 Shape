package z_codingTest.level01_question;
// 클래스와 메소드 이름이 같은면 생성자, 다르면 메소드.
//ctrl+space+enter누르면 public 생성자 만들어짐


public class Shape {
	// 넓이 - 어떤 도형인지 모르니까...
	public double area() {
		return 0.0;
	}

	// 둘레의 길이 - 어떤 도형인지 모르니까...
	public double perimeter() {
		return 0.0;
	}
}



////추상메서드로 만드려면...
//public abstract class Shape {
//	// 넓이 - 어떤 도형인지 모르니까...
//	public abstract double area();
//
//	// 둘레의 길이 - 어떤 도형인지 모르니까...
//	public abstract double perimeter();
//}
//
////=>다만, 추상메서드가 있으면 반드시 클래스도 추상클래스가 되어야하고, 
////	반대로, 추상클래스 안에 반드시 추상메서드가 있을 필요는 없다.
////	그리고, 추상메스드가 존재하면, 그 메소드를 부여받은 자식 클래스들은 반드시 override가 있어야 한다.

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package z_codingTest.level01_question;

//shape의 클래스를 상속받음
public class Rectangle extends Shape {

	private double width;
	private double height;

	// alt*shift*s -> using field
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double area() {
		return width * height;
	}

	@Override
	public double perimeter() {
		return (width + height) * 2;
	}

	@Override
	public String toString() {
		return String.format("사각형,%f,%f", perimeter(), area());
	}

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package z_codingTest.level01_question;

public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return radius * radius * Math.PI;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2.0 * radius * Math.PI;
	}

	@Override
	public String toString() {
		return String.format("원, %f , %f ", area(), perimeter());
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
package z_codingTest.level01_question;

public class Triangle extends Shape {
	private double side;

	public Triangle(double side) {
		this.side = side;
	}

	@Override
//4분의 루트3(sqrt(3)) * side의 제곱
	public double area() {
		return Math.sqrt(3) / 4.0 * side * side;
	}

	@Override
	public double perimeter() {
		return side * 3;
	}

	@Override
	public String toString() {
		return String.format("삼각형, %f,%f", perimeter(), area());
	}

}

////////////////////////////////////////////////////////////////////////////////////////////////////////////
package z_codingTest.level01_question;

public class ShapeTest {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle(1.0);
		// Shape shape1 = new Circle(1.0);
		shapes[1] = new Triangle(2.0);
		// Shape shape2 = new Triangle(2.0);
		shapes[2] = new Rectangle(2.0, 3.0);
		// Shape shape3 = new Rectangle(1.0);
		for (Shape s : shapes) {
			System.out.println(s);
		}
	}

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
출력 값 : 
원, 3.141593 , 6.283185 
삼각형, 6.000000,1.732051
사각형,10.000000,6.000000
