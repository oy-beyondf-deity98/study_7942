<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>${title}</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
</head>
<body>
	<!-- 상단 BUTTON 태그클릭시 보여줄 레이어팝업 태그  -->
	<div id="dialog" title="레이어팝업 제목">
		해당부분은 레이어 팝업의 내용이다. br태그없이 알아서 자동 줄바꿈 처리가 되있음....
	</div>
	<input type="button" id="button" value="레이어팝업띄우기">
	
</body>
<script>
	$( "#dialog" ).dialog({
	//이벤트 발생했을때 보여주려면 autoOpen : false로 지정해줘야 한다.
	autoOpen: false,
	//레이어팝업 넓이
	width: 400,
	//뒷배경을 disable 시키고싶다면 true
	modal: true,
	//버튼종류
	buttons: [
		{
			//버튼텍스트
			text: "Ok",
			//클릭이벤트발생시 동작
			click: function() {
				$( this ).dialog( "close" );
			}
		},
		{
			//버튼텍스트
			text: "Cancel",
			//클릭이벤트발생시 동작
			click: function() {
				$( this ).dialog( "close" );
			}
		}
	]
});

$("#button").click(function(){
	 $( "#dialog" ).dialog( "open" );
});
</script>
</html>

