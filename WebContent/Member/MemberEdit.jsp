<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#submit").click(function(){
			
			var pwd = $("#pwd").val();
			var pwd2 = $("#pwd2").val();
			
			if(pwd==""){
				alert("비밀번호를 입력해주세요");
				return false;
			}else if(pwd!=pwd2){
				alert("비밀번호가 틀렸습니다");
				return false;
			} 
			
		});
		
		
	});

</script>
	
</head>
<body>
	<h1> 회원정보수정</h1>
	<form action="MemberEditProc.do" method ="post">
	<table>
		<tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pwd" id="pwd" placeholder="pwd" value="${m.pwd }"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pwd2" id="pwd2" placeholder="pwd" value=""></td>
		</tr>
		<tr>
			<td>어드레스</td>
			<td><input type="text" name="address" placeholder="address" value="${m.address }"></td>
		</tr>
		<tr>
		
		</tr>
			
	</table>	
	
	<input type="submit" id="submit" value="정보수정"/>
	</form>
	<a href="MyPage.do"><button>취소</button></a>
	
	

</body>
</html>