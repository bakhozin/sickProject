package com.sist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.dao.MemberDao;
import com.sist.vo.Members;

public class MemberEditController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		/*String mid= request.getParameter("mid");
		String pwd= request.getParameter("pwd");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String status=request.getParameter("status");
		int iage= Integer.parseInt(request.getParameter("age"));
		int ibal= Integer.parseInt(request.getParameter("balance"));*/
		 HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		MemberDao md = new MemberDao();
		Members m= md.getMember(mid);
		
		request.setAttribute("m", m);
		
		/*request.setAttribute("mid", mid);
		request.setAttribute("pwd", pwd);
		request.setAttribute("name", name);
		request.setAttribute("address", address);*/
						
		/*m.setPwd(pwd);
		m.setAddress(address);*/
		
		return "MemberEdit.jsp";  
	}

}
