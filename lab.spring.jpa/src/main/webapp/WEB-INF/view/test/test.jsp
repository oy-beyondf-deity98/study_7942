<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
	<title> 테스트페이지 </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="generator" content="editplus">
	<meta name="author" content="">
	<meta name="keywords" content="">
	<meta name="description" content="">
		<script src="http://code.jquery.com/jquery.min.js"></script>
	<script>
		
		
		
		$(document).ready(function(){
			$("#httpInputString").on("keypress",function(){
				alert('keypress');
			});
			$("#httpInputString").on("keyup",function(){
				alert('keyup');
			});
			$("#httpInputString").on("keydown",function(){
				alert('keydown');
			});			
			
		});
		

	</script>

</head>
<body>
	<input type="text" id="httpInputString">
	
</body>
</html>