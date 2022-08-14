package kr.bit.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// 클라이언트가 어떤 요청을 했는 지 파악하기
		String url = request.getRequestURI();
		System.out.println(url);
		
		String ctx = request.getContextPath();
		
		// 실제로 요청한 명령이 무엇인지 파악!
		String command = url.substring(ctx.length());
		
		// 요청에 따른 분기작업
		if(command.equals("/memberList.do")) { // 회원리스트 보기
			MemberDAO dao =new MemberDAO();
			List<MemberVO> list =dao.memberList();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
			rd.forward(request, response);
			
		}else if(command.equals("/memberInsert.do")) { // 회원가입
			
		}else if(command.equals("/memberRegister.do")) { // 회원가입 화면
			
		}else if(command.equals("/memberContent.do")) { // 회원 상세보기 목록
			
		}else if(command.equals("/memberUpdate.do")) { // 회원 수정
			
		}else if(command.equals("/memberDelete.do")) { // 회원 삭제
			
		}// if end

		
	}

}
