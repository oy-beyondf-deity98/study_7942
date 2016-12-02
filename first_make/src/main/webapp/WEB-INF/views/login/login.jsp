<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/common.jsp"%>
<%@ include file="../inc/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="${contextPath}/resources/plugin/login/css/font-awesome.min.css">
<link rel="stylesheet" href="${contextPath}/resources/plugin/login/css/style.css">
<script type="text/javascript">
$(document).ready(function() {
	$("#loginCheck").click(function(){
		loginCheck();
	});
	
	$("#user_pwd, #user_id").keydown(function (key) {
	    if (key.keyCode == 13) {
	    	loginCheck();
	    }
	});
});

function loginCheck(){
	var url = $("#selectUrl").val();
	var user_id = $("#user_id").val();
	var user_pwd = $("#user_pwd").val();
	var selectUrl = $("#selectUrl").val();
	
	if(user_id == ""){
		alert("아이디를 입력하세요.");
		$("#user_id").focus();
	}else if(user_pwd == ""){
		alert("비밀번호를 입력하세요.");
		$("#user_pwd").focus();
	}else{
		$("#loginForm").attr('action', "${contextPath}/login");
		$("#loginForm").submit();
	}
}
</script>
</head>

<body>
	<form method="post" action="" id="loginForm" name="loginForm">
	<div class="wrap">
		<article class="loginPanel">
			
			<div>
				<span>${message}</span>
				 <h1>Platform Building Example</h1> 
				<ul>
					<li>
						<div class="login_txt">
							ID
						</div>
						<div class="input_gup clear">
							<div class="login_id">
								<input type="text" placeholder="아이디" id="user_id" name="user_id" value="admin">
							</div>
						</div>
					</li>
					<li>
						<div class="login_txt">
							Password
						</div>
						<div class="input_gup clear">
							<div class="login_id">
								<input type="password" placeholder="비밀번호" id="user_pwd" name="user_pwd" value="1111">
							</div>
						</div>
					</li>
				</ul>
 				<div class="controlPanel"> 
 					<div class="inputCheck"> 
 						<input type="checkbox" value="None" id="inputCheck" name="check" checked> 
 						<label for="inputCheck"></label> 
 					</div> 
 					<span>아이디 저장</span>
					<button type="button" class="hotpink btn-login" id="loginCheck">
					Login
					</button>
 				</div> 
			</div>
		</article>
		<article class="login-copy">
			<footer>
				<small>Copyright © VERTEXID. All rights reserved.</small>
			</footer>
		</article>
	</div>
	</form>
</body>
</html>