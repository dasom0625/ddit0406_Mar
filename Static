package e_oop;

public class Static {

		/*
		 * -Static을 붙이면 프로그램 실행시 메모리에 올라간다.
		 * -객체생성을 하지 않아도 사용 할 수 있다.
		 * -Static이 붙은 멤버의 명칭 : 클래스 변수, 클래스 메서드
		 * -Static이 붙지 않은 멤어의 명칭 : 인스턴스 변수, 인스턴스 메서드
		 */
	
	/*
	 * 객체 == 인스턴스
	 * 객채생성 ==인스턴스화
	 */
	
	//위치가 메소드 밖이라 전역변수 // 전역변수와 지역변수로 나뉨.
	//전역변수 //static이 안붙었으므로 인스턴스 변수
	int val;
	
	//위치가 메소드 밖이라 전역변수 //static이 붙어서  클래스 변수
	static int staticVar;
	
	//모든 객체에서 공유해서 사용할 수 있다.
	
	
	public static void main(String[] args) {
		//위치가 메소드 안이라서 지역변수
		int local = 0;
		
//======================수업1(Static)=================================//
		//1. 
		//2명의 직원 객체 생성
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		//각 직원에게 월급 지급
		e1.salary  = 1000000;
		e2.salary  = 2000000;
		
		System.out.println("e1 월급 : " + e1.salary);
		System.out.println("e2 월급 : " + e2.salary);
		
		
		e1.lunch = 7000;
		System.out.println("e1점심비 : "+ e1.lunch);
		System.out.println("e2점심비 : "+ e2.lunch);
		//결과 값 : 둘다 7000원
		e2.lunch = 8000;
		System.out.println("e1점심비 : "+ e1.lunch);
		System.out.println("e2점심비 : "+ e2.lunch);
		//결과 값 : 둘다 8000원

		Employee.lunch = 10000;//=>이와 같이 클래스 명칭을 사용하여 선언하는것을 권장.
							   //=>Lunch라는것은 객체가 아무리 많아도 변수는 하나라서 값이 하나만 됨.
                 
                 
class Employee{
	
	int salary; //월급
	static int lunch; //점심 식사비용
	
}

