package com.sist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.dao.MemberDao;
import com.sist.vo.Members;

public class MyPageController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mid = (String)request.getSession().getAttribute("mid");
		
		Members m= new Members();
		MemberDao mb=new MemberDao();
			
		m =mb.getMember(mid);
		
		request.setAttribute("m", m);
		
				
		return "MyPage.jsp";
	}

}
