package kr.bit.model;
//JDBC -> myBatis, JPA 넘어감...
import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
	private Connection conn;// DB에 연결
	private PreparedStatement ps;//sql을 전송할 수 있는 객체
	private ResultSet rs;//DB에서 받아온 값 저장하는 객체
	
	//데이터 베이스 연결 객체 생성
	public void getConnect() {
		//데이터 베이스 접속 URL;
		String URL="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimeZone=UTC";
		String user ="root";
		String password ="1234";
		
		//MySQL Driver가 메모리에 Loading이 되어야 DB에서 사용가능
		
		try {
			//lib에서 찾는다~ 메모리에 로딩 시킴~동적 로딩
			//동적로딩(실행시점에서 객체를 생성하는 방법)
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL,user, password);//Driver 관리하는 메니저~
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	//회원 저장 동작
	public int memberInsert(MemberVO vo ) {
		//																?(파라메터) 1,2,3,4,5,6
		String SQL= "insert into member(id, pass,name, age, email,phone) values(?,?,?,?,?,?)";
		getConnect();
		//SQL 문장을 전송하는 객체를 생성
		int cnt=-1;
		try {
			ps =conn.prepareStatement(SQL); //일단 불완정한 SQL을 보내는 이유 미리 컴파일 시키려고(속도가 빠르기 때문에)
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			
			// 성송한 수 반환 실패시 0
			cnt=ps.executeUpdate(); // 전송(실행) 
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return cnt;
	}
	// 회원(VO) 전체 리스트(ArrayList) 가져오기
	public ArrayList<MemberVO> memberList() {
		String SQL ="select * from member";
		getConnect();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>(); 
		
		try {
			ps=conn.prepareStatement(SQL);
			rs= ps.executeQuery(); // rs 이 결과를 가리키는 커서. 컬럼 쪽 가리킨다고 보면 됨
			while(rs.next())
			{
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				
				MemberVO vo = new MemberVO(num,id, pass,name, age, email,phone);
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			 dbClose();
		}
		return list;
	}
	
	// 삭제하기
	public int memberDelete(int num) {
		String SQL = "delete from member where num=?";
		getConnect();
		int cnt=-1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			cnt=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return cnt;
		
	}
	// 상세 보기
	public MemberVO memberContent(int num) {
		String SQL = "select * from member where num=?";
		getConnect();
		MemberVO vo =null;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			rs=ps.executeQuery();
			
			
			if(rs.next()) {
				//회원 한명의 정보를 가져와서 -> 묶고(VO)
				
				num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				vo = new MemberVO(num,id, pass,name, age, email,phone);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return vo;
		
	}
	
	public int memberUpdate(MemberVO vo) {
		String SQL ="update member set age=?, email=?, phone=? where num=?";
		getConnect();
		int cnt =-1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, vo.getAge());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getPhone());
			ps.setInt(4, vo.getNum());
			
			cnt=ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return cnt;
	}
	
	
	// 데이터 베이스 연결 끊기
	public void dbClose() {
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
