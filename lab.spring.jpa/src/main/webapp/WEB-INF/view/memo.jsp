<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <script src="http://code.jquery.com/jquery.min.js"></script>
    <title>DaumEditor Test Suite - QA</title>
	
 	<script>
 	$(document).ready(function(){
 		$("#save").click(function(){
 			var url = "/input/memo";
	        $.ajax({
	            type:'POST',
	            url:url,
	            data:{input_memo:Editor.getContent()},
	            dataType:'json',
	            contentType: "application/json; charset=utf-8",
	            success:function(data){
	            },
	            error:function(){
	            	alert("오류가 발생했습니다.");
	            }
	        });
 		});
 		
 		$("#pushImage").click(function(){
 			var imgSrc = "http://dvdprime.donga.com/g5/data/file/comm/3690922372_laHYJn0R_718e4f7f78a8ae0fb70ad6d35904bc2a_1429798202_0596.jpg";
 			var img = '<img src="'+imgSrc+'" class="txc-image" >';
 			
 			Editor.getCanvas().pasteContent(img);
 		});
 		
 		//다운로드 가능하도록.. 해야하지 않을까?
 		$("#pushFile").click(function(){
 			var file_href = "http://dvdprime.donga.com/g5/data/file/comm/3690922372_laHYJn0R_718e4f7f78a8ae0fb70ad6d35904bc2a_1429798202_0596.jpg";
 			var file_name = "파일명";
 			var img = '<p><a href="'+file_href+'" class="txc-image" >'+file_name+'</a></p><br>';
 			
 			Editor.getCanvas().pasteContent(img);
 		});
 		$("#pushMultiMediaFile").click(function(){
 			
 			var url = "https://www.youtube.com/watch?v=RLVu-Ppa5Sw";
 			//var file_name = "멀티미디어";
 			//var img = '<p><br></p><p><iframe src="'+url+'" width="640" height="360" frameborder="0" allowfullscreen=""></iframe></p><p><br></p>';
 			done(url);
 			//Editor.getCanvas().pasteContent(img);
 		});
 	});
 	
 	function initEmbeder() {
		var _opener = PopupUtil.getOpener();
		if(!_opener) {
			alert('잘못된 경로로 접근하셨습니다.');
			return; 
		}

		var _embeder = getEmbeder('media');
		window.execEmbed = _embeder.embedHandler;
		
		autoResizeHeight($tx("wrapper"));
	}
	
	// 코드 삽입 완료 후
	function done(url) {
		var _data = {};
		var types = "url";//document.getElementsByName("codeType");
		if (types[1].checked) {
			_data.url = document.getElementsByName("url")[0].value.trim();
		} else if (types[0].checked) {
			
		}
		_data.url = url
		_data.code = null;
		if (typeof(execEmbed) == 'undefined') { //Virtual Function
	        return;
	    }
		executeAfterDataCheck(_data, function(){
			execEmbed(_data);
	    }); 
	}

	function executeAfterDataCheck(data, successHandler) {
		if (data.url || data.code) {
			successHandler();
		} else {
			alert("첨부할 멀티미디어 주소를 바르게 입력해주세요.");
		}
	}
 		
 	</script>
</head>
<body class="flora">
<!-- firefox 에서 fixtures 를 display:none; 해버리면 selection 얻어오지 못하는 문제가 있다. -->
<div id="fixtures" style="overflow: hidden; position: relative;">
    <form name="tx_editor_form" id="tx_editor_form" action="register.html?ver=5.1.0" method="post" accept-charset="utf-8">
    <div class="wrapper">
        <div class="field">
            <!-- 제목, 카테고리 영역 시작 -->
            <select name="tx_article_category" id="tx_article_category" style="width:150px;">
                <option value="0">카테고리 선택</option>
                <option value="1">나의 이야기 </option>
                <option value="2">너의 이야기 </option>
                <option value="3">우리들의 이야기 </option>
            </select>
            <input type="text" name="tx_article_title" id="tx_article_title" value="제목 테스트" size="80"/>
            <!-- 제목, 카테고리 영역 끝 -->
        </div>
        <jsp:include page="./daumeditor.jsp"></jsp:include>
        <input type="button" value="저장" id="save">
        <input type="button" value="그림삽입" id="pushImage">
        <input type="button" value="파일첨부" id="pushFile">
        <input type="button" value="멀티미디어" id="pushMultiMediaFile">
    </div>
    </form>
</div>


</body>
</html>