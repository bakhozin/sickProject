package com.sist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.dao.MemberDao;
import com.sist.vo.Members;

public class memberAddProcController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		Members mb = new Members();
		MemberDao dao = new MemberDao();
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");                                                                                                   
		String pwd = request.getParameter("pwd");
		//String pwd2 = request.getParameter("pwd2");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String status= request.getParameter("status");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		int iage = Integer.parseInt(age);
		String balance= request.getParameter("balance");
		int ibal = Integer.parseInt(balance);
		
		
		mb.setMid(mid);
		mb.setPwd(pwd);
		mb.setName(name);
		mb.setAddress(address);
		mb.setGender(gender);
		mb.setStatus(status);
		mb.setAge(iage);
		mb.setBalance(ibal);
		
		
		int af = dao.addMember(mb);
		if(af==1) {
			System.out.println("회원가입성공");
			return "redirect:MemberLogin.do";
		}else {
			System.out.println("회원가입실패");
			return "redirect:MainPage.do";
		}
	
	}

}
