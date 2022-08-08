package kr.bit.forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardController
 */

@WebServlet("/rc.do")
public class RedirectController extends HttpServlet {
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.forward �ǽ�
		
		String data="apple";
		// view page(result.jsp)�� data �����Ͽ� View page���� ���
		// Controller ���� View�� �������� ��ȯ�ϴ� ���
		// 1. redirect
		// 2. forward
		request.setAttribute("data", data);	//��ü ���ε�
		response.sendRedirect("view/result.jsp");
		
	}

}
