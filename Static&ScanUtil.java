package e_oop;

public class Static {
	System.out.println("e1점심비 : " + Employee.lunch);

	System.out.println("문자열 입력 >");
	String text = ScanUtil.nextLine();

	System.out.println("숫자 입력 >");
	int number = ScanUtil.nextInt();
  }
  
  
  ========================================================
  
  
  package e_oop;

import java.util.Scanner;

public class ScanUtil {

	//=============수업2(Static)====================//
	//Scanner는 자주사용하므로, static을 이용해서 만들어보기.
	//1. 스캐너 먼저 생성하기
	private static Scanner s = new Scanner(System.in);
	
	//2. String 메서드 만들기
	public static String nextLine() {
		return s.nextLine();
	}

	//3. nextInt 메서드 만들기  //double타입도 이와 같이 만들면 된다.
	public static int nextInt() {
		return Integer.parseInt(s.nextLine());
	}
	
	
}
