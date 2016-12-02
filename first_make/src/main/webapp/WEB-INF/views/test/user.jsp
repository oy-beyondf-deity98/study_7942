<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!-- 먼저 Spring Form Tag를 사용하기 위해 taglib 한줄 추가한다. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>${title }</title>
	<style>
  .errorMsg { font-size:12px;
                  color: red; }
	</style>
</head>
<body>
<h1>
	user list
</h1>
<table class="table">
	<colgroup>
		<col style='width: 5%;' />
		<col style='width: 25%;' />
		<col style='width: 12%;' />
		<col style='width: 13%;' />
		<col style='width: 25%;' />
		<col style='width: 20%;' />
	</colgroup>
	<thead>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>정보</th>
		</tr>
	</thead>
	<c:forEach var="item" items="${list}">
		<tr>
			<td>${item.userId}</td>
			<td>${item.userName}</td>
			<td>${item.userInfo}</td>
			
		</tr>				
	</c:forEach>
</table>


</body>
</html>
