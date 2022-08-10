package g_oop2;

//추상 클래스 : 추상 메서드를 가지고 있는 클래스(아래와 같이 public과 class사이에 abstract가 붙음)
//추상 메서드 : 선언부만 있고 구현부가 없는 메서드 (즉,내용이 없는 메서드) 
//			=>왜 만드냐 ? 상속해주기위해서..
//			=>직접 사용 할 수 없기때문에 호출이 안되고, 객체생성이 불가능.즉, 부모클래스 역할만 함.
public abstract class SampleAbstractParent {

	//추상메서드 만들기=>abstract를 붙여서 만듬 
	abstract void abstractMethod();
	
	
}


//상속받기
//만들면 처음에 컴파일 애러가 발생하는데, 추상메서드를 상속받으면 상속받은애도 추상메서드를 갖게 됨. 
//그치만, 이 child도 추상메서드를 받으려고 한건 아니라서, 내용을 넣어줘버림 (overriding(ctrl+1)하기)
//굳이 부모한테서 내용을 넣지 않고 자식에서 이렇게 하는 이유...? 자식마다 매서드 내용이 조금씩 다르기 때문
class SampleAbstractChild extends SampleAbstractParent{

	//추상메서드를 상속받으면 반드시 내용을 만들어야 한다.
	@Override
	void abstractMethod() {
		
	}
	
}


