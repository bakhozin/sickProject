<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원가입</h1>
	<form action="MemberAddProc.do" method ="post">
	<table>
		<tr>
		<td>아이디</td>
			<td class="id">
			<input type="text" name="mid" placeholder="mid" value=""></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pwd" placeholder="pwd" value=""></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pwd2" placeholder="pwd" value=""></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" placeholder="name" value="">
			</td>
		</tr>
		<tr>
			<td>어드레스</td>
			<td><input type="text" name="address" placeholder="address" value="">
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<select name="gender">
				<option>여자</option>
				<option selected="selected"> 남자</option>
				</select>			
			</td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" placeholder="age" value="">
			</td>
		</tr>
		<tr>
			<td>상태</td>
			<td>
				<select name="status">
				<option>졸업생</option>
				<option selected="selected">재학생</option>
				</select>			
			</td>
		</tr>
		<tr>
			<td>밸란스</td>
			<td><input type="text" name="balance" placeholder="balance" value="">
			</td>
		</tr>
			
	</table>	
	
	<input type="submit"  value="회원가입"/>
	<input type="submit"  value="취소"/>
	
	
	</form>

</body>
</html>