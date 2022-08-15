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
		
		request.setCharacterEncoding("UTF-8");
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
		    if(cnt>0) {
		    	// 
		        //out.println("insert success");	// 
		    	response.sendRedirect("/MVC04/memberList.do");
		    }else {
		    	//
		    	throw new ServletException("not insert");	    	
		    }
			
			
		}else if(command.equals("/memberRegister.do")) { // 회원가입 화면
			
			RequestDispatcher rd = request.getRequestDispatcher("member/memberRegister.html");
			rd.forward(request, response);
			
		}else if(command.equals("/memberContent.do")) { // 회원 상세보기 목록
			
			int num=Integer.parseInt(request.getParameter("num"));
			
			MemberDAO dao=new MemberDAO();
			MemberVO vo=dao.memberContent(num);
			
			//객체 바인딩
			request.setAttribute("vo",vo);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberContent.jsp");
			rd.forward(request, response);
			
		}else if(command.equals("/memberUpdate.do")) { // 회원 수정
			
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
			    	response.sendRedirect("/MVC04/memberList.do");
			 }else {
			    	// 媛��엯�떎�뙣-> �삁�쇅媛앹껜瑜� 留뚮뱾�뼱�꽌  WAS�뿉寃� �뜕吏��옄.
			    	throw new ServletException("not update");	    	
			 }	
			
		}else if(command.equals("/memberDelete.do")) { // 회원 삭제
			
			// http://127.0.0.1:8081/MVC01/memberDelete.do?num=7
			int num=Integer.parseInt(request.getParameter("num"));
			
			MemberDAO dao=new MemberDAO();
			int cnt=dao.memberDelete(num);
			if(cnt>0) {
				response.sendRedirect("/MVC04/memberList.do");
			}else {
				throw new ServletException("not delete");	
			}
			
		}// if end

		
	}

}
