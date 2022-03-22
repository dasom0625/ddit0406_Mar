package e_oop;

public class AirCon {

	//전원 변수  - 전원 켜고 끄고 onoff
	//온도 변수  메소드 2개  - 온도 높이기 / 온도 낮추기 temperature
	//시간 예약 변수 메소드 2개 - 현재 시간 / 몇시간 뒤  reservation
	
	
	boolean power = false;
	double temp = 24.0;
	String now = "10시";
	int rsv = 1;
	
	
	final double MIN_TEMP = 18.0;
	final double MAX_TEMP = 27.0;
	final int MIN_RSV = 1;
	final int MAX_RSV = 12;
	
	
	//전원
	public void power() {
		power =! power;
		System.out.println(power ? "Aircon ON" : "Aircon OFF");
		System.out.println("현재 시간 : " + now + "\n"+"현재 온도 : " +temp);
	}
	
	
	//온도 높이기
	public void tempUp() {
		if(power) {
			if(temp <= MAX_TEMP) {
				temp = temp + 0.5;
				System.out.println("온도가 0.5℃씩 올라갑니다. \n현재 온도 : " + temp);
			}
		}
	}
	
	//온도 낮추기
	public void tempDown() {
			if(power) {
				if(MIN_TEMP <= temp) {
					temp = temp - 0.5;
					System.out.println("온도가 0.5℃씩 내려갑니다. \n현재 온도 : "+temp);
				}
			}
		}
		
	

	
	//예약시간 설정
	public void rsv(int time){
		if(power) {
			if(MIN_RSV <= time && time <= MAX_RSV) {
				time = time; 
			}
			System.out.println("현재 시간 : " + now + "\n" + "현재 온도 : " + temp + "\n"+ time + "시간 뒤에 에어컨이 작동됩니다.");
		}
	}



	public static void main(String[] args) {
		
		AirCon aircon = new AirCon();
		while (true) {
			System.out.println("1.전원\t2.온도 높이기\t3.온도 낮추기\t4.에어컨 켜짐 예약\t5.에어컨 종료");
			int input = ScanUtil.nextInt();
			
			switch(input){
			case 1 : aircon.power();
				break;
				
			case 2 : aircon.tempUp(); 
				break;
				
			case 3 : aircon.tempDown();
				break;
				
			case 4 : 
				System.out.print("예약하실 시간을 시간단위로 입력해주세요.> ");
				int reservation = ScanUtil.nextInt();
				aircon.rsv(reservation);
				break;
				
			case 0 : System.out.println("에어컨을 종료합니다.");
			System.exit(0);
				break;
				
			}
		}
	}

}
