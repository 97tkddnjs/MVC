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
		
		//POJO �� �ؾ� �� ���� ����!
		// 1. Model �� ����
		MemberDAO dao =new MemberDAO();
		List<MemberVO> list =dao.memberList();
		
		//2. ��ü ���ε�
		request.setAttribute("list", list);
		//3. ���� ������������ (view)
		return "/WEB-INF/member/memberList.jsp";
		
	}
}
