package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//select, insert,update, delete사용하기
public class JDBC3 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pc11";
		String password = "java";
		
		Connection con = null; //자바와 오라클 연결
		PreparedStatement ps = null; //쿼리 작성
		ResultSet rs = null; // 결과를 넣는 주머니
		
		System.out.println("ORDER_NO\tORDER_ID\tPRODUCT_CODE\tCSEL\tCMONEY\tCDATE\tMDATE\tGUBUN");
		//1. 연결 - DriverManager.getConnection(url,user,password)
		try {
			con = DriverManager.getConnection(url,user,password);
		
		//2. select 쿼리작성
		String sql = "select* from empty_order";
		
		ps=con.prepareStatement(sql);
		rs = ps.executeQuery(); //select쿼리 조회 결과
		
		//3. for문 이용해서 컬럼수만큼 값 꺼내오기
		//3-1) 메타데이터 임포트
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount(); 

		while (rs.next()) {
			for(int i =1 ; i<columnCount; i++) {
				rs.getObject(i);
				System.out.print(rs.getObject(i)+"\t");
			}
			System.out.println();
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //try-catch문 닫아주기
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(ps!=null) try {ps.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
		
////////////////////////////////////////////////////////////////////////////////////
		//INSERT사용하기
		
		//1. 연결 - DriverManager.getConnection(url,user,password)
		try {
			con = DriverManager.getConnection(url,user,password);
		
		//2. select가 아니므로, 아래와 같이 작성
		String sql = "insert into empty_order"
					+ "(order_no,order_id,product_code,order_qty,csel,cmoney,cdate,mdate,gubun)"
					+ " values('20220406','yyddss','cm01','3','계좌','380000','20220406','20220406','완료')";
		
		ps=con.prepareStatement(sql);
		
		//INSERT사용할때 결과 값 저장.
		int result = ps.executeUpdate(); //select쿼리 조회 결과
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //try-catch문 닫아주기
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(ps!=null) try {ps.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
////////////////////////////////////////////////////////////////////////////////////
		//UPDATE사용하기
		try {
			con = DriverManager.getConnection(url,user,password);
		
		//2. select 쿼리작성
		String sql = "update empty_order set gubun = '미결' where gubun is null";
		
		ps=con.prepareStatement(sql);
		
		//INSERT사용할때 결과 값 저장.
		int result = ps.executeUpdate(); //select쿼리 조회 결과
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //try-catch문 닫아주기
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(ps!=null) try {ps.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
		
////////////////////////////////////////////////////////////////////////////////////
//DELETE 사용하기
		try {
			con = DriverManager.getConnection(url,user,password);

//2. select 쿼리작성
			String sql = "delete from empty_order where order_no = '20220406'";

			ps=con.prepareStatement(sql);

//INSERT사용할때 결과 값 저장.
			int result = ps.executeUpdate(); //select쿼리 조회 결과

		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //try-catch문 닫아주기
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(ps!=null) try {ps.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}

	}
}
	
	

