<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%@page session="false"%>
<html>
<head>
<script type="text/javascript" src="<%=jsPath%>/routine/home/home.js"></script>
	<title>Home</title>
</head>
<body onload="fnGet_selectHomeList()">
<h2>Sample</h2>
	<form id="homeForm" method="POST" action="/sample/selectHomeList">
	</form>
	
</body>
</html>
