<%@page import="com.sist.dao.MemberDAO"%>
<%@page import="com.sist.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Member mb = new Member();
	MemberDAO dao = new MemberDAO();
	request.setCharacterEncoding("UTF-8");
	String mid = request.getParameter("mid");                                                                                                   
	String pwd = request.getParameter("pwd");
	//String pwd2 = request.getParameter("pwd2");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	String birthday = String.format("%s-%s-%s", year, month, day);
	String isLunar = request.getParameter("isLunar");
	String age = request.getParameter("age");
	int iage = Integer.parseInt(age);
	String phone = request.getParameter("phone");
	String[] habits = request.getParameterValues("habit");
	String habit = "";
	if(habits !=null && habits.length>1) {
		for(int i=0; i<habits.length; i++) {
			if(i!=habits.length-1){
				habit=habit+habits[i]+",";
			}else {
				habit=habit+habits[i];
			}
		}
	}
	
	mb.setMid(mid);
	mb.setPwd(pwd);
	mb.setName(name);
	mb.setGender(gender);
	mb.setBirthday(birthday);
	mb.setIsLunar(isLunar);
	mb.setAge(iage);
	mb.setPhone(phone);
	mb.setHabit(habit);
	
	int af = dao.addMember(mb);
	if(af==1) {
		System.out.println("회원가입성공");
		response.sendRedirect("login.jsp");
	}else {
		System.out.println("회원가입실패");
		response.sendRedirect("join.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>아이디 : <%=mid %></p>
	<p>비밀번호 : <%=pwd %></p>
	<%-- <p>비밀번호 확인 : <%=pwd2 %></p> --%>
	<p>이름 : <%=name %></p>
	<p>나이 : <%=iage %></p>
	<p>성별 : <%=gender %></p>
	<p>생일 : <%=birthday %></p>
	<p>양력/음력 : <%=isLunar %></p>
	<p>전화번호 : <%=phone %></p>
	<p>취미 : <%=habit %></p>
</body>
</html>