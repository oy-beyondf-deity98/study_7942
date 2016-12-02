<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page isErrorPage="true" %>
<html>
<head>
	<title>Error</title>
</head>
<body>
<h1>
	요청처리과정에서 오류가 발생하였습니다.  
</h1>

<P>  에러타입 : <%=exception.getClass().getName() %> </P>
<P>  에러메세지 : <%=exception.getMessage() %> </P>
</body>
</html>
