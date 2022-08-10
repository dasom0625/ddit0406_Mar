package g_oop2;

//인터페이스 : 상수와 추상메서드만 가질 수 있는 데이터구조.
//상수 : 변수인데 final붙어서 값을 변경할수없는 것.
public interface SampleInterface {

	//인터페이스의 모든 멤버변수는 public static final 제어자를 사용해야 한다.
	public static final int NUM1 = 1;
	
	//모든 멤버변수의 제어자가 같기 때문에 생략이 가능하다.
	int NUM2 = 2 ;
	
	//인터페이스의 모든 메서드는 public abstract 제어자를 사용해야한다.
	public abstract void method1();
	
	//모든 메서드이 제어자가 같기 때문에 생략이 가능하다.
	void method2();
	
}

//인터페이스 상속받아서 사용해보기 //부모로써 역할만 하는것 잊지말기
//인터페이스는 여러개를 상속받을 수 있다. //부모가 여러개일수 있다는 말.
//다만, 똑같은 메서드가 부모클래스 각각에 있으면 상속받을때 하나만 상속받아옴.
class SampleImplement implements SampleInterface, SampleInterface2{

	@Override
	public void method1() {
		
	}

	@Override
	public void method2() {
		
	}

	@Override
	public void method3() {
		
	}
	
}

interface SampleInterface2{
	void method1();
	void method3();
}
========================================================

package g_oop2;

public abstract class Animal {

	abstract void sound();	//메소드는 사운드인데 동물들마다 소리가 다르니까 abstract

	
	
}
class Dog extends Animal{

	@Override
	void sound() {
		System.out.println("멍멍!!");
	}
	
}

class Cat extends Animal{

	@Override
	void sound() {
		System.out.println("야옹~");
	}
	
}

class Birld extends Animal{

	@Override
	void sound() {
		System.out.println("짹짹짹짹");
	}
}
