package com.sist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.dao.MemberDao;
import com.sist.vo.Members;

public class MemberEditProcController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("하이");
		
		
		//Member mb = new Member();
		MemberDao dao = new MemberDao();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");                                                                                                   
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");

		System.out.println("pwd="+pwd);
		System.out.println("mid="+mid);
		System.out.println("address="+address);
		
		int af = dao.updateMember(pwd, address, mid);
		if(af==1) {
			System.out.println("회원수정성공");
			
			return "redirect:MyPage.do";
			
		}else {
			System.out.println("회원수정실패");
			return "redirect:MainPage.do";
		}
	}

}
