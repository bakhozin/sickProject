<%@page import="java.net.URLEncoder"%>
<%@page import="com.sist.vo.Notice"%>
<%@page import="com.sist.dao.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pg = (String)request.getAttribute("pg");
	String field = (String)request.getAttribute("field");
	String query = (String)request.getAttribute("query");
	String urlQuery = (String)request.getAttribute("urlQuery");
	Notice n = (Notice)request.getAttribute("n");		
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="../css/customer.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지위치</h3>
					<ul id="breadscrumb" class="block_hlist">
						<li id="home">
							<a href="">HOME</a>
						</li>
						<li>
							<a href="">고객센터</a>
						</li>
						<li>
							<a href="">공지사항</a>
						</li>
					</ul>
					<div id="notice-article-detail" class="article-detail margin-large" >						
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								제목
							</dt>
							<dd class="article-detail-data">
								<%=n.getTitle() %>
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								작성일
							</dt>
							<dd class="article-detail-data">
							<%if(n!=null) {%>
								<%=n.getRegdate() %>
							<%} %>
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								작성자
							</dt>
							<dd class="article-detail-data half-data" >
							<%if(n!=null) {%>
								<%=n.getWriter() %>
							<%} %>	
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								조회수
							</dt>
							<dd class="article-detail-data half-data">
							<%if(n!=null) {%>
								<%=n.getHit() %>
							<%} %>	
							</dd>
						</dl>
						<div class="article-content" >
							<img src="http://sstatic.naver.net/keypage/outside/info/2011031017145546407.jpg" /><br />
							<%if(n!=null) {%>	
								<%=n.getContent() %>
							<%} %>	
						</div>
					</div>
					<p class="article-comment margin-small">
						<a class="btn-list button" href="notice.do?pg=<%=pg%>&seq=<%=n.getSeq()%>&q=<%=urlQuery%>&f=<%=field%>">목록</a>
						<%if(n!=null) {%>					
						<a class="btn-edit button" href="noticeEdit.do?seq=<%=n.getSeq()%>&pg=<%=pg%>&q=<%=urlQuery%>&f=<%=field%>">수정</a>
						<a class="btn-del button" href="noticeDelProc.do?seq=<%=n.getSeq()%>&pg=<%=pg%>&q=<%=urlQuery%>&f=<%=field%>">삭제</a>
						<%}%>
					</p>
				</div>				
							
			</div>
		</div>
		
	</body>
</html>
