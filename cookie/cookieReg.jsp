<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie</title>
</head>
<body>

<% 
	//id, pw 불러오기
	String pid = request.getParameter("id");
	String ppw = request.getParameter("pw");
	
	Cookie coo = new Cookie(pid, ppw);
	response.addCookie(coo);
	
    // 로그인 성공 여부
    boolean loginSuc = false;
    
    //회원 이름
    String loginName = "";
	
	//로그인 회원 정보
     String[][] login = {
            {"aaa", "1111", "사람 1"},
            {"bbb", "2222", "사람 2"},
            {"ccc", "3333", "사람 3"},
            {"ddd", "4444", "사람 4"},
            {"eee", "5555", "사람 5"}
        };
     
     for(int i = 0; i<login.length; i++){
    	 if(login[i][0].equals(pid)&&login[i][1].equals(ppw)){
    		 loginName = login[i][2];
    		 loginSuc = true;
    		 break;
    	 }
     }
%>
	<script>
	<%if(loginSuc == true){%>
		alert("<%= loginName %> 님 로그인 성공!");
	<%}else{%>
		alert("로그인 실패!");
	<%}%>
	</script>
</body>
</html>