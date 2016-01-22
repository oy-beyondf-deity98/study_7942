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
<input type="hidden" value="${sessionScope.userLoginInfo.username}">
<h1 style="text-align:center"> 버텍스 유통 </h1>
<div class="container">
	<form class="form-signin" method="post" action="loginProcess">
	  <h2 class="form-signin-heading">Please sign in</h2>
	  <input id="id" name="id" type="text" class="form-control" placeholder="Email address" autofocus="">
	  <input pwd="pwd" name="pwd" type="password" class="form-control" placeholder="Password">
	  <label class="checkbox">
	    <input type="checkbox" value="remember-me"> Remember me
	  </label>
	  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	</form>
	<div class="panel panel-default">
	  <!-- Default panel contents -->
	  <div class="panel-heading">알림글</div>
	
	  <!-- Table -->
	  <table class="table">
	  	<tr><td>크리스마스날은 ..</td><td>2014.11.03</td></tr>
	  	<tr><td>오늘의 할일은 ....</td><td>2014.10.24</td></tr>
	  </table>
	</div>
</div>

</body>
</html>