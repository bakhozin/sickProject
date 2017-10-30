<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<h1>마이페이지 :)</h1>
	<nav>
        <ul>
            <li><a href="MemberEdit.do">정보수정 </a></li>
            
            <li><a href="">대출 책 조회</a></li> <!-- jsp대신 do 왜냐면 controller사용하기 때문 -->

            <li><a href="#">쪽지함</a></li>
          
        </ul>    
    </nav>    
    <img src="">
    
 <div>
 	<p>아이디 : ${m.mid}</p>
	<p>비밀번호 : ${m.pwd}</p>
	<p>이름 : ${m.name}</p>
	<p>나이 : ${m.age}</p>
	<p>성별 : ${m.gender}</p>
	<p>주소: ${m.address}</p>
	<p>상태: ${m.status}</p>
	<p>밸란스 : ${m.balance}</p>
 </div>   
    
</body>
</html>