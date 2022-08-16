package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	//��� POJO�� ������ �־�� �Ǵ� �޼���
	// ? -> String
	public String requestHandler(HttpServletRequest request,HttpServletResponse response) throws ServletException,  IOException;
	
}
