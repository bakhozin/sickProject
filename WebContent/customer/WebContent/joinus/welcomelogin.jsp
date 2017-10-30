<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String mid = request.getParameter("mid");
	//형변환해서 꺼내와야 한다.
	String mid = (String)session.getAttribute("mid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="login.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		
		
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>로그인</h2>
					<h3 class="hidden">방문페이지 로그</h3>
					<ul id="breadscrumb" class="block_hlist clear">
						<li>
							HOME
						</li>
						<li>
							회원가입
						</li>
						<li>
							로그인성공
						</li>
					</ul>
					<h3 class="hidden">회원가입 폼</h3>
					<div id="join-form" class="join-form margin-large" >	
						<p><%=mid %>님 환영합니다.</p>			
						<p><a href="../customer/notice.do">게시판</a></p>
					</div>
					
				</div>
				
			</div>
		</div>
		
	</body>
</html>
