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
@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			                                          throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 1. �뙆�씪硫뷀꽣�닔吏�(VO)
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age")); // "40"->40
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		//�뙆�씪硫뷀꽣�닔吏�(VO)
		//MemberVO vo=new MemberVO(id, pass, name, age, email, phone);
		MemberVO vo=new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		//System.out.println(vo); // vo.toString()
		// Model怨� �뿰�룞遺�遺�
	    MemberDAO dao=new MemberDAO();
	    int cnt=dao.memberInsert(vo);
	    //PrintWriter out=response.getWriter();
	    if(cnt>0) {
	    	// 媛��엯�꽦怨�
	        //out.println("insert success");	// �떎�떆 �쉶�썝由ъ뒪�듃 蹂닿린濡� 媛��빞�맂�떎.(/MVC01/memberList.do)
	    	response.sendRedirect("/MVC03/memberList.do");
	    }else {
	    	// 媛��엯�떎�뙣-> �삁�쇅媛앹껜瑜� 留뚮뱾�뼱�꽌  WAS�뿉寃� �뜕吏��옄.
	    	throw new ServletException("not insert");	    	
	    }		
	}
}
