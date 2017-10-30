<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h1><a href="../Member/MainPage.do">LIBRARY 도서관 :)</a></h1>
<body>
<%-- <% request.getAttribute("book"); %> --%>
${book.title}

<%-- ${book.isbn}
${book.writer}
${book.content}
${book.image}
${book.date}
${book.state} --%>
</body>
</html>