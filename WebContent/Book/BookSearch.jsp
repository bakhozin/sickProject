<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
  a{text-decoration:none; color:#000000;}         
  a:hover{color:#ff0000;}                     
         
       
  nav ul{padding-top:40px;}                     /*  상단 여백 10px  */
  nav ul li {
            display:inline;                         /*  세로나열을 가로나열로 변경 */
            border-left:10px solid #999;             /* 각 메뉴의 왼쪽에 "|" 표시(분류 표시) */
            font:bold 30px Dotum;                     /* 폰트 설정 - 12px의 돋움체 굵은 글씨로 표시 */
            padding:0 15px;         
                            /* 각 메뉴 간격 */
        }
         nav ul li:first-child{border-left:none;}     /* 메뉴 분류중 제일 왼쪽의 "|"는 삭제        
</style>
</head>

<body>
<h1><a href="../Member/MainPage.do">LIBRARY 도서관 :)</a></h1>
<h1>Search your books</h1>
	<form action="BookSearchProc.do" >
       
      <input type="text" name="title" value="">   
       
      <input type="submit" value="검색">  
   </form>

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
					<form id="content-searchform" class="article-search-form" action="BookSearchProc.do?f=${field }&q=${urlQuery}" method="get">
						<fieldset>
							<legend class="hidden">
								목록 검색 폼
							</legend>
							<input type="hidden" name="pg" value="" />
							<label for="f"
							class="hidden">검색필드</label>
							<select name="f">
								<option value="TITLE" selected="selected">제목</option>
							</select>
							<label class="hidden" for="q">검색어</label>
							<input type="text" name="title" value="" />
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
							
							<c:forEach var="n" items="${list}">
							 <tr>
								<td class="seq">${n.seq}</td>
								<td class="title">${n.title}</td>
								<td class="writer">${n.writer}</td>
								<td class="regdate">${n.date}</td>
								<td class="hit">${n.isbn}</td>
							</tr>
							</c:forEach>
	
							<!--  <tr>
								<td class="seq">1</td>
								<td class="title"><a href="noticeDetail.jsp">동해물과 백두산이</a></td>
								<td class="writer">성바다</td>
								<td class="regdate">2013-02-10</td>
								<td class="hit">12</td>
							</tr>  -->

						</tbody>
					</table>
					
					<p class="article-comment margin-small">
						<a class="btn-write button" href="noticeReg.do?pg=${pg }&f=${field }&q=${urlQuery}"></a>
					</p>
					
					<p id="cur-page" class="margin-small">
						<span class="strong">${pg }</span> /
						${finalPage }	page 
					</p>
					<div id="pager-wrapper" class="margin-small">
						<div class="pager clear">
								<c:if test="${sPage !=1 }">
								<p id="btnPrev">
								<a class="button btn-prev" href="BookSearch.do?pg=${sPage-1 }&f=${field }&q=${urlQuery}">이전</a>
								</p>
								</c:if>							
							<ul>
								<c:forEach var="i" begin="0" end="4">
									<li>
										<c:if test="${i+sPage <= finalPage }">
											<c:if test="${i+sPage==pg }">
												<a class="strong">${i+sPage }</a>
											</c:if>
											<c:if test="${i+sPage!=pg }">
												<a href="BookSearch.do?pg=${i+sPage }&f=${field }&q=${urlQuery}" >${i+sPage }</a>
											</c:if>
										</c:if>
									</li>
								</c:forEach>								
							</ul>
							<p id="btnNext">
							<c:if test="${sPage+4 < finalPage }">
								<a class="button btn-next" href="BookSearch.do?pg=${sPage+5 }&f=${field }&q=${urlQuery}">다음</a>
							</c:if>
							</p>
						</div>
					</div>
				</div>
				
			</div>
		</div>
    
    
</body>
</html>