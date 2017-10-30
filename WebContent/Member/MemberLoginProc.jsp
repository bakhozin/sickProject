<%@page import="com.sist.vo.Members"%>
<%@page import="com.sist.dao.MemberDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = request.getParameter("mid");
	String pwd = request.getParameter("pwd");
	
	MemberDao dao = new MemberDao();
	Members m= dao.getMember(mid);
	
	if(m==null){
	System.out.println("아이디 오류");
	response.sendRedirect("login.jsp?error=IDx");
} else if(!pwd.equals(m.getPwd())){
	System.out.println("비밀번호 오류");
	response.sendRedirect("login.jsp?error=PWDx");
} else{
	System.out.println("로그인 성공");
	session.setAttribute("mid", mid);
	System.out.println(mid);
	response.sendRedirect("MyPage.do");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>