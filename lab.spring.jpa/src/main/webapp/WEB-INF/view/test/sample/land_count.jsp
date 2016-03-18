<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<form method="GET" action="/property/land/count">
공공데이터 : 
<select id="options" name="options">
	<option value="0">토지거래 건수 조회</option>
	<option value="1">지가지수조회</option>
	<option value="2">(전국지가변동률조사)이용상황별 지가변동률 조회</option>
	<option value="3">(전국지가변동률조사)용도지역별 지가변동률 조회</option>
	<option value="4">(전국지가변동률조사)월별 지역별 지가변동률 조회</option>
	<option value="5">(전국지가변동률조사)연도별 지역별 지가변동률 조회</option>
	<option value="6">(전국지가변동률조사)이용상황별 지가지수 조회</option>
	<option value="7">(전국지가변동률조사)용도지역별 지가지수 조회</option>
	<option value="8">(전국지가변동률조사)연도별 지역별 지가지수 조회</option>
	<option value="9">(전국지가변동률조사)월별 지역별 지가지수 조회</option>
	<option value="10">(상업용부동산)순영업 소득 조회</option>
	<option value="11">(상업용부동산)지역별 유효조소득 중 영업경비 구성비 조회</option>
	
	<option value="12">(상업용부동산)지역별 유효조소득 중 기타수입 구성비 조회</option>
	<option value="13">(상업용부동산)지역별 유효조소득 중 임대수입 구성비 조회</option>
	<option value="14">(상업용부동산)지역별 연간 자본수익률 조회</option>
	<option value="15">(상업용부동산)지역별 분기 자본수익률 조회</option>
	<option value="16">(상업용부동산)지역별 연간 소득수익률 조회</option>
	<option value="17">(상업용부동산)지역별 분기 소득수익률 조회</option>
	<option value="18">(상업용부동산)지역별 연간 투자수익률 조회</option>
	<option value="19">(상업용부동산)지역별 분기 투자수익률 조회</option>
	<option value="20">(상업용부동산)지역별 전환율 조회</option>
	<option value="21">(상업용부동산)층별 효용비율 조회</option>
	<option value="22">(상업용부동산)층별 임대료 조회</option>
	<option value="23">(상업용부동산)지역별 임대료 조회</option>
	<option value="24">(상업용부동산)지역별 공실률 조회</option>
	<option value="25">(상업용부동산)지역별 임대가격지수 조회</option>
</select>
<input type="submit" value="검색">
</form>
</div>
<div style="padding: 40px 10px;">
${title}
<br/><br/>
${country}
<br/>
<c:forEach items="${rest}" var="list">
${list.temp_pk} : ${list.temp_1}<br/> 
</c:forEach>
</div>
</body>
</html>