<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../../inc/top.jsp"%>

<div class="content">
<div class="page_name">사용자 등록</div>
<!-- commandName 는 폼에 적용할 모델의 이름을 정의한다.    -->
<form:form commandName="menu" method="POST" action="${contextPath}/admin/menu/menu_insert">
	<table class="input_form">
		<tbody>
		    <tr>
		        <th>메뉴명</th>
		        <td><form:input path="menu_nm" /></td>
		        <td><form:errors path="menu_nm" cssClass="errorMsg"></form:errors></td>
		    </tr>
		    <tr>
		        <th>메뉴URL</th>
		        <td><form:input path="menu_url" /></td>
		        <td><form:errors path="menu_url" cssClass="errorMsg"></form:errors></td>
		    </tr>
		    <tr>
		        <th>부모메뉴</th>
		        <td><input type="text" id="parent_menu_nm" disabled><input type="button" id="select_parent" value="부모메뉴선택">
		        <form:hidden path="parent_menu" /><form:hidden path="menu_depth" /></td>
		        <td><form:errors path="parent_menu" cssClass="errorMsg"></form:errors></td>
		    </tr>
		    <tr>
		        <th>순서</th>
		        <td><form:input path="order_num" /></td>
		        <td><form:errors path="order_num" cssClass="errorMsg"></form:errors></td>
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
<script src="${jsPath}/routine/admin/menu/menu_insert.js?ver=1.5"></script>
<%@ include file="menu_tree.jsp"%>
<%@ include file="../../inc/footer.jsp"%>
