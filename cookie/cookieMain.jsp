<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieMain</title>
<style>
	body{
		display : flex;
		justify-content: center;
		margin-top: 150px;
	}
	table,td{
		background-color : beige;
		text-align :center;
		border : 1px solid black;
		width : 300px;
	}
</style>
</head>
<body>
<form action = "cookieReg.jsp" method = "get">
    <table>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pw"></td>
        </tr>
        	<td colspan="2" align="center">
            <input type="submit" value="제출"></td>
        </tr>
    </table>
    
</form>

</body>
</html>