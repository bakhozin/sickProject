package com.sist.book.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.dao.BookDao;
import com.sist.vo.Books;

public class BookSearchProcController implements Controller {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String _pg = request.getParameter("pg");
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		String title = request.getParameter("title");
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
		
		BookDao ndao = new BookDao();
		int sPage = pg - (pg-1)%5;
		int seqCount = ndao.getSeqCount(field, query);
		int finalPage = seqCount/10 + (seqCount%10==0?0:1);
			
		BookDao dao = new BookDao();
		//Books book=dao.findBook(title);
		
		
		ArrayList<Books> list2 = dao.allBook(pg, field, urlQuery);
		ArrayList<Books> list = dao.allBook(pg, field, query, title);
		
		System.out.println("리스트사이즈"+list.size());
		System.out.println(title);
		for(int i=0; i<list2.size(); i++){
			
			
			System.out.println(i+1+"번째 리스트2타이틀:"+list2.get(i).getTitle());

		}
		
		
		request.setAttribute("list", list);	
				
		return "BookSearch.jsp";
	}  	
	
	
}
