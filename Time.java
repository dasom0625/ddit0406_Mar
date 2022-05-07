package g_oop2;

public class Time {
	//시간 만들기
	private int hour;
	private int minute;
	private int second;
	
	
	//getter setter만들기 (source -> Generate Getter and Setter클릭)
	//setter에 조건을 걸어서 올바른 값만 입력받을 수 있게 할 수 있다.
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
	
		if(hour>0 && hour<24) { 
		this.hour = hour;
		} else if (hour == 24) {
			this.hour++; 
			this.hour = 0;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		
		if(minute>0 && minute<61) {
		this.minute = minute;
		} else if (minute == 60) {
			this.hour++;
			this.minute = 0;
		}
	}
		
		
	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		
			if (second > 0 && second < 60) {
				this.second = second;
			} else if (second == 60) {
				this.minute++;
				this.second = 0;
			}
		}
	@Override
	public String toString() {
		return hour + ":" + minute +  ":" + second;
	
	}
	
	void clock() {
		while(true) {
			System.out.println(toString());
			stop();
			setSecond(second+1);
		}
	}
	
	
	
	//clock()이란 메소드를 위해서만 만든 부가적인 메소드이기 때문에 private을 붙여 다른 클래스에서 안보이게 하기.
	private void stop() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	//Thread.sleep(); 은 1000분의 1초동안 멈추는 메소드.
			//=>괄호안해 1000을 넣으면 1초가 됨.
	}
	
	
}
	


===============================================================================================
package g_oop2;

public class AccessModifier {

	public static void main(String[] args) {
		AccessModifier am = new AccessModifier();
    
    		//Time클래스 객체 생성먼저하고와서 아래와 같이 불러옴.
		Time time = new Time();
//		
//		time.hour = 9;
//		time.minute = 44;
//		time.second=9999;
//		//=>이와 같이 Time클래스에서 private를 붙이면 컴파일 애러가 생기므로, Time클래스에서 GetterSetter세팅
//		
		time.setHour(23);
		time.setMinute(59);
		time.setSecond(58);
		
		System.out.println(time);
		
		time.clock();
		
	}
}
