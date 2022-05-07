package i_api;

public class StringSpeedTest {

	public static void main(String[] args) {
		String str = "a";
		
//		str += "a"; //기존에 있던 a에 a가 붙는게 아니라 아예 새로운 객체가 생성되는거다.//
					//기존의 str의 a는 100번지에 저장되었다면, 새로 만든 'aa'는 객체를 새로 생성한것이기 때문에 다른 번지수인 주소에 저장

//		//위의 내용을 이해하기 위해 얼마나 걸리는지 확인해보기
//		long start = System.currentTimeMillis();	//1000분의 1초를 확인하는 방법
//		for(int i =0 ; i<200000 ; i++) {
//			str += "a";
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(end-start+"ms");
		
		StringBuffer sb = new StringBuffer("a");
		long start = System.currentTimeMillis();	
		for(int i =0 ; i<200000 ; i++) {
			sb.append("a");
		}
		long end = System.currentTimeMillis();	
		
		
	}

}
