<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
    <head>
    	<!--
    		1. 채팅프로그램  참조, 주요참조 :  http://minieetea.com/2014/04/archives/1686 
    		2. 메신저용으로 사용할때 참조해보자 : http://www.designbootstrap.com/bootstrap-chat-box-template-example
			3. 부트스트랩, 디스플레이어에 따라 다르게 반응하게 만들기 : http://maczniak.github.io/bootstrap/scaffolding.html
    	
    		* 부트스트랩없이 반응형만들기 : http://www.slideshare.net/jisuyoun/ui-29439562
    	-->
    	
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<!-- jquery, 부트스트랩에 따라서 버전이 정해져있을까? 버전확인 : http://docs.jquery.com/Downloading_jQuery -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		
		<!-- bootstrap, 앞에다가 선언해야지 css가 화면로딩시에도 적용된다.-->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		
		<link href="http://fonts.googleapis.com/css?family=Lato:900" rel="stylesheet" type="text/css">        
		
		<!-- 파일업로드 모듈 -->
		<script src="/resources/plugins/fileuploader/js/dropzone.js"></script>
		<link rel="stylesheet" href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css">
		
</head>
<body>
<input id="startDate" name="startDate" type="hidden">
<input id="field" name="field" type="hidden">
<div class="container">	
	<div id="screen" name="screen" class="panel panel-default">
		<div class="panel-heading">
			<div>요긴 타이틀</div>
			<div id="message" name="message"></div>
		</div>
		<div id="chatbody" class="panel-body chatbody">
			<div id="guide_text" name="guide_text" style="position: relative;top: 0;">채팅으로 흥하자</div>
			<ul class="chat-box"></ul>
		</div>
		<div class="panel-footer">
			<div class="input-group" >
				<span class="input-group-addon"><button class="btn btn-default" data-target="#layerpop" data-toggle="modal">파일업로드</button><button class="btn btn-default" id="typing">타자연습</button></span>
				<textarea  class="form-control user_message" id="user_message" cols="30"></textarea>
				<span class="input-group-addon">SEND</span>
			</div>		
		</div>
	</div>
 <!-- style="position: absolute;bottom: 0;" -->
</div>

<!-- 모달창 : http://hellogk.tistory.com/37 -->
<div class="modal fade" id="layerpop" >
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- header -->
      <div class="modal-header">
        <!-- 닫기(x) 버튼 -->
        <button type="button" class="close" data-dismiss="modal">×</button>
        <!-- header title -->
        <h4 class="modal-title">Header</h4>
      </div>
      <!-- body -->
      <div class="modal-body">
      	 <form action="/uploadfile" class="dropzone dz-clickable">
		 	<div class="dz-default dz-message">
		 		<span>Drop files here to upload</span>
		 	</div>
		</form>
		<input type="file" multiple="multiple" class="dz-hidden-input" style="visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;">
      </div>
      <!-- Footer -->
      <div class="modal-footer">
        Footer
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>	

<!-- 
				overflow-x:hidden;
				overflow-y:hidden;
				overflow-y:scroll;
 -->
<!-- 레이어팝업 : http://demun.tistory.com/2397 -->
</body>
		<style type="text/css">
	        .layer_fixed_top
	        {
	            width:100%;
	            color: #555;
	            font-size:12px;
	            position:fixed;
	            z-index:999;
	            top:0px;
	            left:0px;
	            -webkit-box-shadow: 0 1px 2px 0 #777;
	            box-shadow: 0 1px 2px 0 #777;
	            background-color:#ccc;
	        }		
			.user_message {height:80px;background:#0099ff}
			.chatbody {
				max-height:80%;
				min-height:400px;
				overflow-x:hidden;
				overflow-y:scroll;
			}
			
		    .chat-box {
		        display: inline-block;
		        color: #34495e;
		        margin: 0 0 30px 0;
		        width:100%;
		    }
 
			.chat-box li {
			    display: table;
			    padding: 13px;
			    margin: 7px 10px;
			    line-height: 25px;

			    -webkit-border-top-left-radius: 6px;
			    -webkit-border-top-right-radius: 6px;
			    -webkit-border-bottom-right-radius: 6px;
			    -webkit-border-bottom-left-radius: 6px;
			    -moz-border-radius-topleft: 6px;
			    -moz-border-radius-topright: 6px;
			    -moz-border-radius-bottomright: 6px;
			    -moz-border-radius-bottomleft: 6px;
			    
			    border-top-left-radius: 6px;
			    border-top-right-radius: 6px;
			    border-bottom-right-radius: 6px;
			    border-bottom-left-radius: 6px;
			}
			 
			.chat-box .odd {
			    background-color: #ecf0f1;
			    max-width: 60%;
			    clear: both;
			    float: left;
			}
			 
			.chat-box .odd:before {
			    content: ' ';
			    position: relative;
			    top: auto;
			    bottom: auto;
			    border: 12px solid;
			    border-color: transparent transparent #ecf0f1 transparent;
			    margin: 0 0 0 -24px;
			    max-width: 60%;
			    float: left;
			}
			 
			 
			.chat-box .even {
			    background-color: #C1E4EC;
			    max-width: 60%;
			    min-width: 10%;
			    height: auto;
			    clear: both;
			    float: right;
			}
			 
			.chat-box .even:after {
			    content: ' ';
			    position: relative;
			    bottom: auto;
			    border: 12px solid;
			    border-color: transparent transparent #C1E4EC transparent;
			    margin: 0 -24px 0 0;
			    max-width: 60%;
			    float: right;
			}
			 
			.chat-box li span {
			    padding: 0 0 5px;
			    color: #7f8c8d;
			    display: block;
			    word-break:break-word;
			    
			}			
				
		</style>        
		<!-- script type="text/javascript" src="/life/js/turn.min.js"></script-->
		<script>
		    function request(){
		    	
		    	//http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo
		        //var url = "/life/test.json?callback=?";
		        //http://61.250.201.170:8182
		        var url = "input/chat";
		        //var url = "http://192.168.0.10:8080/life/rest_object/todo";
		        //var url = "http://61.250.201.202:9423/life/rest_object/todo";
		        //http://192.168.0.10:8080/life/brower.html
				//urlì´ localhostë ìë¨¹ë¤? í ..?
		        $.ajax({
		            type:'GET',
		            url:url,
		            //data:'param='+$('#user_message').val()+'&userId='+$("#user",parent.document).val()+'&userPwd='+encodeURIComponent($("#userPwd",parent.document).val()),
		            data:{data:$('#user_message').val(),field:'타자'},
		            dataType:'json',
		            contentType: "application/json; charset=utf-8",
		            complete:function(){
		            	$('#user_message').val("");
		            	//$('#screen').animate({scrollTop:"+=100"},400);
		            },
		            success:function(data){
		            	var system_message ='system message';
		            	
		            	system_message = data.data;
		            	addMessage(system_message,'even');
		            	
		            },
		            error:function(){
						var system_message ='error';
		            	
						addMessage(system_message,'even');
		            }
		        });
		    }
		    
		    function addMessage(message,odd){
		    	var li_css_class = odd;
            	$('.chat-box').append("<li class='"+li_css_class+"'><span>"+message+"</span></li>");
            	
            	//$("html, body").animate({scrollTop:$(document).height()});
            	$('#chatbody').animate({scrollTop:"+=400"},400);
		    }
		    
		    function readData(){
		        var addText = $('#user_message').val();
		        
		        addMessage(addText,'odd');
		    }
		    
		    function isTypings(){
		    	var type_message = $('#field').val();
		    	
		    	if(type_message == '타자'){
		    		return true;
		    	}else{
		    		return false;	
		    	}
		    	
		    }		    
		    
		    $(document).ready(function(){
		        $('#user_message').on('keypress',function(e){
		        	
		        	if(e.which == 13){
			        	request();
			        	if(isTypings()){
			        		var elapsed = (new Date().getTime() - $('#startDate').val())/1000;
			        		var addText = "경과시간 :"+Math.floor(elapsed) + "초";
			        		addMessage(addText,'even');
			        	}else{
			        		readData();	
			        	}
		            }
		        });
		        $('#typing').on('click',function(e){
		        	var popUrl = "/typing";	//팝업창에 출력될 페이지 URL
		        	var popOption = "width=720, height=360, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
		        	window.open(popUrl,"",popOption);
		        });
		    });
		</script>
</html>