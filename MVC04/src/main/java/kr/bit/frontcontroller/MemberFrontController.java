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
		String nextPage =null;
		// 요청에 따른 분기작업
		// 핸들러 매핑 -> 경로에 대한 핸들러 매핑을 말한다. ->HandlerMapping을 통해서 새롭게 받도록 하려고 함!
		
		HandlerMapping mapping =new HandlerMapping();
		controller=mapping.getController(command);
		nextPage = controller.requestHandler(request, response);
		
		
		// forward , redirect
		if(nextPage !=null)
		{
			if(nextPage.indexOf("redirect:")!=-1) {
				response.sendRedirect(nextPage.split(":")[1]); //redirect
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(request, response);
			}
		}

		
	}

}
