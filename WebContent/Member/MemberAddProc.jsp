<%@page import="com.sist.dao.MemberDao"%>
<%@page import="com.sist.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	Member mb = new Member();
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
		response.sendRedirect("MemberLogin.jsp");
	}else {
		System.out.println("회원가입실패");
		response.sendRedirect("MainPage.jsp");
	}
	
%> 
    
