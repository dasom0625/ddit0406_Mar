package j_collection;

public class Score{
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int soc;
	private int sci;
	private int oracle;
	private int java;
	private int rank;//아래에는 추가안하고, 얘만 추가
	
	
	//alt+shift+s를 누르면 제네레이트를 한번에 만들수있다.
	public Score(String name, int kor, int eng, int math, int soc, int sci, int oracle, int java) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.soc = soc;
		this.sci = sci;
		this.oracle = oracle;
		this.java = java;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getSoc() {
		return soc;
	}


	public void setSoc(int soc) {
		this.soc = soc;
	}


	public int getSci() {
		return sci;
	}


	public void setSci(int sci) {
		this.sci = sci;
	}


	public int getOracle() {
		return oracle;
	}


	public void setOracle(int oracle) {
		this.oracle = oracle;
	}


	public int getJava() {
		return java;
	}


	public void setJava(int java) {
		this.java = java;
	}

	private int getSum() {
		return kor+eng+math+soc+sci+oracle+java;
	}
	
	private int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	private double getAvg() {
		return getSum() /7.0;
	}
	
	
	@Override
	public String toString() {
//		System.out.printf("%d\t%d",kor,eng);//첫번째 "%d"에 kor을 넣고, 두번째 "%d"에 eng을 넣겠다는 뜻.
		return String.format("%s\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%.2f\t%d",	//.2f=>소수점 둘째자리까지 보여줌.
							name,kor,eng,math,soc,sci,oracle,java,getSum(),getAvg(),getRank());
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package j_collection;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Score_class {

	public static void main(String[] args) {
		
		List<Score>list = new ArrayList<Score>(); //Score라는 객체타입을 넣을 수 있다.라는 의미.
		
		//랜덤숫자받기
		Random random = new Random();
		random.nextInt(101); //0부터 100까지 랜덤숫자를 뽑아줌
		
		String[] names = {"이정후", "은주영", "박다혜", "이다솜", "윤정영", 
     			"이가은", "이상학", "신현국", "김은태", "황명성", 
     			"이재원", "문승제", "권흥종", "이규범", "안은실", 
     			"이희경", "오세영", "김민정", "최민정", "전윤미", 
     			"김수원", "이소정", "임정은", "최지은", "최지연"};
		
		
		for(int i =0 ; i< names.length; i++) {
		list.add(new Score(names[i], 
				random.nextInt(101), 
				random.nextInt(101),
				random.nextInt(101),
				random.nextInt(101),
				random.nextInt(101),
				random.nextInt(101), 
				random.nextInt(101)));
	}
	
			//석차구하기
		for(Score score : list) { //->가져온 데이터(기준)
			int rank = 1; //처음에는 1등으로 시작
			for(Score s : list) { //=>가져온 데이터랑 비교하는 비교대상
				if(score.getSum()<s.getSum()) {
					rank++;
				}
			}
			score.setRank(rank);
		}

		
		System.out.println("이름\t국어\t영어\t수학\t사회\t과학\tOracle\tJava\t합계\t평균\t석차");
		System.out.println("--------------------------------------------------------------------");
		//향상된 for 문 : for-each문 => jdk1.5부터 가능!
		for(Score score : list) { //콜롬(:)을 기준으로 왼쪽(socre)은 타입, 오른쪽은 배열데이터(list부분)을 반복 
			//= Score score = list.get(0);
			//=>Score score = list.get(1);
			//.....반복하는 행위와 같다.
	System.out.println(score);
}
		//과목 합계
		
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		int socSum = 0;
		int sciSum = 0;
		int OracleSum = 0;
		int JavaSum = 0;
		for(Score score : list) {
			korSum += score.getKor();
			engSum += score.getEng();
			mathSum += score.getMath();
			socSum += score.getSoc();
			sciSum+= score.getSci();
			OracleSum+= score.getOracle();
			JavaSum+= score.getJava();
		}
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("과목 합계\t%,d\t%,d\t%,d\t%,d\t%,d\t%,d\t%,d",
				korSum,engSum,mathSum,socSum,sciSum,OracleSum,JavaSum);
		
		
		//과목 평균
		double korAvg = 0;
		double engAvg = 0;
		double mathAvg = 0;
		double socAvg = 0;
		double sciAvg = 0;
		double OracleAvg = 0;
		double JavaAvg = 0;
		for(Score score : list) {
			korAvg = korSum / 25.0;
			engAvg = engSum / 25.0;
			mathAvg = mathSum /25.0;
			socAvg = socSum / 25.0;
			sciAvg = sciSum / 25.0;
			OracleAvg = OracleSum / 25.0;
			JavaAvg = JavaSum / 25.0;
		}
		
		System.out.println("");
		System.out.printf("과목 평균\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f"
				,korAvg,engAvg,mathAvg,socAvg,sciAvg,OracleAvg,JavaAvg);
}	

}
