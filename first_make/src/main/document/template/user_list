<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/top.jsp"%>
<div class="content">
	<div class="search_form">
		<form id="searchForm" action="${contextPath}/admin/user/user_list">
			<input type="hidden" name="currPg" id="currPg" value="0"/>
			<input type="hidden" name="rowSize" id="rowSize" value="10"/>
			<input type="hidden" name="fnName" id="fnName" value="move"/>	
			<span>검색어 </span>  <input type="text" id="search" name="search" value="${search}">
			<button>검색</button><input type="button" id="userInsert" value="등록">
		</form>
	</div>
	<div>
	<table class="list">
		<colgroup>
			<col width="5%;" />
			<col width="15%;" />
			<col width="25%;" />
			<col width="20%;" />
			<col width="20%;" />
			<col width="15%;" />
		</colgroup>
		<thead>
			<tr>
				<th></th>
				<th>사용자ID</th>
				<th>사용자명</th>
				<th>사용자타입</th>
				<th>등록자</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}" varStatus="idx">
			<tr>
				<td>${item.rn}</td>
				<td>${item.user_id}</td>
				<td>${item.user_nm}</td>
				<td>${item.user_group}</td>
				<td>${item.create_user}</td>
				<td><button onclick="user_update('${item.user_id}')">수정</button><button onclick="user_delete('${item.user_id}')">삭제</button></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="paging" style="text-align: center;">
		${navi}
	</div>
	
	</div>
</div>
<script src="${jsPath}/routine/admin/user/user_list.js?ver=1.5"></script>
<%@ include file="../../inc/footer.jsp"%>