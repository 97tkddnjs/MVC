package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MyCalc;

/**
 * Servlet implementation class CalcController
 */
//Controller ����
@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Ŭ���̾�Ʈ���� �Ѿ���� �� �Ķ���͸� �ޱ�(�Ķ���� ����, su1, su2)
		// post�� ���� ������ �����ʹ� request �� ���� �޾����� �Ǵ� �� ���⼭ ������ �ȴ�.
		int su1 =Integer.parseInt(request.getParameter("su1"));
		int su2 =Integer.parseInt(request.getParameter("su2"));
		
		//su1~su2 ="
		//����Ͻ����� --> Model�� �и�
		/*
		 * int sum=0; for(int i=su1; i<=su2;i++) sum+=i;
		 */
		MyCalc my =new MyCalc();
		int sum = my.hap(su1,su2);
		
		//�����ϴ� �κ�(���������̼� ����=View=JSP)
		PrintWriter out =response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td> total </td>");
		out.println("<td>");
		out.println(sum);
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
