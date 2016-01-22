<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="true" %>
<html>
<head>
	<title>HDT(Hyper Dual Tag)</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="./resources/js/collapse.js" type="text/javascript"></script>
</head>
<body>
  <div class="container-fluid">
  <nav class="navbar navbar-default" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">HDT</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">입고관리</a></li>
        <li><a href="#">출고관리</a></li>
        <li><a href="#">제품관리</a></li>
        <li><a href="#">관리자</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">MyPage </a></li>
        <li><a href="#">${sessionScope.userLoginInfo.username} 님 로그인되었습니다.</a></li>
        <li><a href="./login/logout">로그아웃</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
    </nav>
  </div><!-- /.container-fluid -->

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>