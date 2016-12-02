<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>${title}</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
<input type="button" id="searchObject" name="searchObject" value="단건검색">
<input type="button" id="searchList" name="searchList" value="리스트검색">
<input type="button" id="errorPop" name="errorPop" value="에러팝업확인">
</body>
</html>

<script>
	$("#searchObject").click(function(){
		$.ajax({
			url : "${contextPath}/test/ajax_get_object",
			data : {"search":"2222"},
			type : "GET",
			dataType : "json",
			cache: false,
			success : function(result) {
				if(result > 0){
					alert("삭제되었습니다.");
					//location.href=s_context_path +"/admin/menu";
				}else{
					alert("실패하였습니다.");
				}
			},error : function(data){
				alert('처리중 오류가 발생하였습니다.');
			}
		});
	});	
	
	
	$("#searchList").click(function(){
		$.ajax({
			url : "${contextPath}/test/ajax_get_list",
			data : {"search":"2222"},
			type : "GET",
			dataType : "json",
			cache: false,
			success : function(result) {
				if(result > 0){
					alert("삭제되었습니다.");
					//location.href=s_context_path +"/admin/menu";
				}else{
					alert("실패하였습니다.");
				}
			},error : function(data){
				alert('처리중 오류가 발생하였습니다.');
			}
		});
	});	
	
	$("#errorPop").click(function(){
		$.ajax({
			url : "${contextPath}/test/error_pop",
			data : {"id":"1"},
			type : "GET",
			dataType : "json",
			cache: false,
			success : function(result) {
				if(result > 0){
					alert("삭제되었습니다.");
					//location.href=s_context_path +"/admin/menu";
				}else{
					alert("실패하였습니다.");
				}
			},error : function(data){
				alert('처리중 오류가 발생하였습니다.');
			}
		});
	});
	
</script>