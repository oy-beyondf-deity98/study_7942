<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<ul>
	<li><a href="${contextPath }/admin/user/user_list">사용자 페이지</a></li>
	<li><a href="${contextPath }/admin/menu/menu_list">메뉴페이지</a></li>
	<li><a href="${contextPath }/admin/code/code_list">코드페이지</a></li>
	<li><a href="${contextPath }/admin/auth/access/access_list">접속인증페이지</a></li>
	<li><a href="${contextPath }/admin/auth/menu_auth/auth_list">메뉴인증페이지</a></li>
</ul>
</body>
</html>
