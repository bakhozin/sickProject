package com.sist.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.NoticeDAO;
import com.sist.vo.Notice;

public class NoticeRegProcController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//String mid = request.getParameter("mid");
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Notice n = new Notice();
		
		n.setTitle(title);
		n.setContent(content);
		
		NoticeDAO ndao = new NoticeDAO();
		int af = ndao.addNotices(n, mid);
		if(af==1) {
			System.out.println("게시글추가 성공");
			response.sendRedirect("notice.do");
		}else {
			System.out.println("게시글추가 실패");
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
