package kr.bit.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Ŭ���̾�Ʈ�� � ��û�� �ߴ� �� �ľ��ϱ�
		String url = request.getRequestURI();
		System.out.println(url);
		
		String ctx = request.getContextPath();
		
		// ������ ��û�� ����� �������� �ľ�!
		String command = url.substring(ctx.length());
		
		// ��û�� ���� �б��۾�
		if(command.equals("/memberList.do")) { // ȸ������Ʈ ����
			MemberDAO dao =new MemberDAO();
			List<MemberVO> list =dao.memberList();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
			rd.forward(request, response);
			
		}else if(command.equals("/memberInsert.do")) { // ȸ������
			
		}else if(command.equals("/memberRegister.do")) { // ȸ������ ȭ��
			
		}else if(command.equals("/memberContent.do")) { // ȸ�� �󼼺��� ���
			
		}else if(command.equals("/memberUpdate.do")) { // ȸ�� ����
			
		}else if(command.equals("/memberDelete.do")) { // ȸ�� ����
			
		}// if end

		
	}

}
