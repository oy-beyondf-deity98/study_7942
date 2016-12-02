<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="common.jsp"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>
</head>
<body>
<div class="top">
<div><a href="${contextPath}">TOP이동</a></div>
<div class="log_user"><span>${session.USER_NM}</span>님이 로그인 하였습니다. <span><a href="${contextPath}/logout">로그아웃</a></span></div>
</div>
<div class="menu">
	<ul>
	<c:forEach var="item" items="${topMenu}" varStatus="status">
		<c:choose>
			<c:when test="${item.MENU_DEPTH eq 1}">
		<li class="topMenuLi"><a class="menuLink" href="${contextPath }${item.MENU_URL}">${item.MENU_NM}</a>
			</c:when>
		</c:choose>	
		<c:forEach var="childItem" items="${listTopMenu}" varStatus="childStatus">
			<c:choose>
				<c:when test="${childItem.MENU_DEPTH eq 2 && item.MENU_SEQ == childItem.PARENT_MENU}">
			<ul class="submenu">
	        	<li><a href="${contextPath }${childItem.MENU_URL}" class="submenuLink longLink">${childItem.MENU_NM}</a></li>
			</ul>			
				</c:when>
			</c:choose>
		</c:forEach>
		</li>
	</c:forEach>
		<!-- li class="topMenuLi">
			<a class="menuLink" href="${contextPath }/admin/user/user_list">사용자 페이지</a>
			<ul class="submenu">
            	<li><a href="http://unikys.tistory.com/335" class="submenuLink">메뉴CSS참조</a></li>
            </ul>
		</li>
		<li class="topMenuLi"><a class="menuLink" href="${contextPath }/admin/menu/menu_list">메뉴페이지</a></li>
		<li class="topMenuLi"><a class="menuLink" href="${contextPath }/admin/code/code_list">코드페이지</a></li>
		<li class="topMenuLi"><a class="menuLink" href="${contextPath }/admin/auth/access/access_list">접속인증페이지</a></li>
		<li class="topMenuLi"><a class="menuLink" href="${contextPath }/admin/auth/menu_auth/auth_list">메뉴인증페이지</a></li -->
	</ul>
	
</div>
<div class="location">
	<ul>
		<li>${location}</li>
	</ul>
</div>


