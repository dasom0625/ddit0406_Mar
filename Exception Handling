package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling {

	public static void main(String[] args) {
		/*
		 * 에러
		 * -컴파일 에러 : 컴파일 시에 발생되는 에러(빨간줄) => 실행조차안됨.
		 * -논리적 에러 : 실행은 되지만, 의도와는 다르게 동작하는 (버그)
		 * -런타임 에러 : 실행 도중에 발생되는 에러 (콘솔창 빨간글씨)
		 * 
		 * 런타임 에러
		 * -런타임 에러 발생시 발생한 위치에서 프로그램이 바정상적으로 종료된다.
		 * -에러 : 프로그램 코드에 의해 수습될 수 없는 심각한 오류
		 * -예외 : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
		 * 
		 * 예외
		 * -모든 예외는 Exception  클래스의 자식 클래스이다.=>최상위(부모) 클래스가 Exception클래스
		 * -Runtime Exception클래스와 Runtime Exception클래스의 자식들은 예외처리가 강제되지 않는다.
		 * -[RuntimeException클래스와 그 자식들을 제외한] Exception클래스의 자식들은 예외처리가 강제된다.
		 * 
		 * 예외처리(try-catch) : try{실행시킬 내용} catch(Exception e){catch를 통해 예외처리 할 내용}
		 * -try의 타입과 catch의 타입이 일치해야한다.
		 * -예외처리를 통해 프로그램이 비정상적으로 종료되는것을 방지 할 수 있다.
		 * -try블럭안의 내용을 실행 중 예외가 발생하면 catch로 넘어간다.
		 * -catch의 파라미터로 처리할 예외를 지정해줄수있다.
		 * -발생한 예외와 일치하는 catch블럭안의 내용이 수행된 후 try-catch를 빠져나간다.
		 * -발생한 예외가 일치하는 catch가 없을 경우 예외는 처리되지 않는다.
		 */

		//예외발생시키기
//		int result = 10/0;	
//		System.out.println(result);	//출력 값 : 정수는 0으로 나눌 수 없어서 콘솔창에 에러메세지가뜸.
		
		
		try {int result = 10/0;	
		System.out.println(result);
		}catch (ArithmeticException | IndexOutOfBoundsException e) {	//catch의 파라미터에는 발생할 가능성이 있는 예외를 넣어야 함:콘솔에 있던거 넣어주고 e붙이기)
			e.printStackTrace();
		}catch(NullPointerException e) {
		}catch(Exception e) {
			//모든 예외처리를 한번에 하고 싶을때는 부모클래스인 Exception e만  파라미터에 넣으면 모든 예외처리가 된다.=>다형
		}
		
		
		
		//예외 메세지 여러개 뜨게 만들어보기.
		test1();
	}

	private static void test1() {
		test2();
	}

	private static void test2() {
		System.out.println(10/0);
		//내가 만든게 아니라 다른사람이 만든거에서 문제가 생긴 경우
		try {
			new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}


===============================================================================================
package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Finally {

	public static void main(String[] args) {

//		finally
//		-필요에 따라 try-catch뒤에 finally를 추가 할 수 있다.
//		-finally는 예외의 발생여부와 상관없이 가장 마지막에 반드시 수행된다.
//		
//		자동 자원 반환
//		-try(변수선언){}catch(Exception e) {}
//		-사용 후 반환이 필요한 객체를 try의 ()안에서 생성하면 try 블럭 종ㄹ료시 자동을 반환된다.
		
		FileInputStream fis = null; //파일읽기
		//파일에 객체생성하기
		try {
			fis = new FileInputStream("d:/file.txt");
			
			
			//사용하고 난 후에 자원을 다시 아래와 같이 fis.close();를 통해 반납해줘야 함.
			//만약 중간에 예외가 발생되면, close가 실행되지 않고 바로 catch로 넘어가 버림.
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} finally {
			try {
				// 이를 방지하고자 finally를 사용.
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//자동 자원 반환(JDK1.7부터 사용 가능)
		//finally대신 자동자원반환 역할을 해줌.
		//inputstream 은 읽는거, outstream은 쓰는거
		try(FileOutputStream fos = new FileOutputStream("d:/file.txt")){
			//d:/file.txt파일 만들어보기
			
			String str = "아무내용이나 작성을 하면 됩니다....";
			
			byte[] bytes = str.getBytes();
			for (int i = 0; i < bytes.length; i++) {
				fos.write(bytes[i]);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

=======================================================================================

package h_exception;

import java.io.IOException;

import e_oop.ScanUtil;

public class ThrowsException {

	public static void main(String[] args) {

		
		
		
		
		System.out.println("숫자입력 > ");
		int nextInt = ScanUtil.nextInt();
		System.out.println("입력한 숫자 : "+ nextInt);
//		try {
//			method();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		//new NullPointerException(); =>Null을 참조했다는 뜻
//		String str = null;
//		str.equals(str.equals(""));
//		
////		//new IndexOutOfBoundsException(); =>배열의 인덱스 범위를 벗어났다는 뜻.
////		int[] arr = new int[10];
////		arr[10]= 0;
//		
//	}
//
//	private static void method() throws IOException {
//		
//		throw new IOException();
//		//throw : 예외를 강제로 발생시키기
	}

}
