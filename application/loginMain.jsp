<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginMain</title>
<style>
	*{
		margin:0;
		padding:0;
	}
	table, div{
		background-color : beige;
		text-align :center;
		border : 1px solid black;
	}
	div{
		height : 130px;
		width : 200px
		}
	p:nth-child(1){
		margin:15px;
		font-weight: bold;
		font-size: 20px;
	
	}
</style>
</head>
<body>
<h1>loginMain</h1>
<%
//application attribute로 회원정보 입력 로그인 기능 구현
	if(application.getAttribute("id")==null){
%>
<form action="loginReg.jsp">
        <table border="">
            <tr>
                <td>아이디</td>
                <td>
                    <input type="text" name="id">
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="text" name="pw"> </td>
            </tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" />
				</td>
			</tr>
	</form>
	</table>
	<% } else { %>
	<div>
	 		<p>로그인 성공</p>
			<p>안녕하세요 <%=application.getAttribute("id") %>님</p>
			<a href="logout.jsp">
			<input type="submit" value="로그아웃" /></a>
	</div>	
	<% }  %>
	
</body>
</html>