<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getServletContext().getRealPath("fff/child_1.png");
	path = "C:\\kimhyejung\\study\\javaWork\\jspProj\\src\\main\\webapp\\fileFolder\\fileName.jpg";

	// 1. 클라이언트 컴퓨터에 다운로드할 대화상자 열기 및 다운로드 위치(파일명) 설정
	response.setHeader("Content-Disposition", "attachment;filename = new_FileName.jpg");
	
	// 2. outputStream 초기화 --> 에러 삭제
	out.clear();
	// JSP페이지에 대한 정보(다운로드)를 저장하는 기능
	out = pageContext.pushBody();
	
	// 3. 클라이언트 파일 쓰기 stream
	ServletOutputStream sout = response.getOutputStream();
	
	// 4. 서버 파일 읽기 stream
	FileInputStream fin = new FileInputStream("C:\\kimhyejung\\study\\javaWork\\jspProj\\src\\main\\webapp\\fileFolder\\fileName.jpg");
	
	//5. 파일 내용 전송
	byte [] buf = new byte[1024];
	while(fin.available()>0){
		int len = fin.read(buf);
		sout.write(buf, 0, len);
	}
	
	// 6. stream 닫기
	fin.close();
	sout.close();

%>
