package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * 저장하기위한 메소드(키와 값을 같이 저장) : Object put(Object key, Object value) : 지정된 키와 값을 저장한다.
		 * 키를 파라미터로 넘겨줘서 키와 값을 같이 제거 : Object remove(Object key) : 지정된 키로 저장된 값을 제거한다.
		 * 파라미터로 키를 넘겨주면 키에 저장된 값을 반환 : Object get(Object key) : 지정된 키의 값 (없으면 null)을 반환한다.
		 * 맵안에 들어있는 모든 키를 set형태로 반환 : Set keySet() : 저장된 모든 키를 Set으로 반환한다.
		 */
		
//		인덱스대신 키를 사용하여 저장한다.
//		키와 값을 같이 한번에 저장.
		
		//1.HashMap 객체 만들기(키와 값을 저장해야하므로 제네릭도 String(키)과 Object(값)로 지정)
		//=>한가지가타입이 아닌 여러가지 타입을 사용하므로, 값의 타입으로 Object를 종종 사용
		//=>키는 주로 String 타입으로 사용한다.
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		//2. 값 저장 => Object put(Object key, Object value)사용하기
		map.put("age", 10);
		map.put("name", "홍길동");
		map.put("date",new Date()); //Date() : 날짜를 표현해주는 클래스
		//=>값을 Object로 지정해서 값을 위와같이 인티저나 스트링 모두 사용가능하다.
		
		System.out.println(map);
		//출력값 : {date=Wed Apr 06 09:29:20 KST 2022, name=홍길동, age=10}
		//	=>Hashmap은 인덱스가 존재하지않아서 순서도 존재하지않는다.
		//	그렇기 때문에 우리가 저장한 순서가 아닌 순서없이 아무렇게나 출력됨.
		
		//3. 값을 수정하고 싶을때
		map.put("name", "이순신"); //같은키로 다시 한번 저장하면 기존의 값을 덮어쓰게 됨.
								 //Hashmap은 하나의 키에 하나의 값만 저장이 가능!
		System.out.println(map);
		//출력값 ) {date=Wed Apr 06 09:35:22 KST 2022, name=이순신, age=10}
		
		
		//4. 값제거 :=> Object remove(Object key) 사용
		map.remove("age");
		System.out.println(map);
		//출력값 ) {date=Wed Apr 06 09:35:22 KST 2022, name=이순신}
		
		
		//5. 값을 얻기위한 메소드  => Object get(Object key)
		Object value = map.get("name");
		System.out.println(value);
		//출력값 : 이순신
		
		//6.Object가 아닌 다른 타입을 사용하고 싶을때
		//방법 1)
		((String)value).substring(1,2); //value만 형변환하기위해서 괄호 이용
		//방법 2)
		String str = (String)map.get("name"); //꺼내려는 타입을 알아야 해당 타입으로  꺼낼 수 있음.
		
		//7.Set keySet() : for문으로 돌리면서 키를 불러오기 위해
		Set<String> keys = map.keySet(); //같은 값(중복된 값)이 두번이상 저장되지 않음.
		//Hashmap에서 String으로 키를 지정해줬기떄문에 Set의 제네릭도 String타입이다.
		//Iterator를 사용해서 꺼내도 되고, for문을 사용해서 꺼내도 된다.
		/*방법 1)향상된 for문 사용 방법 (for-each)
		 *콜론을 기준으로 앞에는 값을 저장할 변수, 뒤에는 배열같은게(배열, arraylist, set 등 순서대로 저장된..) 온다.
		 *뒤에있는 값을 차례대로 꺼내서 앞에있는 변수에 저장하고, 블럭안에 있는 내용을 실행
		 *한번 실행하면 또 다음 값을 꺼내서 앞에있는 변수에 저장하고, 실행을 반복
		 */
		for(String key : keys) { 
			System.out.println(key + " : " + map.get(key));
			//출력값 )
			//date : Wed Apr 06 09:49:15 KST 2022
			//name : 이순신
			
//------------------------------------------------------------------------------------------//			
//			ArrayList<Dept>deptTable = new ArrayList<Dept>();
		
			
			//DB와 함께 테이블 만들기
			ArrayList<HashMap<String,Object>> table = new ArrayList<HashMap<String,Object>>();
		
			HashMap<String,Object>row = new HashMap<String, Object>(); //테이블의 한줄을 나타낼수있음
			row.put("DEPTNO", 10);
			row.put("DNAME", "ACCOUNTING");
			row.put("LOC", "NEW YORK");
			
			table.add(row); //테이블에 한 줄 저장하기
			
			row = new HashMap<String, Object>();
			row.put("DEPTNO", "20");
			row.put("DNAME", "RESEARCH");
			row.put("LOC", "DALLAS");
			
			table.add(row);
			
			System.out.println(table);
			
			//출력값 )
			//[{LOC=NEW YORK, DEPTNO=10, DNAME=ACCOUNTING}, {LOC=DALLAS, DEPTNO=20, DNAME=RESEARCH}]
			
//-----------------------------------------------------------------------------------------//
			ArrayList<HashMap<String,Object>> BomTable = new ArrayList<HashMap<String,Object>>();
			
			HashMap<String,Object>row1 = new HashMap<String, Object>();
			row1.put("ITEM_ID", 1001);
			row1.put("PARENT_ID", "null");
			row1.put("ITEM_NAME", "컴퓨터");
			row1.put("ITEM_QTY", 1);
			BomTable.add(row1);

			row1.put("ITEM_ID", 1002);
			row1.put("PARENT_ID", 1001);
			row1.put("ITEM_NAME", "본체");
			row1.put("ITEM_QTY", 1);
			BomTable.add(row1);
			
			row1.put("ITEM_ID", 1003);
			row1.put("PARENT_ID", 1001);
			row1.put("ITEM_NAME", "모니터");
			row1.put("ITEM_QTY", 1);
			BomTable.add(row1);
			
			row1.put("ITEM_ID", 1004);
			row1.put("PARENT_ID", 1001);
			row1.put("ITEM_NAME", "프린터");
			row1.put("ITEM_QTY", 1);
			BomTable.add(row1);
			
			row1.put("ITEM_ID", 1005);
			row1.put("PARENT_ID", 1002);
			row1.put("ITEM_NAME", "메인보드");
			row1.put("ITEM_QTY", 1);
			BomTable.add(row1);
			
			row1.put("ITEM_ID", 1006);
			row1.put("PARENT_ID", 1002);
			row1.put("ITEM_NAME", "랜카드");
			row1.put("ITEM_QTY", 1);
			BomTable.add(row1);
			
			row1.put("ITEM_ID", 1007);
			row1.put("PARENT_ID", 1002);
			row1.put("ITEM_NAME", "파워서플라이");
			row1.put("ITEM_QTY", 1);
			BomTable.add(row1);
			
			row1.put("ITEM_ID", 1008);
			row1.put("PARENT_ID", 1005);
			row1.put("ITEM_NAME", "CPU");
			row1.put("ITEM_QTY", 1);
			BomTable.add(row1);
			
			row1.put("ITEM_ID", 1009);
			row1.put("PARENT_ID", 1005);
			row1.put("ITEM_NAME", "RAM");
			row1.put("ITEM_QTY", 1);
			BomTable.add(row1);
			
			row1.put("ITEM_ID", 1010);
			row1.put("PARENT_ID", 1005);
			row1.put("ITEM_NAME", "그래픽카드");
			row1.put("ITEM_QTY", 1);
			BomTable.add(row1);

			row1.put("ITEM_ID", 1011);
			row1.put("PARENT_ID", 1005);
			row1.put("ITEM_NAME", "기타장치");
			row1.put("ITEM_QTY", 1);
			BomTable.add(row1);

//			Object value1 = BomTable.get("ITEM_ID");
//			System.out.println(value);
//			//출력값 : 이순신
//			System.out.println(BomTable);
//			Set<String> key1 = BomTable.keySet();
			
			
			//출력

			
			for (int i = 0; i < BomTable.size(); i++) {
//				HashMap<String, Object> row1 = BomTable.get(i);
				row = BomTable.get(i);
//				System.out.println(row.get("ITEM_ID"));
//				System.out.println(row.get("PARENT_ID"));
//				System.out.println(row.get("ITEM_NAME"));
//				System.out.println(row.get("ITEM_QTY"));
				for (String key1 : row.keySet()) {
					System.out.println(i + " : " + key1 + " / " + row.get(key1));
				}

			}

			
			
			
		}
	}

	class Dept{
		int deptNo;
		String dName;
		String loc;
	}
	
	
}

