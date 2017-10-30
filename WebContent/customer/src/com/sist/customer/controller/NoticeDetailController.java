package com.sist.customer.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.NoticeDAO;
import com.sist.vo.Notice;

public class NoticeDetailController extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String seq =null;
		String pg = null;
		seq = request.getParameter("seq");
		pg = request.getParameter("pg");
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		String urlQuery = URLEncoder.encode(query, "UTF-8");
		
		//session 얻어오기
		HttpSession session = request.getSession();
		if(session.getAttribute("mid")==null) {
			response.sendRedirect("../joinus/login.jsp");
		}else {
			NoticeDAO ndao = new NoticeDAO();
			Notice n = ndao.getNotices(seq);
			
			request.setAttribute("n", n);
			request.setAttribute("pg", pg);
			//request.setAttribute("seq", seq);
			request.setAttribute("field", field);
			request.setAttribute("query", query);
			request.setAttribute("urlQuery", urlQuery);
			
			request.getRequestDispatcher("noticeDetail.jsp").forward(request, response);
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
