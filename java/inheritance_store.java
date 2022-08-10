package g_oop2;

//다형성을 왜 사용하는지 알아보는 클래스!
public class Store {
	// 물건을 파는 가게를 만들어보자!
	// 물건을 클래스로 만들거다.
	// 모든 물건은 똑같은 내용이 존재 = 이름 , 가격 등..그래서 부모클래스로 만들거다 (공통점이니까)
	// 손님을 만들어서 물건을 구매하게 할거고 그걸 다형성으로 만들거다.
	public static void main(String[] args) {
   //4. 이제 shop에 물건을 진열하자
		Desktop d = new Desktop();
		AirCon ac = new AirCon();
		TV tv = new TV();

		// 5.손님 만들기
		Customer c = new Customer();

		// 6. 손님이 구매하기
		c.buy(d); //c.buy((Product)d);인데 Product가 생략되어 있는 상태
		c.buy(ac);
		c.buy(tv);
	}
}

//1.물건만들기(공통점을 추출하여 부모클래스)
class Product {
	String name; // 이름
	int price; // 가격

	// 1-1.이름과 가격을 넣을 파라미터 넣기위해 생성자만들기
	Product(String name, int price) {
		this.name = name; // 파라미터를 초기화
		this.price = price; // 파라미터를 초기화
	}
}

//2. 물건1(자식클래스 이용)
class Desktop extends Product {
	// =>처음에 Desktop부분에 컴파일 애러가 생기는데, 그 이유는 생성자를 만들지 않았기 때문
	// (단, 부모클래스에 현재 파라미터가 있으므로 파라미터가 있는 생성자를 만들어야 함)

	Desktop() {
		super("삼성컴퓨터", 1000000);
	}
}

//2-1. 물건 2
class AirCon extends Product {
	AirCon() {
		super("LG 에어컨", 2000000);
	}
}

//2-2. 물건3
class TV extends Product {
	TV() {
		super("LG TV", 3000000);
	}
}

//3.손님만들기
class Customer {
	// 3-1. 손님 돈
	int money = 3000000;
	// 3-2. 손님이 구매하면 그 물건들을 가지고있을 변수(배열) //그럼 배열타입은? 부모클래스인 Product
	Product[] item = new Product[10]; // 이렇게 Product로 배열로 하면 다형성의 특징으로 tv도,에어컨도, 컴퓨터도 저장 할 수 있음.
	// 3-3. 손님이 구매하는 행위의 메소드 //어떤 파라미터가 필요?어떤 물건 구매할건데??모르지?뭘 구매할지 파라미터로 받자.(단, 세
	// 아이템 모두 받을 수 있어야한다.)

	void buy(Product p) { // 다형성 : 이렇게 Product로 파라미터를 설정하면 세 아이템 모두 받을 수 있다.
		// 3-4. 돈이 충분한지 확인하기
		if (money < p.price) { // 만약 돈이 부족하면...
			System.out.println("잔돈이 부족합니다.");
			return; // 잔돈이 부족하다고 하고 종료.
		}

		money -= p.price; // 돈이 충분하면 가격만큼 내 돈을 차감.

		for (int i = 0; i < item.length; i++) {
			if (item[i] == null) { // null인 빈 공간에 내가 구매한 아이템을 채워넣는것.
				item[i] = p;
				break;
			}
		}
		System.out.println(p.name + "을 구매했습니다.");
	}
}
