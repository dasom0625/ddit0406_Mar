package g_oop2;

public class AccessModifier {

	/*
	 * 접근제어자 : 메서드,변수 ,클래스등에 붙여서 접근을 할건지, 할거면 어디까지 할건지 결정
	 */
	
	//접근제어자 종류 4가지 
	public String publicVar = "public : 접근제한이 없음";
	protected String protectedVar = "protected : 같은 패키지 + 상속받은 클래스에서 접근 가능";
	//=>현재 있는 g_oop2패키지 안에서 접근이 가능, 패키지 안에서도 상속 클래스에서 접근 가능
	String defaultVar = "default : 같은 패키지에서만 접근가능";
	//=>protected를 생략한 defaultVar
	private String privateVar = "private : 클래스 내에서만 접근 가능";
	
	

	public void publicMethod() {
		System.out.println(publicVar);
	}

	protected void protectedMethod() {
		System.out.println(protectedVar);

	}

	void defaultMethod() {
		System.out.println(defaultVar);
	}

	private void privateMethod() {
		System.out.println(privateVar);
	}
	
	//같은 클래스 내에서 사용
	public static void main(String[] args) {
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);	//public은 접근제한자가 없어서 아무데서나 사용가능
		am.publicMethod();
	
		System.out.println(am.protectedVar);
		am.protectedMethod();
	
		System.out.println(am.defaultVar);
		am.defaultMethod();
		
		System.out.println(am.privateVar);
		am.privateMethod();
	
	/*
	 * 접근제어자를 사용하는 이유
	 * -데이터를 보호하기 위해
	 * -사용하는데 불필요한 멤버를 숨기기 위해
	 */
   
   ========================================================================================
   package g_oop2;

public class AccessTest {

	public static void main(String[] args) {
		
		//2. 같은 패키지에서 접근제한자 이용할때
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);	//public은 접근제한자가 없어서 아무데서나 사용가능
		am.publicMethod();
	
		System.out.println(am.protectedVar);
		am.protectedMethod();
	
		System.out.println(am.defaultVar);
		am.defaultMethod();
		
		System.out.println(am.privateVar);
		am.privateMethod();
		//=>프라이빗은 같은 클래스 내에서만 사용이 가능해서 컴파일 애러가 남.
		
	}
}
============================================================================================
package g_oop2.test;

import g_oop2.AccessModifier;

public class AccessTest extends AccessModifier{
	

	public static void main(String[] args) {
		
		//3. 다른 패키지에서 접근제한자 이용할때
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);	
		am.publicMethod();
		//=>상속을 받아도 안되는 이유는 위의 AccessModifier am = new AccessModifier()부분이 
		//	상속을 받은것에서 가져온것이 아니기 때문.
		//	그래서 하단에다가  AccessTest클래스에서 가져온것을 새로 객체생성하여야 함.
		System.out.println(am.protectedVar);
		am.protectedMethod();
		//=>같은 패키지나 상속받았을때만 사용 가능
		System.out.println(am.defaultVar);
		am.defaultMethod();
		//=>같은 패키지에서만 사용 가능
		System.out.println(am.privateVar);
		am.privateMethod();
		//=>같은 패키지의 같은 클래스에서만 사용 가능.
	
		
		//
		AccessTest at = new AccessTest();
		
		System.out.println(at.protectedVar);
		at.protectedMethod();
	}
}

============================================================================================ 
