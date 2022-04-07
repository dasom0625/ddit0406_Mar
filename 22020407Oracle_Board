package k_jdbc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import e_oop.ScanUtil;
//데이터를 가져올것들을 한번에 가공해서 가져오는게 좋다. 
public class JDBCBoard {

	public static void main(String[] args) {
		// 1. 객체생성
		new JDBCBoard().start();

	}

	private void start() {
		
		while(true) {
		//1. 목록을 출력하기위한 쿼리 만들기
			String sql = "SELECT A.BOARD_NO "
					+ "         ,A.TITLE "
					+ "         ,B.MEM_NAME"
					+ "         ,TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
					+ "  FROM TB_JDBC_BOARD A "
					+ "  LEFT OUTER JOIN MEMBER B ON A.MEM_ID = B.MEM_ID"
					+ "  ORDER BY A.BOARD_NO DESC";
			List<Map<String,Object>> boardList = JDBCUtil.selectList(sql);
			
			System.out.println("========================================");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("----------------------------------------");
			
			for(Map<String, Object>board : boardList) {	//map은 출력 순서가 없기 때문에 boardList에 있는 내용을 새로운 변수 board에  순서대로 출력하기 위해 sysout사용 
				System.out.print(board.get("BOARD_NO")+"\t");
				System.out.print(board.get("TITLE")+"\t");
				System.out.print(board.get("MEM_NAME")+"\t");
				System.out.println(board.get("REG_DATE")+"\t");
				
			}
			System.out.println("=========================================");
			
			
			//2. 사용자에게 선택지 입력받기
			System.out.println("1.조회 2.등록 0.종료 > ");
			int input = ScanUtil.nextInt();
			switch(input) {
			//2-1.1번 누르면 조회
			case 1:
				//3. 화면만 출력해주면 되게 read안에 scanUtil넣기 
				System.out.println("조회할 게시물 번호 입력 > ");
				read(ScanUtil.nextInt());
			
//				if (read(ScanUtil.nextInt()) > JDBCBoard.size()) {
//					System.out.println("입력하신 번호의 게시글이 없습니다.");
//					break;
//		         }
//				
				
				break;
			case 2:
			//2-2.2번 누르면 등록
				insert();
				break;
			//2-3.0번 누르면 종료
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}
		}
	}
	
	//4.게시물 출력할 번호 만들기 => 맨위의 목록 쿼리 가져와서 수정.
	private void read(int boardNo) {
		String sql = "SELECT A.BOARD_NO "
				+ "         ,A.TITLE "
				+ "			,A.CONTENT"
				+ "         ,B.MEM_NAME"
				+ "         , TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
				+ "  FROM TB_JDBC_BOARD A"
				+ "  LEFT OUTER JOIN MEMBER B ON A.MEM_ID = B.MEM_ID"
				+ "  WHERE A.BOARD_NO = ?";//게시물 번호로 조회되게 WHERE절 추가
		//4-1 물음표에 들어갈 값 넣기
		List<Object>param = new ArrayList<Object>();
		param.add(boardNo);
		
		Map<String,Object> board = JDBCUtil.selectOne(sql,param);
		
		//4-2물음표 조회 완료했으니 출력하기
		System.out.println("==============================================");
		System.out.println("번호\t"+board.get("BOARD_NO"));
		System.out.println("작성자\t"+board.get("MEM_NAME"));
		System.out.println("작성일\t"+board.get("REG_DATE"));
		System.out.println("제목\t"+board.get("TITLE"));
		System.out.println("내용\t"+board.get("CONTENT"));
		System.out.println("==============================================");

		//5. 조회 후 수정 삭제 그리고 목록으로 돌아가는거 입력받기
		System.out.print("1.수정 2.삭제 0.목록 >");
		int input = ScanUtil.nextInt();
		switch(input) {
		//5-1 각각 맞는 메소드 넣어주기=>어떤걸수정하고 삭제할지 파라미터로 받아야하기때문에 게시물 번호를 파라미터로 설정
		case 1:
			update(boardNo);
			break;
		case 2:
			delete(boardNo);
			break;
		case 0:
			
			break;
		}
		
	}

	//5-2. 등록
	private void insert() {
		System.out.println("제목 >");
		String title = ScanUtil.nextLine();
		System.out.println("내용 >");
		String content = ScanUtil.nextLine();
		System.out.println("아이디 >");
		String memId = ScanUtil.nextLine();
	
		//5-3인서트 할 쿼리 만들기
		String sql = "INSERT INTO TB_JDBC_BOARD"
				+ "   VALUES("
				+ "        (SELECT NVL(MAX(BOARD_NO),0) + 1 FROM TB_JDBC_BOARD)" //게시물 번호 만들기=>게시물 번호의 최대값을 찾아서 1을 더해주는방식
																				//최대값이 없을때는 NULL이 나오기 때문에 NVL을 통해 0으로 바꿔줌.
				+ "        ,?,?,?, SYSDATE)"; //오늘날짜 입력받기위한 쿼리
		//5-4 ?에 들어갈 게시글 등록하기 
		List<Object>param = new ArrayList<Object>();
		param.add(title);
		param.add(content);
		param.add(memId);
		
		if(0 < JDBCUtil.update(sql,param)) {
			System.out.println("게시물 등록이 완료되었습니다.");
//			//8. 등록한 글을 볼 수 있게 쿼리 만들기(아래 세줄 써도 되고 안써도 되고...
//			sql = "SELECT MAX(BOARD_NO) AS BOARD_NO FROM TB_JDBC_BOARD";
//			Object boardNo = JDBCUtil.selectOne(sql).get("BOARD_NO");
//			read(((BigDecimal)boardNo).intValue());

			
		}else {
			System.out.println("게시글 등록에 실패하였습니다.");
		}
	}
	
	//6.수정
	//수정할 내용을 받은 다음 파라미터를 통해 
	private void update(int boardNo) {
	//6-1수정할 내용 입력받기
		System.out.println("제목 > ");
		String title  = ScanUtil.nextLine();
		System.out.println("내용 > ");
		String content  = ScanUtil.nextLine();
		
		//6-2업데이트한 내용
		String sql = "UPDATE TB_JDBC_BOARD"
				+ "			SET TITLE = ?"
				+ "				,CONTENT = ?"
				+ "			WHERE BOARD_NO = ?";
		
		//6-3
		List<Object> param = new ArrayList<Object>();
		param.add(title);
		param.add(content);
		param.add(boardNo);
		
		
		if(0<JDBCUtil.update(sql, param)) {
			System.out.println("게시글 수정이 완료되었습니다.");
			
		}else {
			System.out.println("게시글 수정에 실패하였습니다.");
		}
		
	}
	
	//7.삭제
	private void delete(int boardNo) {
		//7-1 삭제할건지 확인
		System.out.println("정말 삭제하시겠습니까? > ");
		if(ScanUtil.nextLine().equals("Y")) {
			//7-2 사용자가 Y누르면 삭제하게 쿼리 만들기
			String sql = "DELETE FROM TB_JDBC_BOARD"
					+ "		WHERE BOARD_NO = ?";
			List<Object>param = new ArrayList<Object>();
			param.add(boardNo);
			
			if(0<JDBCUtil.update(sql, param)) {
				System.out.println("게시글이 삭제되었습니다.");
			}else {
				System.out.println("게시글 삭제에 실패하였습니다.");
			}
		}
	}


}
