package g_oop2;
	//부모클래스
public class SampleParent {

	
/*
 * 상속 : class 자식클래스명 extends 부모클래스명 {}
 * -기존의 클래스를 물려받아 새로운 클래스를 만드는 것이다.
 * -부모 클래스의 생성자와 초기화 블럭을 제외한 모든 멤버를 물려받는다.
 * -하나의 클래스만 상속받을 수 있다.
 * -상속받지 않는 모든 클래스는 object클래스를 상속받는다.
 * => object클래스 : 모든 클래스의 부모클래스라고 한다.
 * -자식 클래스는 부모 클래스의 멤버 외의 새로운 멤버를 가질 수 있으므로 
 *  자식 클래스는 부모 클래스보다 크거나 같다.
 * -두개 이상의 클래스를 만드는데 공통된 멤버가 있는 겅우 부모클래스로 만든다.
 * -중복된 내용을 배제하기 위해 부모 클래스를 만들어 상속해준다.
 */
	
	String var;
	
	{
		var = "초기화 블럭은 물려주지 않는다.(상속x)";
	}
	
	
	SampleParent(){
		var = "생성자도 물려주지 않는다.(상속x)";
	}
	
	int method(int a, int b) {
		return a + b;
	}
}
=======================================================================================
package g_oop2;

//SampleParent로부터 상속받을 자식 클래스 (클래스 이름 바로 뒤에 아래와 같이 extend와 상속받을 클래스이름적기)
public class SampleChild extends SampleParent {

	void childMethod() {
		System.out.println(var);//상속받은 변수
		System.out.println(method(7,13));//상속받은 메서드
	}
	
	//상속이 나오면서 함께 나온 단어들..
	//1.오버라이딩 : 부모클래스로부터 물려받은 메서드의 내용을 자식 클래스에 맞게 변경하여 다시 정의 하는것
	//2.super, super() : 부모자식간의 메서드나 변수의 이름이 똑같을 때 그를 구분하기 위해 사용
	//	=> super는 부모에게 붙음
	//	=>자식클래스에서 부모클래스를 호출할때 사용하는게 super()
	//3.다형성 : 부모타입의 변수로 자식타입의 객체를 사용하는것
	
	
	//1. 오버라이딩=>부모클래스에서 선언하는 것을 그대로 복붙해서 return값의 내용만 바꿔주기
	//	  조건	=>선언하는 부분(리턴타입, 메서드명, 파라미터)은 절대 바뀌면 안된다. (int method(int a, int b)부분.
	@Override //어노테이션 : 변수, 메소드, 클래스 등등에 붙여서 이 아이가 어떤아인지 표시해주는것.
	int method(int a, int b) {		
		return a * b;
	}
	
	
	//2.super, super()
	//1)super
	int var;
	
	void test(double var) {
		System.out.println(var); //지역변수
		System.out.println(this.var); //인스턴스 변수
		System.out.println(super.var); //부모클래스의 인스턴스 변수
		
		method(10, 20); //자식클래스의 메서드
		super.method(10, 20); //부모클래스의 메서드 호출
	}

	//2)super()
	SampleChild(){
//		super(); //보무클래스의 생성자 호출
//		SampleChild sc = new SampleChild(); //객체생성
		//자식클래스의 생성자에서는 반드시 부모클래스의 생성자를 호출해야 한다.
		//만약 깜빡하고 넣지 않으면 컴파일러가 알아서 자동으로 넣어주긴 함.
		//단,부모클래스의 생성자에 파라미터가 있으면 자동으로 컴파일러가 넣진 못함. 그래서 반드시 직접 호출해야함.
		
	}
	
	
	//3)다형성 : 객체를 사용할 때 부모타입으로 사용하는것.
	public static  void main(String[]args) {
		SampleChild sc = new SampleChild(); //보통, 객체 생성시 객체와 변수 타입을 일치시킴.
		SampleParent sp = new SampleChild(); // 부모클래스에 저장할수있음.
		//상속을 받으면 서로 형병환을 받기 때문
		//(SampleParent sp = (SampleParent)new SampleChild();)인데 SampleParent가 숨어있는것.
		//sp = newSampleChild2();
		//sp = newSampleChild3();
		//sp = newSampleChild4(); =>즉, 다양한 형태의 객체가 들어갈 수 있다.

		
		//자식이 부모한테 영향을 받음.
		//변수(부모)의 타입에 있는 멤버만 사용 할 수 있다.
		System.out.println(sp.var);
		sp.method(10, 20);
		
//		sp.childMethod();
//		sp.test();
		//sp라는 변수에는 SampleChild가 들어있음. 그리고 SampleChild에는 method와 childMethod라는 변수가 있지만 
		//사용 할 수 없음. 왜?? SmapleParent가 변수라서.
	}
	
}
