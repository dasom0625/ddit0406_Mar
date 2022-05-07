package i_api;

import e_oop.ScanUtil;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마를 붙여 출력해주세요.
		
		System.out.println("숫자를 입력해주세요 > ");
		String input = ScanUtil.nextLine();
		
		//입력받은 숫자 뒤집기
		String num = "";
		for(int i = input.length()-1; i>=0 ; i--) {
			num += input.charAt(i);
		}
		System.out.println(num);

		
		//뒤집은 숫자에 3자리 뒤에마다 , 찍기
		String comma1 = num.substring(0,3);
		String comma2 = num.substring(3,6);
		String comma3 = num.substring(6);
		String result = (comma1+","+comma2+","+comma3);
		System.out.println(result);
    
    ///////////////////////////////////////////////////////////
    //쌤 답
    package i_api;

import e_oop.ScanUtil;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마를 붙여 출력해주세요.
		System.out.println("숫자 입력> ");
		String num = ScanUtil.nextLine();
		String com = "";
		
		int count = 0;
		for(int i = num.length()-1 ; i>=0; i--) {
			com = num.charAt(i)+com;	//기존에 있던 값의 앞에다가 더해야 함.(num.cahrAt(i)가 앞에 와야 한다는 뜻)
			count++;
			if(count % 3 == 0 && count != num.length()) { 
				//count != num.length()는 맨 앞에는 ,가 찍히지 않게하는 조건
				com = "," + com;
			}
		}
		System.out.println(com);
    }
    }
