package kr.bit.model;
// JDBC->myBatis, JPA
import java.sql.*;
import java.util.ArrayList;
public class MemberDAO {
   private Connection conn;
   private PreparedStatement ps;
   private ResultSet rs;
   
   // �뜲�씠�꽣踰좎씠�뒪 �뿰寃곌컼泥� �깮�꽦(Connection)
   public void getConnect() {
	   //�뜲�씠�꽣踰좎씠�뒪�젒�냽URL
	   String URL="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimeZone=UTC";
	   String user="root";
	   String password="1234";
	   // MySQL Driver Loading
	  try {
 		  //�룞�쟻濡쒕뵫(�떎�뻾�떆�젏�뿉�꽌 媛앹껜瑜� �깮�꽦�븯�뒗 諛⑸쾿)
		  Class.forName("com.mysql.cj.jdbc.Driver");		  
		  conn=DriverManager.getConnection(URL, user, password);
	   } catch (Exception e) {
		  e.printStackTrace();
	  }		   
   }   
   // �쉶�썝���옣 �룞�옉
   public int memberInsert(MemberVO vo) {
	  //                                                             ?(�뙆�씪硫뷀꽣) 1 2 3 4 5 6   
	  String SQL="insert into member(id, pass, name, age, email, phone) values(?,?,?,?,?,?)"; 
	  getConnect();
	  // SQL臾몄옣�쓣 �쟾�넚�븯�뒗 媛앹껜 �깮�꽦
	  int cnt=-1;
	  try {
		ps=conn.prepareStatement(SQL); //誘몃━ 而댄뙆�씪�쓣 �떆�궓�떎.(�냽�룄媛�鍮좊Ⅴ湲�)
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPass());
		ps.setString(3, vo.getName());
		ps.setInt(4, vo.getAge());
		ps.setString(5, vo.getEmail());
		ps.setString(6, vo.getPhone());
		//  1,0
		cnt=ps.executeUpdate(); //�쟾�넚(�떎�뻾)
		
	   }catch (Exception e) {
		e.printStackTrace();
	   }finally {
		   dbClose();
	  }
	  return cnt; // 1 or 0
   }
   // �쉶�썝(VO)�쟾泥� 由ъ뒪�듃(ArrayList) 媛��졇�삤湲�
   public ArrayList<MemberVO> memberList() {
	 String SQL="select * from member";
	 getConnect();
	 ArrayList<MemberVO> list=new ArrayList<MemberVO>();
	 try {
	   ps=conn.prepareStatement(SQL);
	   rs=ps.executeQuery(); // rs->而ㅼ꽌
	   while(rs.next()) {
		   int num=rs.getInt("num");
		   String id=rs.getString("id");
		   String pass=rs.getString("pass");
		   String name=rs.getString("name");		   
		   int age=rs.getInt("age");
		   String email=rs.getString("email");
		   String phone=rs.getString("phone");
		   // 臾띔퀬->�떞怨�
		   MemberVO vo=new MemberVO(num, id, pass, name, age, email, phone);
		   list.add(vo);		   
	   }
	 } catch (Exception e) {
       e.printStackTrace();
	 }finally {
		dbClose();
	 }	 
	 return list;
   }//memberList
   public int memberDelete(int num) {
	 String SQL="delete from member where num=?";
	 getConnect();
	 int cnt=-1;
	 try {
	   ps=conn.prepareStatement(SQL);
	   ps.setInt(1, num);
	   cnt=ps.executeUpdate();// 1 or 0	   
	 } catch (Exception e) {
		e.printStackTrace();
	 }finally {
		dbClose();
	}	   
	 return cnt;
   }//memberDelete
   public MemberVO memberContent(int num) {
	   String SQL="select * from member where num=?";
	   getConnect();
	   MemberVO vo=null;
	   try {
		 ps=conn.prepareStatement(SQL);
		 ps.setInt(1, num);
		 rs=ps.executeQuery();
		 if(rs.next()) {
			 //�쉶�썝�븳紐낆쓽 �젙蹂대�� 媛��졇���꽌->臾띔퀬(VO)
			   num=rs.getInt("num");
			   String id=rs.getString("id");
			   String pass=rs.getString("pass");
			   String name=rs.getString("name");		   
			   int age=rs.getInt("age");
			   String email=rs.getString("email");
			   String phone=rs.getString("phone");
			   vo=new MemberVO(num, id, pass, name, age, email, phone);
		 }
	   } catch (Exception e) {
		 e.printStackTrace();
	   }finally {
		  dbClose();
	   }	
	   return vo;
   }
   public int memberUpdate(MemberVO vo) {
	   String SQL="update member set age=?, email=?, phone=? where num=?";
	   getConnect();
	   int cnt=-1;
	   try {
	   	ps=conn.prepareStatement(SQL);
	   	ps.setInt(1, vo.getAge());
	   	ps.setString(2, vo.getEmail());
	   	ps.setString(3, vo.getPhone());
	   	ps.setInt(4, vo.getNum());	   	
	   	cnt=ps.executeUpdate();	   	
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		dbClose();
	}	   
	   return cnt;
   }
   // �뜲�씠�꽣踰좎씠�뒪 �뿰寃� �걡湲�
   public void dbClose() {
	  try { 
	   if(rs!=null) rs.close();
	   if(ps!=null) ps.close();
	   if(conn!=null) conn.close();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
   }   
}


