package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Ŭ���̾�Ʈ�� ��û �ޱ�(memberList.do)
		//2. ȸ�� ��ü ����Ʈ �������� (Model ����)
		MemberDAO dao =new MemberDAO();
		ArrayList<MemberVO> list = dao.memberList();
		
		//3. ȸ�� ��ü����Ʈ�� HTML�� ���� �����ϱ�.
		//System.out.println(list);
		
		response.setCharacterEncoding("UTF-8"); // ����ڿ��� �����ִ� �ڵ������ ������
		response.setContentType("text/html; charset=UTF-8");//����ڰ� ��� �ؼ��ϴ� ��
		
		PrintWriter out = response.getWriter();
//		request.setCharacterEncoding("UTF-8"); // 
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>��ȣ</th>");
		out.println("<th>���̵�</th>");
		out.println("<th>��й�ȣ</th>");
		out.println("<th>�̸�</th>");
		out.println("<th>����</th>");
		out.println("<th>�̸���</th>");
		out.println("<th>��ȭ��ȣ</th>");
		out.println("<th>����</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(MemberVO vo :list) {
			out.println("<tr>");
		    out.println("<td>"+vo.getNum() +"</td>");
		    out.println("<td><a href='/MVC01/memberContent.do?num="+vo.getNum()+"'>"+vo.getId() +"</td>");
		    out.println("<td>"+vo.getPass() +"</td>");
		    out.println("<td>"+vo.getName() + "</td>");
		    out.println("<td>"+ vo.getAge() +"</td>");
		    out.println("<td>"+vo.getEmail() +"</td>");
		    out.println("<td>"+vo.getPhone() +"</td>");
		    out.println("<th><a href='/MVC01/memberDelete.do?num="+vo.getNum()+"'>����</a></th>");
		    out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("<tr>");
		out.println("<td colspan='8'>");
		out.println("<a href='member/memberRegister.html'>ȸ������</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
