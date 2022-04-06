package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "pc11";
	private static String password = "java";
	
	//1. 변수에 제어자 붙이기
	private static Connection con = null; //자바와 오라클 연결
	private static PreparedStatement ps = null; //쿼리 작성
	private static ResultSet rs = null; // 결과를 넣는 주머니
	
	/*
	 * Map<String, Object> selectOne(String sql) : 쿼리안에 물음표 없다는 의미
	 * Map<String, Object> selectOne(String sql, List<Object>param) : 쿼리안에 물음표가 있다는 의미 / 파라미터 안에 물음표의 값을 같이 넘기는것.
	 * =>selectOne : select의 결과가 한줄로 예상될때 사용
	 * 
	 * List<Map<String,Object>> selectList(String sql)
	 * List<Map<String,Object>> selectList(String sql,List(Object> param)
	 * =>select의 결과가 여러줄로 예상될때 사용/ 그래서 map에 담아서 보여줌
	 * 
	 * int update(String sql)
	 * int update(String sql, List<object> param)
	 * =>select를 제외한 나머지에 메서드 사용 / 몇개의 행이 영향을 받았는지 리턴해줌.
	 * 
	 */

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//1.Map<String, Object> selectOne(String sql) 사용하기
	public static Map<String, Object> selectOne(String sql){ //파라미터로 쿼리가 넘어왔을떄, 그걸 실행해서 결과를 리턴해주면 됨.
		Map<String,Object> map = null;
		
		//리턴할 내용
		try {
			con = DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData =rs.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			//쿼리 조회해서  hashmap에 담기 
			while (rs.next()) {
				map = new HashMap<String, Object>();//결과를 HashpMap에 담기위해 HashMap을 만들었음.
				for(int i = 1 ; i<= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i)); //getColumnName이 컬럼명 , getObject가 컬럼값
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { //try-catch문 닫아주기
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(ps!=null) try {ps.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		return map;
	}
	

///////////////////////////////////////////////////////////////////////////////////////////////////
//2. Map<String, Object> selectOne(String sql, List<Object>param) : 쿼리안에 물음표가 있다는 의미 / 파라미터 안에 물음표의 값을 같이 넘기는것.
	
	public static Map<String, Object> selectOne(String sql, List<Object>param){ //파라미터로 쿼리가 넘어왔을떄, 그걸 실행해서 결과를 리턴해주면 됨.
			Map<String,Object> map = null;
			
			//리턴할 내용
			try {
				con = DriverManager.getConnection(url,user,password);
				
				//물음표를 세팅하는 방법//////////////////////////
				ps = con.prepareStatement(sql);
				for(int i =0 ; i<param.size(); i++) {
					ps.setObject(i+1, param.get(i));
				}
				/////////////////////////////////////////
				
				rs = ps.executeQuery();
				
				ResultSetMetaData metaData =rs.getMetaData();
				
				int columnCount = metaData.getColumnCount();
				
				//쿼리 조회해서  hashmap에 담기 
				while (rs.next()) {
					map = new HashMap<String, Object>();//결과를 HashpMap에 담기위해 HashMap을 만들었음.
					for(int i = 1 ; i<= columnCount; i++) {
						map.put(metaData.getColumnName(i), rs.getObject(i)); //getColumnName이 컬럼명 , getObject가 컬럼값
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally { //try-catch문 닫아주기
				if(rs!=null) try {rs.close();}catch(Exception e) {}
				if(ps!=null) try {ps.close();}catch(Exception e) {}
				if(con!=null) try {con.close();}catch(Exception e) {}
			}
			return map;
		}
	
////////////////////////////////////////////////////////////////////////////////////////
//3.List<Map<String,Object>> selectList(String sql)	통해서 여러개의 결과값 받아오기
		
			public static List<Map<String, Object>> selectList(String sql){ 
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				
				//리턴할 내용
				try {
					con = DriverManager.getConnection(url,user,password);
					
					ps = con.prepareStatement(sql);
					
					rs = ps.executeQuery();
					
					ResultSetMetaData metaData =rs.getMetaData();
					
					int columnCount = metaData.getColumnCount();
					
					//쿼리 조회해서  hashmap에 담기 
					while (rs.next()) {
						HashMap<String, Object> map = new HashMap<String, Object>();//결과를 HashpMap에 담기위해 HashMap을 만들었음.
						for(int i = 1 ; i<= columnCount; i++) {
							map.put(metaData.getColumnName(i), rs.getObject(i)); //getColumnName이 컬럼명 , getObject가 컬럼값
						}
						list.add(map);//어레이리스트에 값을 저장
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally { //try-catch문 닫아주기
					if(rs!=null) try {rs.close();}catch(Exception e) {}
					if(ps!=null) try {ps.close();}catch(Exception e) {}
					if(con!=null) try {con.close();}catch(Exception e) {}
				}
				return list; //arraylist리턴
			}
/////////////////////////////////////////////////////////////////////////////////////////////////////		
//4. List<Map<String,Object>> selectList(String sql,List(Object> param) : 쿼리에 물음표가 잇는지 없는지 확인
			
			public static List<Map<String, Object>> selectList(String sql, List<Object> param){ 
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				
				//리턴할 내용
				try {
					con = DriverManager.getConnection(url,user,password);
					
					//물음표///////////////////////////////////
					ps = con.prepareStatement(sql);
					for(int i = 0 ; i<param.size(); i++) {
						ps.setObject(i+1, param.get(i));
					}
					////////////////////////////////////////
					
					rs = ps.executeQuery();
					
					ResultSetMetaData metaData =rs.getMetaData();
					
					int columnCount = metaData.getColumnCount();
					
					//쿼리 조회해서  hashmap에 담기 
					while (rs.next()) {
						HashMap<String, Object> map = new HashMap<String, Object>();//결과를 HashpMap에 담기위해 HashMap을 만들었음.
						for(int i = 1 ; i<= columnCount; i++) {
							map.put(metaData.getColumnName(i), rs.getObject(i)); //getColumnName이 컬럼명 , getObject가 컬럼값
						}
						list.add(map);//어레이리스트에 값을 저장
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally { //try-catch문 닫아주기
					if(rs!=null) try {rs.close();}catch(Exception e) {}
					if(ps!=null) try {ps.close();}catch(Exception e) {}
					if(con!=null) try {con.close();}catch(Exception e) {}
				}
				return list; //arraylist리턴
			}
///////////////////////////////////////////////////////////////////////////////////////////////
//5. int update(String sql)사용하기 => select를 제외한 나머지 메소드에 사용하기
			
			
			//쿼리를 실행한다음에 int타입을 반환
			public static int upadate(String sql){ 
			int result = 0;
		
			//리턴할 내용
				try {
					con = DriverManager.getConnection(url,user,password);
					
					ps = con.prepareStatement(sql);
					
					//실행하는 메소드////////////////////////
					result = ps.executeUpdate();
					////////////////////////////////////
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally { //try-catch문 닫아주기
					if(rs!=null) try {rs.close();}catch(Exception e) {}
					if(ps!=null) try {ps.close();}catch(Exception e) {}
					if(con!=null) try {con.close();}catch(Exception e) {}
				}
				return result; //arraylist리턴
		
			}
///////////////////////////////////////////////////////////////////////////////////////////////
//6. int update(String sql, List<object> param) =>select를 제외한 나머지 메소드의 여러행 받아올때 
			public static int upadate(String sql,List<Object> param){ 
				int result = 0;
			
				//리턴할 내용
					try {
						con = DriverManager.getConnection(url,user,password);
						
						//물음표//////////////////////////////
						ps = con.prepareStatement(sql);
						for(int i=0; i<param.size(); i++) {
							ps.setObject(i+1, param.get(i));
						}
						////////////////////////////////////
						//실행하는 메소드////////////////////////
						result = ps.executeUpdate();
						////////////////////////////////////
						
						
					} catch (SQLException e) {
						e.printStackTrace();
					}finally { //try-catch문 닫아주기
						if(rs!=null) try {rs.close();}catch(Exception e) {}
						if(ps!=null) try {ps.close();}catch(Exception e) {}
						if(con!=null) try {con.close();}catch(Exception e) {}
					}
					return result; //arraylist리턴
				}
			


}
	


