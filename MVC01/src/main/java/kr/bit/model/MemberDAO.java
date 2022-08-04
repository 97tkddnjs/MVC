package kr.bit.model;
//JDBC -> myBatis, JPA �Ѿ...
import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
	private Connection conn;// DB�� ����
	private PreparedStatement ps;//sql�� ������ �� �ִ� ��ü
	private ResultSet rs;//DB���� �޾ƿ� �� �����ϴ� ��ü
	
	//������ ���̽� ���� ��ü ����
	public void getConnect() {
		//������ ���̽� ���� URL;
		String URL="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimeZone=UTC";
		String user ="root";
		String password ="1234";
		
		//MySQL Driver�� �޸𸮿� Loading�� �Ǿ�� DB���� ��밡��
		
		try {
			//lib���� ã�´�~ �޸𸮿� �ε� ��Ŵ~���� �ε�
			//�����ε�(����������� ��ü�� �����ϴ� ���)
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL,user, password);//Driver �����ϴ� �޴���~
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	//ȸ�� ���� ����
	public int memberInsert(MemberVO vo ) {
		//																?(�Ķ����) 1,2,3,4,5,6
		String SQL= "insert into member(id, pass,name, age, email,phone) values(?,?,?,?,?,?)";
		getConnect();
		//SQL ������ �����ϴ� ��ü�� ����
		int cnt=-1;
		try {
			ps =conn.prepareStatement(SQL); //�ϴ� �ҿ����� SQL�� ������ ���� �̸� ������ ��Ű����(�ӵ��� ������ ������)
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			
			// ������ �� ��ȯ ���н� 0
			cnt=ps.executeUpdate(); // ����(����) 
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return cnt;
	}
	// ȸ��(VO) ��ü ����Ʈ(ArrayList) ��������
	public ArrayList<MemberVO> memberList() {
		String SQL ="select * from member";
		getConnect();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>(); 
		
		try {
			ps=conn.prepareStatement(SQL);
			rs= ps.executeQuery(); // rs �� ����� ����Ű�� Ŀ��. �÷� �� ����Ų�ٰ� ���� ��
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
	
	// �����ϱ�
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
	// �� ����
	public MemberVO memberContent(int num) {
		String SQL = "select * from member where num=?";
		getConnect();
		MemberVO vo =null;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			rs=ps.executeQuery();
			
			
			if(rs.next()) {
				//ȸ�� �Ѹ��� ������ �����ͼ� -> ����(VO)
				
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
	
	
	// ������ ���̽� ���� ����
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
