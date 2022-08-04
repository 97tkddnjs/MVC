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
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8"); // 
		response.setCharacterEncoding("UTF-8"); // 사용자에게 보내주는 코딩방식을 결정함
		response.setContentType("text/html; charset=UTF-8");//사용자가 어떻게 해석하는 지
		
		// 1. 파라메터 수집 (VO)
		String id =request.getParameter("id");
		String pass =request.getParameter("pass");
		String name =request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email =request.getParameter("email");
		String phone =request.getParameter("phone");
		//String id =request.getParameter("id");
		
		//MemberVO vo =new MemberVo(id,pass,name,age,email,phone);
		//파라미터 수집은 setter를 통해 하는 것이다.
		MemberVO vo =new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		System.out.println(vo);
		
		//Model에 대한것
		
		MemberDAO dao= new MemberDAO();
		int cnt =dao .memberInsert(vo);
		PrintWriter out = response.getWriter();
		if(cnt>0) {
			// success
			//out.println("insert success"); 	//다시 회원리스트 보기로 가야된다.(/MVC01/memberList.do)
			response.sendRedirect("/MVC01/memberList.do");
		}else {
			//fail make exception
			throw new ServletException("not insert");
		}
	}

}
