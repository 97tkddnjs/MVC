package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberInsertController implements Controller {
	
	@Override
	public String requestHandler(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,  IOException{
		String ctx = request.getContextPath(); //MVC04~~
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age")); // "40"->40
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		MemberVO vo=new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		System.out.println(vo); // vo.toString()
		// Model
	    MemberDAO dao=new MemberDAO();
	    int cnt=dao.memberInsert(vo);
	    //PrintWriter out=response.getWriter();
	    
	    String nextPage = null;
	    if(cnt>0) {
	    	// 
	        //out.println("insert success");	// 
	    	nextPage = "redirect:"+ctx+"/memberList.do";
	    }else {
	    	//
	    	throw new ServletException("not insert");	    	
	    }
		return nextPage;
	}

}
