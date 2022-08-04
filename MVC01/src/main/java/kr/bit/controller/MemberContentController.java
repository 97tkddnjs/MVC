package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/**
 * Servlet implementation class MemberContentController
 */
@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {    
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao =new MemberDAO();
		MemberVO vo = dao.memberContent(num);
		
		response.setCharacterEncoding("UTF-8"); // ����ڿ��� �����ִ� �ڵ������ ������
		response.setContentType("text/html; charset=UTF-8");//����ڰ� ��� �ؼ��ϴ� ��
		PrintWriter out =response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='/MVC01/memberUpdate.do' method ='post'>");
		out.println("<input type='hidden' name='num' value='"+vo.getNum()+"'/>");
		out.println("<table>");
		if(vo !=null) {
			out.println("<tr>");
			out.println("<td colspan='2'>"+vo.getName()+" ȸ���� �󼼺��� </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>��ȣ</td>");
			out.println("<td>"+vo.getNum()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>���̵�</td>");
			out.println("<td>"+vo.getId()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>��й�ȣ</td>");
			out.println("<td>"+vo.getPass()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>�̸�</td>");
			out.println("<td>"+vo.getName()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>����</td>");
			out.println("<td><input type='text' name='age' value='"+vo.getAge()+"'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>�̸���</td>");
			out.println("<td><input type='text' name='email' value='"+vo.getEmail()+"'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>��ȭ��ȣ</td>");
			out.println("<td><input type='text' name='phone' value='"+vo.getPhone()+"'/></td>");
			out.println("</tr>");
			
		}else {
			out.println("<tr>");
			out.println("<td>��ġ�ϴ� ȸ���� �����ϴ�.</td>");
			out.println("</tr>");
		}
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type='submit' value='�����ϱ�'/>");
		out.println("<input type='reset' value='���'/>");
		out.println("<a href='/MVC01/memberList.do'>����Ʈ</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
