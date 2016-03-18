<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
	<script>
		function login(user_id){
			var doc = document.loginForm;
			//alert(user_id);
			
			//alert(doc);
			//form.user_id=user_id;
			
			//alert(form.user_id);
			
			doc.submit();
			
		}
	</script>
</head>
<body>
<h2>Hello World!</h2>
<form id="loginForm" target="_blank" method="post" action="http://facheck.seoulmilk.co.kr:8080/property/receiveSession">
	<select id="user_id" name="user_id">
		<option  value="950436">일반사용자</option>
		<option  value="892158">관리팀</option>
		<option  value="212034">도면관리팀</option>
	</select>
	
	<button>로그인</button>
	
</form>
</body>
</html>
