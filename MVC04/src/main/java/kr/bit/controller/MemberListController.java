package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,  IOException{
		
		//POJO 가 해야 할 일의 범위!
		// 1. Model 의 연동
		MemberDAO dao =new MemberDAO();
		List<MemberVO> list =dao.memberList();
		
		//2. 객체 바인딩
		request.setAttribute("list", list);
		//3. 다음 페이지정보는 (view)
		return "/WEB-INF/member/memberList.jsp";
		
	}
}
