package kr.bit.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.controller.Controller;
import kr.bit.controller.*;
import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 클라이언트가 어떤 요청을 했는 지 파악하기
		String url = request.getRequestURI();
		System.out.println(url);
		
		String ctx = request.getContextPath();
		
		// 실제로 요청한 명령이 무엇인지 파악!
		String command = url.substring(ctx.length());
		
		Controller controller= null;
		String nextPage;
		// 요청에 따른 분기작업
		if(command.equals("/memberList.do")) { // 회원리스트 보기
			controller=new MemberListController();
			nextPage=controller.requestHandler(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
			
		}else if(command.equals("/memberInsert.do")) { // 회원가입
			controller=new MemberInsertController();
			nextPage=controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
			
		}else if(command.equals("/memberRegister.do")) { // 회원가입 화면
			controller=new MemberRegisterController();
			nextPage=controller.requestHandler(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
			
		}else if(command.equals("/memberContent.do")) { // 회원 상세보기 목록
			
			controller=new MemberContentController();
			nextPage=controller.requestHandler(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
			
		}else if(command.equals("/memberUpdate.do")) { // 회원 수정
			
			controller=new MemberUpdateController();
			nextPage=controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
			
		}else if(command.equals("/memberDelete.do")) { // 회원 삭제
			
			controller=new MemberDeleteController();
			nextPage=controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
			
		}// if end

		
	}

}
