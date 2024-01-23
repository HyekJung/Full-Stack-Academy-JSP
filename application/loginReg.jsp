<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginReg</title>
</head>
<body>
<h1>loginReg</h1>
<%
//id, pw값 불러오기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	char [] k = id.toCharArray();
	
//비교할 변수 만들기
	String pid;
	String ppw;
	String pname;

    // 회원정보를 2차원 배열로
     String[][] login = {
            {"aaa", "1111", "사람 1"},
            {"bbb", "2222", "사람 2"},
            {"ccc", "3333", "사람 3"},
            {"ddd", "4444", "사람 4"},
            {"eee", "5555", "사람 5"}
        };
    
    //alert에 띄울 변수
    String msg = "로그인 실패";
    String sucmsg = "";
    
    //id, pw, name 값 넣어주기
    for(int i = 0; i< login.length; i++){
    	pid = login[i][0];
    	ppw = login[i][1];
    	pname = login[i][2];
    	
    	//alert창(성공? 실패)
       		if(id.equals(pid)&&pw.equals(ppw)){
       			msg=pname+"님 로그인 성공";
       			sucmsg = msg;
       			
       			break;
       		}%>
    		<%-- 
       		<script>
			alert("<%=msg%>")
			location.href="loginMain.jsp"
			</script> --%>
    <%}%>
<script>
		alert("<%=sucmsg%>")
		location.href="loginMain.jsp"
</script>
</body>
</html>