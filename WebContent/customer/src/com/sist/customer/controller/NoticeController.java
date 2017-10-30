package com.sist.customer.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.NoticeDAO;
import com.sist.vo.Notice;

public class NoticeController extends HttpServlet{
	//controller(servlet이어야 함) 하나 당 view(.jsp) 하나

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _pg = request.getParameter("pg");
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		String urlQuery = "";
		int pg;
		if(_pg!=null && !_pg.equals("")) {
			pg = Integer.parseInt(_pg);
		}else {
			pg=1;
		}
		if(field==null || field.equals("")) {
			field = "TITLE";
		}
		if(query==null) {
			query = "";
		}else {
			urlQuery = URLEncoder.encode(query, "UTF-8");
		}
		NoticeDAO ndao = new NoticeDAO();
		int sPage = pg - (pg-1)%5;
		int seqCount = ndao.getSeqCount(field, query);
		int finalPage = seqCount/10 + (seqCount%10==0?0:1);
		ArrayList<Notice> nList = ndao.allNotices(pg, field, query);

		//숫자나 문자로 주면 Object로 저장
		request.setAttribute("nList", nList);
		request.setAttribute("pg", pg);
		request.setAttribute("field", field);
		request.setAttribute("query", query);
		request.setAttribute("urlQuery", urlQuery);
		request.setAttribute("sPage", sPage);
		request.setAttribute("finalPage", finalPage);
		
		// dispatcher : controller->view일때, 객체전달
		request.getRequestDispatcher("notice.jsp").forward(request, response);
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
