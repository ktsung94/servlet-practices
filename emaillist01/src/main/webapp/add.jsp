<%@page import="com.douzone.emaillist.dao.EmaillistDao"%>
<%@page import="com.douzone.emaillist.vo.EmaillistVo"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	request.setCharacterEncoding("utf-8");

	String firstName = request.getParameter("fn");
	String lastName = request.getParameter("ln");
	String email = request.getParameter("email");
	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(email);
	
	new EmaillistDao().insert(vo);
	
	response.sendRedirect("/emaillist01");	// redirect를 안해주면 새로고침시 정보가 중복돼서 저장된다.
	
// 이것을 안써줘도 된다.	
//	<!DOCTYPE html>
//	<html>
//	<head>
//	<meta charset="EUC-KR">
//	<title>Insert title here</title>
//	</head>
//	<body>
//		<h1>1111</h1>
//	</body>
//	</html>
%>

