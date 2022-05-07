package i_api;

import java.util.Arrays;

public class StringClass {

	public static void main(String[] args) {
		/*
		 * String
		 * - 여러개의 문자를 사용하기 쉽게 만들어 놓은 클래스
		 * 
		 * String 의 주요 메서드
		 * - equals()	: 문자열의 내용이 같은지 반환한다.
		 * - length ()	: 문자열의 길이를 반환한다.
		 * - charAT()	: 특정 인덱스에 위치한 문자를 반환한다.
		 * - substring(): 문자열의 특정 부분을 잘라서 반환한다.
		 * - indexOf()	: 문자열 내의 특정 문자의 인덱스를 반환한다.
		 * - contains() : 문자열의 특정문자열을 포함하고 있는지 여부를 반환한다.
		 * - split()	: 문자열을 특정 문자를 기준으로 나누어 배열형태로 반환한다.
		 * - trim()		: 문자열 앞뒤의 공백을제거해 반환한다.
		 * - replace () : 문자열 내의 특정 문자를 다른 문자로 바꿔서 반환한다.
		 * - valueOf()	: 다른 타입의 데이터를 문자열로 변환해 반환한다.
		 */

		
		//예제 1. equals() => 참 거짓을 판단하는것으로 boolean type으로 설정
		boolean equals = "문자열".equals("문자열");
		System.out.println(equals);
	
		//예제 2. length() =>for문과 같이 사용  //charAt
		String str = "12345";
		int length = str.length();
		for(int i = 0 ; i < length ; i++) {
			char charAt = str.charAt(i);
			System.out.println(charAt);
		}
		
		//예제 3. 예제 2의 문자열 뒤집기
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i);
		}
		System.out.println(rev);
		
		
		//예제 4. substring()
		str = "0123456789";
		String sub1 = str.substring(3);	//인덱스를 파라미터에 넣어서 "3번인덱스이후(3)부터 가져오겠다."라는 의미
		System.out.println(sub1);

		String sub2 = str.substring(3,8); //"3번인덱스이후(3)부터 8번인덱스전(8)까지 가져오겠다."라는 의미
		System.out.println(sub2);
		
		
		//예제 5. indexOf()=>특정문자의 위치 찾기
		str = "수박 오렌지 귤 블루베리";
		int index = str.indexOf("오렌지"); //=>[0]수 [1]박 [2] [3]오
		System.out.println(index);
		
		
		//예제 6. substring()과 indexOf()조합
		String[] menu = {"수박 20000원", "오렌지 100000원", "귤 500원", "블루베리 3000원"};
		//끝인덱스를 indexOf()를 사용하면 된다. (지금 과일이름 뒤에는 모두 공백이 있으므로 공백으로 찾을 수 있다.)
		for(int i = 0 ; i < menu.length ; i++) {
			String name = menu[i].substring(0,menu[i].indexOf(" "));	
			//시작 인덱스를 0번째 인덱스, 끝 인덱스를 menu배열의 공백부분으로 설정
			System.out.println(name);

			
			//가격만 잘라서  int타입 변수에 저장해주세요.
			//내 답 =>" "가 공백이므로, 공백이 있으면 형변환이 어렵기땜에 반드시 +1을 해줘야 함.
			String pri = menu[i].substring(menu[i].indexOf(" ")+1,menu[i].indexOf("원"));
			int won = Integer.parseInt(pri);	
			System.out.println(won);
			
			//쌤 답 : 
			int price = Integer.parseInt(menu[i].substring(menu[i].indexOf(" ")+1,menu[i].indexOf("원")));
			System.out.println(price);
		}
	 
		//예제 7. contains()
		str = "abcd";
		boolean contains = str.contains("f");
		System.out.println(contains);
	
		//오렌지가 메뉴의 몇번 인덱스에 잇는지 찾기
		for(int i = 0 ; i < menu.length ; i++) {
			if(menu[i].contains("오렌지")) {
				System.out.println("오렌지는 " +i+"번 인덱스에 있습니다.");
			}
		}
	
		//예제8. split
		str = "a/b/c";
		String[] split = str.split("/");
		System.out.println(Arrays.toString(split));
	
		
		//메뉴명과 가격 나누기
		for (int i = 0 ; i<menu.length; i++) {
			split = menu[i].split(" ");	//공백을 기준으로 나누겠다.라는 의미
			System.out.println("메뉴명 :" + split[0] + " / 가격 : " + split[1]);
		}
		
		
		//예제 9. replace
		str = "123123123";
		str = str.replace("3", "짝");
		System.out.println(str);
		
		
		//예제10 . trim =>맨앞과 맨뒤에 있는 공백만 제거(ID나 PW같은 경우처럼 정확한 값을 입력받고싶을 때 사용)
		str = "  	문자열  ";
		String trim = str.trim();
		System.out.println("["+str + "] -> ["+trim+"]");
		
		
		//예제11. string이 아닌 타입을 string으로 형변환
		int num = 10;
		//1)문자열 더해서 그냥 문자열 만들기=>편법ㅋㅋ
		str = num + "";//int타입 뒤에 빈 문자열을 더하면 바로 문자열로 변경됨.
		//2)제대로 바꾸기..
		str = String.valueOf(num);//
	}

}
