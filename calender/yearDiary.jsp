<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>yearDiary</title>
    <style>
        img {
            width: 200px;
        }

        body {
            text-align: center;
        }

        /* 	.now{
            display : inline-block;
        } */
    </style>
</head>

<body>
    <%
        /* 연도를 입력받으면 해당 연도 달력이 되게 */

        //이번년도
        Calendar year = Calendar.getInstance();

        //달의 년, 월, 일 설정
        int yearYear = year.get(Calendar.YEAR);
        int yearMonth = year.get(Calendar.MONTH);
        int yearDate = year.get(Calendar.DATE);

        //날짜 1일부터로 설정
        year.set(Calendar.DATE, 1);
    %>

    <%--12월까지의 달력 반복문--%>
    <% for(int i = 0; i<=11; i++){
        year.set(Calendar.MONTH, i);

        //달력에 표시 될 년, 월
        String title = new SimpleDateFormat("yyyy년 MM월").format(year.getTime());

        //년도의 시작 요일, 마지막 날짜
        year.set(Calendar.DATE,1);
        int first = year.get(Calendar.DAY_OF_WEEK);
        int last = year.getActualMaximum(Calendar.DATE);

        if(i%3==0){%>
            <div></div>
        <%}%>
        <script src="../fff/jquery-3.7.1.min.js"></script>
        <script>
            $("table").css('display', 'inline-block');
        </script>

        <table border="">
            <tr>
                <td colspan="7">
                    <img src="../basic/green.png" alt="" />
                </td>
            </tr>
            <tr>
                <td colspan="7">
                    <h2><%=title %></h2>
                </td>
            </tr>
            <tr>
                <!-- 요일 출력-->
                <% for(char ch : "일월화수목금토".toCharArray()) {%>
                    <td><%=ch %></td>
                <% }%>
            </tr>
            <tr>
                <!-- 빈칸 추가 / 요일은 1부터 시작-->
                <% for(int c = 1; c < first; c++){%>
                    <td></td>
                <%}%>
                <!-- 첫째 주까지(토요일까지)-->
                <!-- 1일에 대한 요일을 구한 후에 7일을 빼면 그 주 마지막 일을 구할 수 있음.-->
                <% for(int j = 1; j<=7-first+1; j++) {%>
                    <td><%=j%></td>
                <%}%>
            </tr>
            <tr>
                <!-- 두 번째 주부터(둘째 주 일요일부터)-->
                <%
                for(int k = 7-first+2; k<=last; k++) {%>
                <td><%=k%></td>
                
                <% if((k+first-1)% 7 == 0){ %>
            </tr>
            <tr>
                <% }}%>
            </tr>
        </table>

    <%}%>
</body>
</html>