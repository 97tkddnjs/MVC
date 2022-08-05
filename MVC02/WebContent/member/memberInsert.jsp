<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*"  %>
<%
		//파라메터 정보 수집(VO)
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
		
		MemberDAO dao= new MemberDAO();
		int cnt =dao .memberInsert(vo);
		//	PrintWriter out = response.getWriter();
		if(cnt>0) {
			// success
			//out.println("insert success"); 	//다시 회원리스트 보기로 가야된다.(/MVC01/memberList.do)
			response.sendRedirect("memberList.jsp");
		}else {
			//fail make exception
			throw new ServletException("not insert");
		}
		
		
%>
