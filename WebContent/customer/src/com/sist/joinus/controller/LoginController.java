package com.sist.joinus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.NoticeDAO;
import com.sist.vo.Notice;

public class LoginController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = request.getParameter("error");
		if(error !=null && !error.equals("")) {
			if(error.equals("IDx")){
				error="아이디 오류";
			}else if(error.equals("PWDx")) {
				error="비밀번호 오류";
			}
		}
		request.setAttribute("error", error);
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
}
