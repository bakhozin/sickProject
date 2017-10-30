<%@page import="java.net.URLEncoder"%>
<%@page import="com.sist.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Notice> nList = (ArrayList<Notice>)request.getAttribute("nList");
	int pg = (int)request.getAttribute("pg");
	String field = (String)request.getAttribute("field");
	String query = (String)request.getAttribute("query");
	String urlQuery = (String)request.getAttribute("urlQuery");
	int sPage = (int)request.getAttribute("sPage");
	int finalPage = (int)request.getAttribute("finalPage");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="notice.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지 로그</h3>
					<ul id="breadscrumb" class="block_hlist clear">
						<li>HOME</li>
						<li>
							고객센터
						</li>
						<li>
							공지사항목록
						</li>
					</ul>
					<h3 class="hidden">공지사항 목록</h3>
					<form id="content-searchform" class="article-search-form" action="notice.do" method="get">
						<fieldset>
							<legend class="hidden">
								목록 검색 폼
							</legend>
							<input type="hidden" name="pg" value="" />
							<label for="f"
							class="hidden">검색필드</label>
							<select name="f">
							<%if(field.equals("TITLE")) { %>
								<option value="TITLE" selected="selected">제목</option>
								<option value="CONTENT">내용</option>
							<%}else {%>
								<option value="TITLE">제목</option>
								<option value="CONTENT" selected="selected">내용</option>
							<%} %>
							</select>
							<label class="hidden" for="q">검색어</label>
							<input type="text" name="q" value="<%=query %>" />
							<input type="submit" value="검색" />
						</fieldset>
					</form>
					<table class="article-list margin-small">
						<caption class="hidden">
							공지사항
						</caption>
						<thead>
							<tr>
								<th class="seq">번호</th>
								<th class="title">제목</th>
								<th class="writer">작성자</th>
								<th class="regdate">작성일</th>
								<th class="hit">조회수</th>
							</tr>
						</thead>
						<tbody>
						<%
							for (int i = 0; i < nList.size(); i++) {
						%>
						<tr>
							<td class="seq"><%=nList.get(i).getSeq()%></td>
							<td class="title"><a href="noticeDetail.do?seq=<%=nList.get(i).getSeq()%>&pg=<%=pg%>&f=<%=field%>&q=<%=urlQuery%>"><%=nList.get(i).getTitle()%></a></td>
							<td class="writer"><%=nList.get(i).getWriter()%></td>
							<td class="regdate"><%=nList.get(i).getRegdate()%></td>
							<td class="hit"><%=nList.get(i).getHit()%></td>
						</tr>
						<%
							}
						%>

					</tbody>
					</table>
					<p class="article-comment margin-small">
						<a class="btn-write button" href="noticeReg.do">글쓰기</a>
					</p>
					<p id="cur-page" class="margin-small">
						<span class="strong">1</span> /
						10	page
					</p>
					<div id="pager-wrapper" class="margin-small">
						<div class="pager clear">
							<%if(sPage!=1) { %>
							<p id="btnPrev">
								<a class="button btn-prev" href="notice.do?pg=<%=sPage-1%>&f=<%=field%>&q=<%=urlQuery%>">이전</a>
							</p>
							<%} %>
							<ul>
							<%for(int i=0; i<5; i++) { %>
								<li>
								<%if(i+sPage <= finalPage) { %>
									<%if(i+sPage == pg) { %>
										<a class="strong"><%=sPage+i %></a>
									<%} else {%>
										<a href="notice.do?pg=<%=i+sPage%>&f=<%=field%>&q=<%=urlQuery%>"><%=i+sPage %></a>
									<%} %>
								<%} %>	
								</li>
							<%} %>	
							</ul>
							<%if(sPage+4 < finalPage) { %>
							<p id="btnNext">
								<a class="button btn-next" href="notice.do?pg=<%=sPage+5%>&f=<%=field%>&q=<%=urlQuery%>">다음</a>
							</p>
							<%}%>
						</div>
					</div>
				</div>
				
			</div>
		</div>
		
	</body>
</html>
