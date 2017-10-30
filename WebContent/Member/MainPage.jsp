<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	<nav>
        <ul>
            <li><a href="MemberLogin.do">로그인</a></li>
            
            <li><a href="MemberAdd.do">회원가입</a></li> <!-- jsp대신 do 왜냐면 controller사용하기 때문 -->

            <li><a href="../Book/BookSearch.do">책 검색</a></li>
            
            <li><a href="#">새로운 책 정보</a></li>
            <li><a href="#">Q&A</a></li>
        </ul>    
    </nav>    
    <img src="">
 
 <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

	<div class="carousel-inner">
	      <div class="item active">
	        	<center><img src="../image/a.jpg" alt="mainFlower" style="width:1000px; height:650px;"></center>
	      </div>
	
	      <div class="item">
	        	<center><img src="../image/b.jpg" alt="Chicago" style="width:1000px; height:650px;"></center>
	      </div>
	    
	      <div class="item">
	        	<center><img src="../image/c.jpg" alt="New york" style="width:1000px; height:650px;"></center>
	      </div>   
	</div>
	 <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
</div>  
        
    
</body>
</html>