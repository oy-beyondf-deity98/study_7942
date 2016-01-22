<html>
<head>
	<script>
		function login(user_id){
			var form = document.loginForm;
			alert(user_id);
			form.user_id=user_id;
			
			alert(form.user_id);
			
			form.submit();
			
		}
	</script>
</head>
<body>
<h2>Hello World!</h2>
<form id="loginForm" method="post" action="http://facheck.seoulmilk.co.kr:8080/property/receiveSession">
	<input type="hidden" id="user_id" name="user_id" />
	<a href="javascript:login('950436')">일반사용자</a>
	<a href="javascript:login('892158')">관리자</a>
	<a href="javascript:login('212034')">도면관리자</a>
</form>
</body>
</html>
