<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="true" %>
<html>
<head>
	<title>HDT(Hyper Dual Tag)</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="./Inc/top_menu.jsp" />
	<ol>
		<li>입고관리:Warehouse in
			<ol>
				<li>입고조회:삭제포함<span>HDT-W-SEL-110</span>
					<ul>
						<li>입고등록<span>HDT-W-INT-111</span></li>
						<li>입고수정<span>HDT-W-UPT-112</span></li>
					</ul>
				</li>
			</ol>
		</li>
		<li>재고관리:Stock
			<ol>
				<li>창고별 재고조회<span>HDT-S-SEL-210</span></li>
				<li>제품별 재고조회<span>HDT-S-SEL-220</span></li>
			</ol>
		</li>
		<li>출고관리:Delivery
			<ol>
				<li>발주내역조회:출고삭제포함<span>HDT-D-SEL-310</span>
					<ul>
						<li>상세 : 출고 제품내역등록<span>HDT-D-INT-311</span></li>
					</ul>
				</li>
				<li>출고내역조회:출고삭제포함<span>HDT-D-SEL-320</span>
					<ul>
						<li>출고등록 : 출고 제품내역등록<span>HDT-D-INT-321</span></li>
						<li>출고수정 : 출고내역, 출고 제품내역 수정/삭제<span>HDT-D-PUT-322</span></li>
						<li>제품군등록수정<span>HDT-D-PUT-322</span></li>
					</ul>
				</li>
			</ol>
		</li>
		<li>환경설정:Admin
			<ol>
				<li>공통코드관리<span>HDT-A-PUT-410</span>
					<ul>
						<li>등록/수정<span>HDT-A-PUT-411</span></li>
					</ul>
				</li>
				<li>창고관리<span>HDT-A-PUT-420</span>
					<ul>
						<li>등록/수정<span>HDT-A-PUT-421</span></li>
					</ul>
				</li>
				<li>사원관리<span>HDT-A-PUT-430</span>
					<ul>
						<li>등록/수정<span>HDT-A-INT-431</span></li>
					</ul>
				</li>
				<li>부서관리<span>HDT-A-PUT-440</span>
					<ul>
						<li>등록/수정<span>HDT-D-INT-441</span></li>
					</ul>
				</li>
				<li>거래처관리<span>HDT-A-PUT-450</span>
					<ul>
						<li>등록/수정<span>HDT-A-INT-451</span></li>
					</ul>
				</li>
				<li>회사 관리<span>HDT-A-PUT-460</span>
					<ul>
						<li>등록/수정<span>HDT-A-INT-461</span></li>
					</ul>
				</li>
				<li>제조사관리<span>HDT-A-PUT-470</span>
					<ul>
						<li>등록/수정<span>HDT-A-INT-471</span></li>
					</ul>
				</li>								
				<li>상품관리<span>HDT-A-PUT-480</span>
					<ul>
						<li>제품군 등록/수정<span>HDT-D-PUT-481</span></li>
						<li>제조사 등록/수정<span>HDT-D-PUT-482</span></li>
						<li>모델 등록/수정<span>HDT-D-PUT-483</span></li>
					</ul>
				</li>
			</ol>
		</li>
	</ol>
	
	* 권한은 1개만 있다. 페이징별권한은 구현하지 않는다.
</body>
</html>