아래먼저 만들기.

package f_game;

import e_oop.ScanUtil;

//게임의 내용을 만드는 곳(캐릭터, 몬스터, 아이템은 게임에 등장하는 아이들을 만든거다.)
public class MyGame {

=======================================================================================================
package f_game;

public class Character {

	//캐릭터 기본
	String name;	//이름
	int maxHP;		//최대체력
	int maxMP;		//최대마나
	int hp;			//체력
	int mp;			//마나 : 아이템을 사용할때..
	int att;		//공격력
	int def;		//방어력
	int level;		//레벨 : 경험치가 최대치로 쌓이면..
	int exp;		//경험치
	Item[] items;	//보유아이템=>아이템 클래스 만들어줘야 함.
	
	
	//생성자로 변수들 초기화=>?.생성자는 하나만 파라미터에 넣고 나머지는 그밑에 그냥 작성해도 되는건가?
	Character(String name){	//외부에서 주는 정보는 파라미터로 받는다.
		this.name = name;
		maxHP = 100;
		maxMP = 50;
		hp = maxHP;
		mp = maxMP;
		att = 20;
		def = 10;
		level =1;
		exp = 0;
		items = new Item[10];
		
	}
	
	//메소드만들기
	//캐릭터의 정보를 볼 수 있는 메소드
	void showStatus() {
		System.out.println("=======================");
		System.out.println("----------상태----------");
		System.out.println("이름 : " + name);
		System.out.println("레벨 : " + level + "(" + exp + "/100)");
		System.out.println("체력 : " + hp + "/" + maxHP);
		System.out.println("마나 : " + mp + "/" + maxMP);
		System.out.println("공격 : " + att);
		System.out.println("방어 : " + def);
		System.out.println("---------아이템----------");
		for(int i = 0 ; i < items.length; i++) {
			if(items[i] != null) {	//items[i]가 null이 아니면 출력
				items[i].showItemInfo(); 
			}
		}
		System.out.println("=======================");
	}
	
	//공격하는 메소드=>파라미터가 필요(공격할 대상)=>이 캐릭터내에는 공격할대상이 없으므로
	void attack(Monster m) {
		int damage = att-m.def; //내 공격력-몬스터 방어력
		damage = damage <=0 ? 1 : damage ;//데미지가 0보다 작으면 최소한 1이라도 될 수 있게 만듬.
		m.hp -= damage <=m.hp ? damage : m.hp; //체력은 데미지가 체력보다 작으면 최소한 데미지만큼 체력을 잃게 만듬.
		System.out.println(name + "가 공격으로 " + m.name +"에게 "+ damage +"만큼 데미지를 주었습니다.");
		System.out.println(m.name + "의 현재 체력 : "+ m.hp + "/" + m.maxHP);
	}
	
	//경험치 얻는 메소드=>얼만큼의 경험치를 얻을건지 파라미터가 필요함
	void getExp(int exp) {
		System.out.println(exp + "의 경험치를 획득하였습니다.");
		this.exp += exp;	//파라미터에서 받은 경험치(int exp)만큼 현재 경험치(this.exp)에 더해줌.
		while (100 <= this.exp) { //경험치가 100이상일때 while문을 통해 levelup을 여러번 할 수 있게 함.
			levelUp();
			this.exp -=100;
			
		}
		
	}
	
	//레벨업하는 메소드 =>원하는 만큼 모든 경력치나 역량들을 올려줌.
	void levelUp() {
		level++;
		maxHP +=10;
		maxMP +=5;
		att += 2;
		def += 2;
		hp = maxHP;
		mp = maxMP;
		System.out.println("!!LEVEL UP!!");
	}
	
	//아이템 얻는 메소드=>어떤아이템을 받는지는 여기선 알 수 없어서 Item클래스에서 파라미터로 받아와야 함.
	void getItem(Item item) {
		System.out.println(item.name + "을 획득하였습니다.");
		for(int i = 0 ; i < items.length; i++) {
				if(items[i] == null ) {
					items[i] = item;
					break;
				}
			}
			maxHP += item.hp;
			maxMP += item.mp;
			att += item.att;
			def += item.def;
		}
	
	}
	//모두 작성되면 몬스터 클래스로 넘어가기.
	
  
  ======================================================================================================
  
  
  package f_game;

public class Monster {
	//공격할 대상에서 몬스터 클래스에 변수가 없으면 컴파일 애러가 나타나므로 변수를 만들어줌.
	//몬스터의 기본(캐릭터에서 복사해옴)
	String name;	//이름
	int maxHP;		//최대체력
	int maxMP;		//최대마나
	int hp;			//체력
	int mp;			//마나 : 아이템을 사용할때..
	int att;		//공격력
	int def;		//방어력
	int level;		//레벨 : 경험치가 최대치로 쌓이면..
	int exp;		//경험치
	Item[] items;	//보유아이템=>아이템 클래스 만들어줘야 함.	
	//몬스터가 여러종류가 나타나야되서...모든 변수를 파라미터로 받아서 초기화 한다.
	
	//생성자 만들기=>모든 변수를 파라미터로 받기.
	Monster(String name, int hp, int mp, int att, int def, int level, int exp, Item[]items){
		this. name = name;	//이름
		this. maxHP = hp;		//최대체력
		this. maxMP = mp;		//최대마나
		this. hp = maxHP;			//체력
		this. mp = maxMP;			//마나 : 아이템을 사용할때..
		this. att = att;		//공격력
		this. def = def;		//방어력
		this. level = level;		//레벨 : 경험치가 최대치로 쌓이면..
		this. exp = exp;		//경험치
		this. items = items;
		
	}
	//공격하기=>캐릭터랑 동일(다만, 대상만 다르게해야하므로 파라미터를 Caracter로 바꿔줌 =>변수이름에 ctrl+1누르면 한번에 바꿀수있음)
	void attack(Character c) {
		int damage = att-c.def; //내 공격력-몬스터 방어력
		damage = damage <=0 ? 1 : damage ;//데미지가 0보다 작으면 최소한 1이라도 될 수 있게 만듬.
		c.hp -= damage <=c.hp ? damage : c.hp; //체력은 데미지가 체력보다 작으면 최소한 데미지만큼 체력을 잃게 만듬.
		System.out.println(name + "가 공격으로 " + c.name +"에게 "+ damage +"만큼 데미지를 주었습니다.");
		System.out.println(c.name + "의 현재 체력 : "+ c.hp + "/" + c.maxHP);
	}
	
	//아이템 떨어트리기 (아이템을 캐릭터에게 줘야하므로 리턴타입이 필요 )=>랜덤으로 아이템을 떨어트릴거임
	Item itemDrop() {
		return items[(int)(Math.random()*items.length)]; //items배열에 있는 아이템을 리턴하는것(인덱스가 랜덤임)
	}
}


===========================================================================================================
package f_game;

public class Item {
	
	//아이템 얻을 때 필요한 변수들
	String name;	//이름
	int hp;			//체력
	int mp;			//마나 : 아이템을 사용할때..
	int att;		//공격력
	int def;		//방어력
	
	//변수를 저장하기위한 생성자를 만듬.
	Item(String name, int hp, int mp, int att, int def){
		this. name = name;	//이름
		this. hp = hp;		//최대체력
		this. mp = mp;		//최대마나
		this. att = att;		//공격력
		this. def = def;		//방어력
		
	}
	
	// 아이템 정보를 알려주는 메소드
	public void showItemInfo() {
		String info = name + " : ";
		//추가된 정보만 출력될수 있게 만듬.
		if (0 < hp) info = "체력 +" + hp;
		if (0 < mp) info = "마나 +" + mp;
		if (0 < att) info = "공격 +" + att;
		if (0 < def) info = "방어 +" + def;

		System.out.println(info);

	}

}


========================================================================================

package f_game;

import e_oop.ScanUtil;

//게임의 내용을 만드는 곳(캐릭터, 몬스터, 아이템은 게임에 등장하는 아이들을 만든거다.)
public class MyGame {
	//등장시킬 아이들 변수 만들기
	Character c;
	Item[] items;
	
	
	//변수들 초기화(초기화 블럭사용)
	
	{
		System.out.println("캐릭터의 이름을 입력해주세요>");
		String name = ScanUtil.nextLine();
		c = new Character(name);
		
		items = new Item[10];
		items[0] = new Item("무한의 대검", 0,0,10,0);
		items[1] = new Item("가시의 갑옷", 0,0,0,10);
		
	}
	
	//메인 메소드에서 게임 내용 만들기
	public static void main(String[] args) {
		new MyGame().start();
	}
	
	void start() {//static이 붙어있지 않으면 객체생성을 하지 않고도 사용 가능.
		while (true) {
			System.out.println("1.내정보 2.사냥 0.종료> ");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				c.showStatus();
				break;

			case 2: // 몬스터를 사냥하는 내용
				hunt();
				break;

			case 0:
				System.out.println("게임이 종료됩니다.");
				System.exit(0);
			}
		}

	}
//case 1을 위한 메소드
	void hunt() {
		Monster m = new Monster("고블린", 20, 10, 15, 10, 1, 150, new Item[] { items[0], items[1] });
		System.out.println(m.name + "를 만났습니다. 전투를 시작합니다.");

		int input = 0;
		battle: while (true) {
			System.out.print("1.공격  2.도망 >");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				c.attack(m);
				if (m.hp <= 0) {
					System.out.println(m.name + "을 처치하였습니다.");
					c.getExp(m.exp);	
					c.getItem(m.itemDrop());	//아이템은 랜덤으로 드롭
					break battle;
				}
				
				m.attack(c);
				break;
			case 2:
				System.out.println("도망쳤습니다.");
				break battle;
			}

		}
	}
}
