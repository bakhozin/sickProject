package com.sist.joinus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.MemberDAO;
import com.sist.vo.Member;

public class LoginProcController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		
		Member m = dao.getMember(mid);
		if(m==null){
			System.out.println("아이디가 없습니다.");
			response.sendRedirect("login.do?error=IDx");
		}else if(!pwd.equals(m.getPwd())) {
			System.out.println("비밀번호가 틀렸습니다.");
			response.sendRedirect("login.do?error=PWDx");
		}else {
			System.out.println("로그인 성공");
			//response.sendRedirect("welcomelogin.jsp?mid="+mid);
			
			//로그인되자마자 세션에 등록해서 나머지 필요한 곳에서 불러냅시다아아아아앙
			HttpSession session = request.getSession();
			session.setAttribute("mid", mid); //setAttrubute("key", value);
			response.sendRedirect("welcomelogin.jsp");
		}
		
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
