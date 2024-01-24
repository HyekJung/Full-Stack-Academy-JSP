<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>multiForm</title>
</head>
<body>
<h1>multiForm</h1>

<form action="/jspProj/MultiRegSvt" method="post" enctype="multipart/form-data">
	<table border="">
		<tr>
			<td>pid</td>
			<td><input type="text" name="pid" /></td>
		</tr>
		<tr>
			<td>ff</td>
			<td><input type="file" name="ff" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="단일가입" /></td>
		</tr>
	</table>
</form>

<form action="/jspProj/MultiRegSvt" method="post" enctype="multipart/form-data">
	<table border="">
		<tr>
			<td>pid</td>
			<td><input type="text" name="pid" /></td>
		</tr>
		<tr>
			<td>ff</td>
			<td><input type="file" name="ff" multiple = "multiple"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="멀티가입" /></td>
		</tr>
	</table>
</form>
</body>
</html>