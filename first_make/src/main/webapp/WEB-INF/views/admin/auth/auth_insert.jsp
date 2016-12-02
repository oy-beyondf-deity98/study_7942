<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../../inc/top.jsp"%>
<div class="content">
<div class="page_name">권한 등록</div>
<!-- commandName 는 폼에 적용할 모델의 이름을 정의한다.    -->
<form:form commandName="auth" method="POST" action="${contextPath}/admin/auth/auth_insert">
	<table class="input_form">
		<tbody>
		    <tr>
		        <th>권한명</th>
		        <td><form:input path="auth_nm" /></td>
		        <td><form:errors path="auth_nm" cssClass="errorMsg"></form:errors></td>
		    </tr>
		    <tr>
		        <th>권한타입</th>
		        <td><form:radiobutton path="auth_type" value="manager"/>manager
		        	<form:radiobutton path="auth_type" value="user" checked="true" />user
		        </td>
		        <td><form:errors path="auth_type" cssClass="errorMsg"></form:errors></td>
		    </tr>
		    <tr>
		        <th>비고</th>
		        <td><form:input path="remark" /></td>
		        <td><form:errors path="remark" cssClass="errorMsg"></form:errors></td>
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
<script src="${jsPath}/routine/admin/auth/auth_insert.js"></script>

<%@ include file="../../inc/footer.jsp"%>
