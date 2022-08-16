package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class MemberDeleteController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request,HttpServletResponse response) throws ServletException,  IOException
	{
		// http://127.0.0.1:8081/MVC01/memberDelete.do?num=7
					int num=Integer.parseInt(request.getParameter("num"));
					
					MemberDAO dao=new MemberDAO();
					int cnt=dao.memberDelete(num);
					
					String nextPage =null;
					if(cnt>0) {
						nextPage="/MVC04/memberList.do";
					}else {
						throw new ServletException("not delete");	
					}
					return nextPage;
	}

}
