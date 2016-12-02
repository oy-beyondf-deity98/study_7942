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
	get search
</h1>
<!-- commandName 는 폼에 적용할 모델의 이름을 정의한다.    -->
<form:form commandName="user" method="POST" actino="${contextPath}/test/post_spring_insert">
        <table border="1">
            <tr>
                <td>아이디</td>
                <td><form:input path="userId" /></td>
                <!-- errors는 위의 input의 바인딩 에러메시지를 출력하기위해 사용한다. 
                     path에 지정한 이름과 일치하는 곳에 에러메시지 출력.-->
                <td><form:errors path="userId"  id="userId" cssClass="errorMsg"></form:errors></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><form:input path="userName" /></td>
                <td><form:errors path="userName" id="userName" cssClass="errorMsg"></form:errors></td>
            </tr>
            <tr>
                <td>정보</td>
                <td><form:input path="userInfo" /></td>
                <td><form:errors path="userInfo" id="userInfo" cssClass="errorMsg"></form:errors></td>
            </tr>
            <tr>
            <td colspan="3" align="center"> <input type="submit" value="저장">
            </tr>
        </table>	
</form:form>

</body>
</html>
