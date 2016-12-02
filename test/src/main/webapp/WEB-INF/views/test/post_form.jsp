<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>${title }</title>
</head>
<body>
<h1>
	get search
</h1>
<form name="postForm" id="postForm" method="post" action="${contextPath}/test/post_form">
	<input type="text" id="menuId" name="menuId" value="${menu.menuId }">
	<input type="text" id="menuName" name="menuName" value="${menu.menuName }">
	<input type="text" id="menuInfo" name="menuInfo" value="${menu.menuInfo }">
	
	<button>저장</button>
</form>
</body>
</html>
