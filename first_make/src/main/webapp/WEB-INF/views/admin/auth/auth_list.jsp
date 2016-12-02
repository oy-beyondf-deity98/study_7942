<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/top.jsp"%>
<div class="content">
	<div class="search_form">
		<form id="searchForm" action="${contextPath}/admin/auth/auth_list">
			<input type="hidden" name="currPg" id="currPg" value="0"/>
			<input type="hidden" name="rowSize" id="rowSize" value="10"/>
			<input type="hidden" name="fnName" id="fnName" value="move"/>	
			<span>검색어 </span>  <input type="text" id="search" name="search" value="${search}">
			<button>검색</button><input type="button" id="authInsert" value="등록">
		</form>
	</div>
	<div>
	<table class="list">
		<colgroup>
			<col width="5%;" />
			<col width="30%;" />
			<col width="20%;" />
			<col width="25%;" />
			<col width="25%;" />
		</colgroup>
		<thead>
			<tr>
				<th></th>
				<th>인증명</th>
				<th>인증타입</th>
				<th>등록자</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}" varStatus="idx">
			<tr>
				<td>${item.rn}</td>
				<td>${item.auth_nm}</td><!-- 권한명을 클릭하면 어떤사용자와 어떤 메뉴가 속해있는지 볼수 있으면 좋을듯하다. -->
				<td>${item.auth_type}</td>
				<td>${item.create_user}</td>
				<td>
					<button onclick="add_user('${item.auth_seq}')">사용자</button><button onclick="add_menu('${item.auth_seq}')">메뉴</button>
					<button onclick="auth_update('${item.auth_seq}')">수정</button><button onclick="auth_delete('${item.auth_seq}')">삭제</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="paging" style="text-align: center;">
		${navi}
	</div>
	
	</div>
</div>
<script src="${jsPath}/routine/admin/auth/auth_list.js"></script>
<%@ include file="../../inc/footer.jsp"%>