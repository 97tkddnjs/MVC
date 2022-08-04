package kr.bit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // 
		// 파라메터 수집(VO)
		int num = Integer.parseInt(request.getParameter("num"));
		int age =Integer.parseInt(request.getParameter("age"));
		String phone= request.getParameter("phone");
		String email=  request.getParameter("email");
		
		
		MemberVO vo =new MemberVO();
		vo.setNum(num);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		MemberDAO dao =new MemberDAO();
		int cnt =dao.memberUpdate(vo);
		
		if(cnt>0) {
			// success
			//out.println("insert success"); 	//다시 회원리스트 보기로 가야된다.(/MVC01/memberList.do)
			response.sendRedirect("/MVC01/memberList.do");
		}else {
			//fail make exception
			throw new ServletException("not update");
		}
		
		
	}

}
