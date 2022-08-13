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
@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			                                   throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//�뙆�씪硫뷀꽣 �닔吏�(VO)
		int num=Integer.parseInt(request.getParameter("num"));
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		MemberVO vo=new MemberVO();
		vo.setNum(num);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		MemberDAO dao=new MemberDAO();
		int cnt=dao.memberUpdate(vo);
		if(cnt>0) {
		    	// 媛��엯�꽦怨�		        
		    	response.sendRedirect("/MVC03/memberList.do");
		 }else {
		    	// 媛��엯�떎�뙣-> �삁�쇅媛앹껜瑜� 留뚮뱾�뼱�꽌  WAS�뿉寃� �뜕吏��옄.
		    	throw new ServletException("not update");	    	
		 }	
	}
}
