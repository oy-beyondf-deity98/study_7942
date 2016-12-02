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
<form name="listForm" id="listForm" method="get" action="${contextPath}/test/get_form">
	<input type="text" id="search" name="search_name" value="${search_name}">
	<button>검색</button>
</form>
</body>
</html>
