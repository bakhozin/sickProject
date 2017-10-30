package com.sist.customer.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.NoticeDAO;
import com.sist.vo.Notice;

public class NoticeEditProcController extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String seq = request.getParameter("seq");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pg = request.getParameter("pg");
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		String urlQuery = URLEncoder.encode(query, "UTF-8");
		NoticeDAO ndao = new NoticeDAO();
		Notice n = new Notice();
		n.setSeq(seq);
		n.setTitle(title);
		n.setContent(content);
		System.out.println("field="+field);
		System.out.println("query="+query);
		int af = ndao.updateNotices(n);
		if(af==1) {
			System.out.println("��������");
			//sendRedirect : controller->controller, ��ü����x
			response.sendRedirect("noticeDetail.do?seq="+seq+"&q="+urlQuery+"&f="+field+"&pg="+pg);
		}else {
			System.out.println("��������");
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
