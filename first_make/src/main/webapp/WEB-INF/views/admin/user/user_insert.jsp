<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../../inc/top.jsp"%>
<div class="content">
<div class="page_name">사용자 등록</div>
<!-- commandName 는 폼에 적용할 모델의 이름을 정의한다.    -->
<form:form commandName="user" method="POST" action="${contextPath}/admin/user/user_insert">
	<table class="input_form">
		<tbody>
		    <tr>
		        <th>아이디</th>
		        <td><form:input path="user_id"/></td>
		        <!-- errors는 위의 input의 바인딩 에러메시지를 출력하기위해 사용한다. 
		             path에 지정한 이름과 일치하는 곳에 에러메시지 출력.-->
		        <td><form:errors path="user_id" cssClass="errorMsg"></form:errors></td>
		    </tr>
		    <tr>
		        <th>이름</th>
		        <td><form:input path="user_nm" /></td>
		        <td><form:errors path="user_nm" cssClass="errorMsg"></form:errors></td>
		    </tr>
		    <tr>
		        <th>소속그룹</th>
		        <td><form:radiobutton path="user_group" value="manager"/>manager
		        	<form:radiobutton path="user_group" value="user" checked="true" />user
		        </td>
		        <td><form:errors path="user_group" id="user_group" cssClass="errorMsg"></form:errors></td>
		    </tr>
		    <tr>
		        <th>비밀번호</th>
		        <td><form:password path="user_pwd" /></td>
		        <td><form:errors path="user_pwd" id="user_pwd" cssClass="errorMsg"></form:errors></td>
		    </tr>
		</tbody>
		<tfoot>   
		    <tr>
		    	<td colspan="3"> <input type="submit" value="저장"> <input class="close" type="button" value="취소"></td>
		    </tr>
		</tfoot>
	</table>	
</form:form>
</div>
<script src="${jsPath}/routine/admin/user/user_insert.js?ver=1.5"></script>

<%@ include file="../../inc/footer.jsp"%>
