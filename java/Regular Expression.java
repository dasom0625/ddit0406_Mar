package i_api;

import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		/*
		 * 정규표현식 : 문자열의 패턴을 검사하는 표현식 /공백도 표현으로 인식하므로 공백을 함부로 넣으면 안된다.
		 * =>정규표현식을 만들때는 정확히 내가 원하는 것을 확인하기 위해 범위를 적당히 좁게 만드는것이 좋다. 
		 * 
		 * ^	뒷문자로 시작
		 * $	앞문자로 종료
		 * .	임의의 문자(줄바꿈 제외)
		 * *	앞문자가 0개 이상
		 * +	앞문자가 개 이상
		 * ?	앞문자가 없거나 1개
		 * []	문자의 집합이나 범위([a-z] : a부터 z까지, [^a-z]:a부터 z가 아닌 것)
		 * {}	앞문자 개수({2}: 2개 , {2,4}: 2개 이상 4개 이하)
		 * ()	그룹화(1개의 문자처럼 인식)
		 * |	OR 연산
		 * \s	공백, 탭, 줄바꿈
		 * \S	공백, 탭, 줄바꿈이 아닌 문자
		 * \w	알파벳이나 숫자
		 * \W	알파벳이나 숫자가 아닌 문자
		 * \d	숫자
		 * \D	숫자가 아닌 문자
		 * (?i)	뒷문자의 대소문자 구분 안함
		 * \	정규표현식에서 사용되는 특수문자 표현
		 */
		
		String str = "abc123";
		
		/*위 문자를 표현 할 정규표현식만들기*/
		//정규표현식 만들기 (만드는 과정)
		String regex = "[a-z]"; //[a부터 z까지]의 문자 하나만 표현함.
		regex = "[a-z]{3}"; //[a부터 z까지]의 문자 {세개}를 표현함.
		regex = "[a-z]{3}\\d"; //[a부터 z까지]의 문자 {세개}를 표현하고\d를 이용하여 숫자표현. 단, \는 탈출문자를 뜻하므로 \\를 사용
		regex = "[a-z]{3}\\d{1,3}"; //[a부터 z까지]의 문자 {세개}를 표현하고\d를 이용하여 숫자를 표현하고 {1개이상3개이하}를 표현.
		
		//방법 1. 만든 정규표현식 검사하기=>boolean 변수 = Pattern.matches(정규표현작성한것,정규표현할것)
		boolean result = Pattern.matches(regex, str);
		//=>일치하는지 하지 않는지 확인하기 위한 boolean type을 사용.
		System.out.println(result);
		
		
		//방법 2. 다른 정규표현식=>영문자인지 숫자인지 알수 없는 상태라는 가정하에 정규표현식 만들기
		regex = "[a-z0-9]+"; //대괄호 안에 여러개의 표현을 집어넣으면 그 중 하나가 됨. //+앞의 것이 한개 이상이라는 뜻		
		result = Pattern.matches(regex, str);
		System.out.println(result);

		
		//방법 3. 다른 정규표현식 =>최대한 짧고, 광범위한 정규식으로 만들기
		regex = "\\w*"; //\w로 알파벳이나 숫자를 표현하고 *은 0개이상의 갯수를 표현
		result = Pattern.matches(regex, str);
		System.out.println(result);
		
		
		
		
		//문제 1.
		//아이디, 전화번호, 이메일주소의 유효성
		/*아이디 : 공백없이 5~10자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용가능
		 *전화번호 : 010- 뒤의 숫자 및 - 표시
		 * 이메일 주소 : 아이디 + ddit.com
		 */
		String id = "yds_920625";
		String phone = "010-3256-0565";
		String mail = id+"@ddit.com";
		
		String regexID = "[a-z0-9\\-\\_]{5,10}";
		//쌤 답 : [a-z0-9_-]{5,20}
		result = Pattern.matches(regexID, id);
		System.out.println(result);
		
		String regexPhone = "[0-9]{1,4}\\-[0-9]{1,4}";
		//쌤 답 : ^0\\d{1,3)-\\d{3,4}-\\d{4}
		result = Pattern.matches("010-"+regexPhone, phone);
		System.out.println(result);
		
		
		String regexMAIL = regexID;
		//쌤 답 : [a-z0-9_-]{5,20}@[a-zA-Z]+\\.(?i}(com|net|org|[a-z]{2}\\.kr))$
		result = Pattern.matches(regexMAIL+"@ddit.com", mail);
		System.out.println(result);
		
		
	}

}
