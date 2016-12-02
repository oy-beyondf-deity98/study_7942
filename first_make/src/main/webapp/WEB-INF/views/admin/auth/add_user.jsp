<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="../../inc/top.jsp"%>
<div class="content">
<div class="page_name">권한-사용자 등록</div>
<!-- commandName 는 폼에 적용할 모델의 이름을 정의한다.    -->
<input type="hidden" id="auth_seq" value="${auth_seq}">
<table class="input_form">
<tbody>
	<tr>
		<td>
			<div>
				<select id="listUser" multiple="multiple" size="10">
				<c:forEach var="item" items="${auth_object_user}">
					<option value="${item.user_id }">${item.user_nm }</option>
				</c:forEach>
				</select>
			</div>		
		</td>
		<td>
			<div><input type="button" id="grant" value=">>"><br><input id="removeGrant" type="button" value="<<"></div>
		</td>
		<td>
			<div>
				<select id="grantUser" multiple="multiple" size="10">
				<c:forEach var="item" items="${grant_auth_user}">
					<option value="${item.USER_ID }">${item.USER_NM }</option>
				</c:forEach>
				</select>
			</div>		
		</td>
	</tr>
</tbody>
<tfoot>
	<tr>
		<td colspan="3"><div><input type="button" id="saveAuthUser" value="저장"> <input class="close" type="button" value="취소"></div></td>
	</tr>
</tfoot>
</table>
</div>
<script src="${jsPath}/routine/admin/auth/add_user.js?ver=1.5"></script>

<%@ include file="../../inc/footer.jsp"%>
