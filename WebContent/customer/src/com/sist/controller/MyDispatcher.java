package com.sist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.customer.controller.NoticeController;
import com.sist.customer.controller.NoticeDetailController;

public class MyDispatcher extends HttpServlet{
	
	protected void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 어떤 요청이 들어왔는지.
		String requestURI = request.getRequestURI();
		System.out.println("requestURI="+requestURI);
		String toMove = null;
		if(requestURI.equals("/myWeb_MVC2/customer/notice.do")) {
			NoticeController controller = new NoticeController();
			toMove = controller.execute(request, response);
		}else if(requestURI.equals("/myWeb_MVC2/customer/noticeDetail.do")) {
			NoticeDetailController controller = new NoticeDetailController();
			toMove = controller.execute(request, response);
		}
		request.getRequestDispatcher(toMove).forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}
}
