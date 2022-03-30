package j_collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListClass {

	public static void main(String[] args) {
		
//		  Collection Framework : 여러개의 데이트를 다루기위한 클래스를 표준화한것.
//		  - List => 인터페이스(부모의 역할)/ArrayList (상속받은 아이) 
//		  - Map => 인터페이스(부모의 역할) /CashMap (상속받은 아이) 
//		  - Set =>인터페이스(부모의 역할)
//		  
//		  ArrayList의 주요 메서드 : 생긴건 배열처럼 생겼으나 길이를 정하지 않는다.(유동적인 배열을 사용) 
//		  
//		  - boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다. 
//		  =>마지막에 값을 계속 추가하는 방법 
//		  
//		  - void add (int index, object obj) : 지정된 위치에 객체를 추가한다. 
//		  =>인덱스를 지정해서 그 위치에 obj데이터를 저장해주고, 기존에 그 인덱스에 있던 데이터는 한칸씩 뒤로 밀려남. 
//		  
//		  - object set(int index, object obj) : 지정된 위치에 객체를 저장 후 객체를 반환한다. 
//		   =>인덱스를 지정해서 그 위치에 obj데이터를 저장하고, 기존에 그 위치에 저장되어있던 데이터는 리턴해줌. 
//		  
//		  - object get(int index) : 지정된 위치의 객체를 반환한다. 
//		   =>인덱스를 지정해주면 그 인덱스에 위치한 데이터를 얻을 수 있음. 
//		 
//		  - int size() : 저장된 객체의 수를 반환한다. =>Array 길이를 반환하는 length가 아닌 size를 사용하여 저장된 객체수를 반환.
//		  
//		  - object remove(int index) : 지정된 위치의 객체를 제거한다.
		 

		// 1. ArrayList를 사용하기 위한 객체생성
		ArrayList sample = new ArrayList();

		// 저장하기
		sample.add("abc");
		sample.add(100);
		sample.add(new Scanner(System.in)); // 어떤 타입이든 아무거나 다 저장가능하도록 Scanner받음
											// 단, 꺼낼때 어떤 타입인지 예측이 되지 않아 문제가 될 수 있음.
											// 그래서 제네릭 사용해야 함
		// 2. 제네릭 사용해보기
		ArrayList<Integer> list = new ArrayList<Integer>();
		// => <Integer>의<>가 제네릭이라고 하며, 무엇을 저장할건지 지정해주는 역할.즉, Integer을 저장하겠다는 뜻.
		// => Arraytype에는 기본형을 저장하지 못하기 때문에 Int대신 참조형인Integer를 사용한것이다.

		// 3. 저장하기
		list.add(10);
		list.add(new Integer(10));
		// list.add(new Integer(10)); 원래는 이렇게 객체를 생성해야 함.
		// 그러나 int는 기본형 타입이라서 Wrapper Class로 자동 형변환이 된 것을 알 수 있음.(*아래 참고*)
		// int타입으로 인식하여 저장이 잘 되는것을 알 수 있음.

		/*
		 * Wrapper Class : 기본형 타입과 WrapperClass간에는 자동 형변환이 가능함. -byte : Byte -short :
		 * Short -int : Integer -long : Long -float : Float -double : Double -boolean :
		 * Boolean -char : Character
		 */

//		list.add("abc"); //int타입이 아니기때문에 컴파일 애러가 발생하는것을 볼 수 있음.

		// 4. 저장하면서 return타입 확인해보기
		System.out.println(list.add(30));
		// 출력값 : true(boolean type : 저장에 성공하면 true, 실패하면 false)

		// 5. 파라미터 두개있는 add사용
		list.add(1, 40); // 1번인덱스에 40이란 데이터 저장하겠다는 뜻. 그럼 기존 인덱스 1에 있던 값 한칸씩 미뤄짐.
		System.out.println(list); // 주소가 출력되는게 아니라 값이 출력됨(Array.toString사용할필요없음)
		// 출력값 : [10, 40, 10, 30]

//		list.add(4,50); //현재 3번인덱스까지만 값이 있는 상태라 인덱스 범위를 벗어나서 저장할 수 없다.

		// 6.수정하는 메소드
		Integer before = list.set(2, 50); // 2번인덱스에 50을 저장하면서 기존 2번인덱스에 있던 값을 리턴하겠다.란 뜻
		System.out.println("befor : " + before);
		System.out.println(list);

		// 7. get을 사용하여 데이터 리턴받기
		int get = list.get(2); // 2번 인덱스에 있는 값을 리턴//Integer사용해야하나 자동 형변환 됨.
		System.out.println(get);

		// 8. size()와 remove사용
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.remove(i));
		}
		System.out.println(list);
		/*
		 * 출력값 0 : 10 1 : 50 [40.30] =>0번인덱스의 10을지우면서 기존에 있던 1,2,3인덱스 앞으로 땡겨짐 그리고나서
		 * 1번인덱스가 삭제되는데 이동한 후라 1번인덱스의 50이 지워지고 다시 앞으로 땡겨짐 즉, 2번인덱스에는 더이상 아무 데이터도 없는 상태.
		 */

		// 9. 8번을 제대로 실행하려면...거꾸로 돌려야 함.
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(i + " : " + list.remove(i));
		}
		System.out.println(list);
		/*
		 * 출력값 3 : 30 2 : 50 1 : 40 0 : 10 []
		 */

/////////////////////////////////////////////////////////////////////////////////////////		

		// 문제 1.list에 1~100사이의 랜덤값을 10개 저장해주세요.
		for (int i = 0; i < 10; i++) {
			list.add((int) (Math.random() * 100 + 1));
		}
		System.out.println(list);
//쌤 답
//	      for(int i = 0; i < 10; i++) { //length란 값을 넣으면 안 되고 10을 써줘야 함
//	         int random = (int)(Math.random()*100)+1;
//	         list.add(random);
//	      }
//	      System.out.println(list);
		
		// 문제 2. list에 저장된 값의 합계와 평균을 구해주세요.

		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		double avg = (double) sum / list.size();
		System.out.println("sum : " + sum + " / avg : " + avg);

		
		// 문제 3. list에서 최소값과 최대값을 구해주세요.
		int min = list.get(0);
		int max = list.get(0);

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i) < min) {
				min = list.get(i);
			}
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}
		System.out.println("max : " + max + " / min : " + min);

		
		// 문제 4. list를 오름차순으로 정렬해주세요. =>선택정렬
		for (int i = 0; i < list.size() - 1; i++) {
			min = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) < list.get(min)) {
					min = j;
				}
			}
//			int temp = list.get(i);
//			list.set(i,list.get(min));
//			list.set(min,temp);
//			위 세줄을 아래와 같이 줄일 수 있다.
			list.set(min, list.set(i,list.get(min)));
		}
		System.out.println(list);
		
		
/////////////////////////////////////////////////////////////////////////
		//2차원 ArrayList배열 사용하기
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
		
		//1. 저장하기
		//객체생성을 통해 1차원 ArrayList먼저 만들기
		list = new ArrayList<Integer>();
		//=>기존의 변수(list)를 사용했지만, 객체를 새로 생성해서 저장했기때문에 다시 처음의 비어있는 상태가 됨.
		//1차원 ArrayList먼저 저장
		list.add(10);
		list.add(20);
		list.add(30);
		
		//1. 2차원 ArrayList에 저장하기
		list2.add(list);
		
		//3. 하나 더 저장하기=>새로운 객체를 만들어서 또 다시 저장해야함.
		list = new ArrayList<Integer>();
		list2.add(list);
		//=>이렇게 하면 현재 2차원 ArrayList에 1.번과 3.번의 1차원 리스트들이 들어간 상태
		
		//4. 3.의 리트스테 값 저장하기
		list.add(40);
		list.add(50);
		list2.get(1).add(60);
		
		System.out.println(list2);
		/*
		 * 출력 값 : 
		 * [[10, 20, 30], [40, 50, 60]]
		 */
	
		//5. 모든 값 가져오기
		for(int i = 0 ; i< list2.size(); i++) {
			for(int j= 0 ; j<list2.get(i).size(); j++) {
				System.out.println(list2.get(i).get(j));
				/*
				 * 출력값 : 
				 * 10
				 * 20
				 * 30
				 * 40
				 * 50
				 * 60
				 */
			}
		}

///////////////////////////////////////////////////////////////////////////////////////
		//문제 1. 학생 3명의 5과목에 대한 0~100점의 랜덤한 점수를 2차원 ArrayList에 저장해주세요.
		list2 = new ArrayList<ArrayList<Integer>>();
		for(int i = 0 ; i<3; i++) {	
			list  = new ArrayList<Integer>();	//세명
			for(int j= 0 ; j<5; j++) {
				list.add((int)(Math.random()*101)); //점수 5과목
			}
			list2.add(list);
			System.out.println(list);
		}
	

//		int sum = 0;
//		for (int i = 0; i < list.size(); i++) {
//			sum += list.get(i);
//		}
//		double avg = (double) sum / list.size();
//		System.out.println("sum : " + sum + " / avg : " + avg);

		
		//문제 1. 각 학생별 합계와 평균 구하기
		ArrayList<Integer>sums = new ArrayList<Integer>();
		ArrayList<Double>avgs = new ArrayList<Double>();

		for (int i = 0; i < list2.size(); i++) {
			sum = 0;
			for (int j = 0; j < list2.get(i).size(); j++) {
				sum += list2.get(i).get(j);

			}
			sums.add(sum);
			avgs.add((double) sum/ list2.get(i).size());
		}
		System.out.println("sum : " + sums);
		System.out.println("avg : " + avgs);
		
		
	}
}
