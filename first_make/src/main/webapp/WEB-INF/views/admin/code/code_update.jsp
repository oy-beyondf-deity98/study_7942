<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../../inc/top.jsp"%>
<div class="content">
<div class="page_name">사용자정보 수정</div>
<!-- commandName 는 폼에 적용할 모델의 이름을 정의한다.    -->
<form:form commandName="code" method="POST" action="${contextPath}/admin/code/code_update">
	<table class="input_form">
		<tbody>
		    <tr>
		        <th>코드</th>
		        <td><form:input path="code" readonly="true"/><form:hidden path="parent_code"/><form:errors path="code" cssClass="errorMsg"></form:errors></td>
		        <th>순서</th>
		        <td><form:input path="order_num" /><form:errors path="order_num" cssClass="errorMsg"></form:errors></td>		        
		    </tr>
		    <tr>
		        <th>코드명</th>
		        <td><form:input path="code_nm" /><form:errors path="code_nm" cssClass="errorMsg"></form:errors></td>
		        <th>코드명(영문)</th>
		        <td><form:input path="code_nm_eng" /><form:errors path="code_nm_eng" cssClass="errorMsg"></form:errors></td>
		    </tr>
		    <tr>
		        <th>설명</th>
		        <td><form:input path="note"/></td>
		        <th>비고</th>
		        <td><form:input path="remark"/></td>		        
		    </tr>
		    <tr>
		        <th>사용여부</th>
		        <td colspan="3"><form:checkbox path="is_use" /></td>
		    </tr>	
	    </tbody>
	    <tfoot>
		    <tr>
		    	<td colspan="4"> <input type="submit" value="저장"> <input class="close" type="button" value="취소"></td>
		    </tr>
	    </tfoot>
	</table>	
</form:form>
</div>
<script src="${jsPath}/routine/admin/code/code_update.js"></script>
<%@ include file="../../inc/footer.jsp"%>
