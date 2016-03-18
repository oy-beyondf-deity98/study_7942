<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
    <head>
    	<!--
    		1. 채팅프로그램  참조, 주요참조 :  http://minieetea.com/2014/04/archives/1686 
    		2. 메신저용으로 사용할때 참조해보자 : http://www.designbootstrap.com/bootstrap-chat-box-template-example
    	-->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<!-- jquery, 부트스트랩에 따라서 버전이 정해져있을까? 버전확인 : http://docs.jquery.com/Downloading_jQuery -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		
		
		<!-- bootstrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

		
		
		
		<link href="http://fonts.googleapis.com/css?family=Lato:900" rel="stylesheet" type="text/css">        
		<style type="text/css">
			.user_message {height:80px;background:#0099ff}
			.screen {
				min-height:400px;
				overflow-x:hidden;
				overflow-y:hidden;
				overflow-y:scroll;
			}
			
		    .chat-box {
		        display: inline-block;
		        color: #34495e;
		        margin: 0 0 30px 0;
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
			}			
				
		</style>        
		<!-- script type="text/javascript" src="/life/js/turn.min.js"></script-->
		<script>
		    function request(){
		    	
		    	//http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo
		        //var url = "/life/test.json?callback=?";
		        //http://61.250.201.170:8182
		        var url = "chat/typing";
		        //var url = "http://192.168.0.10:8080/life/rest_object/todo";
		        //var url = "http://61.250.201.202:9423/life/rest_object/todo";
		        //http://192.168.0.10:8080/life/brower.html
				//urlì´ localhostë ìë¨¹ë¤? í ..?
		        $.ajax({
		            type:'GET',
		            url:url,
		            //data:'param='+$('#user_message').val()+'&userId='+$("#user",parent.document).val()+'&userPwd='+encodeURIComponent($("#userPwd",parent.document).val()),
		            data:{param:$('#user_message').val(), userId:$("#user",parent.document).val(),userPwd:$("#userPwd",parent.document).val()},
		            dataType:'json',
		            contentType: "application/json; charset=utf-8",
		            complete:function(){
		            	$('#user_message').val("");
		            	//$('#screen').animate({scrollTop:"+=100"},400);
		            },
		            success:function(data){
		            	var system_message ='system message';
		            	
		            	if(data != null){
		            		system_message = data.data;
		            	}
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
            	
            	$("html, body").animate({scrollTop:$(document).height()});
            	//$('#screen').animate({scrollTop:"+=100"},400);
		    }
		    
		    
		    function readData(){
		        //var org = $('#screen').html();
		        var addText = $('#user_message').val();
		        
		        addMessage(addText,'odd');
		        //$('.chat-box').append("<li>"+addText +"</li>");
		        //$('#screen').animate({scrollTop:"+=100"},400);
		        $('#user_message').val("");
		    }
		    
		    $(document).ready(function(){
		        $('#user_message').on('keypress',function(e){
		            if(e.which == 13){
		                request();
		                readData();
		            }
		        });
		    });
		    
		    $(window).load(function() {
		    	  $("html, body").animate({ scrollTop: $(document).height() }, 1000);
		    });
		
		</script>
</head>
<body>
<div class="container">	
	<div id="screen" name="screen" class="panel panel-default">
		<div class="panel-heading">타자를 치자</div>
		<div class="panel-body screen">
			<div id="guide_text" name="guide_text" class="panel panel-default">우선은 타자부터</div>
			<ul class="chat-box"></ul>
		
		</div>
		<div class="panel-footer">
			<div class="input-group"><textarea  class="form-control user_message" id="user_message" cols="30"></textarea>
				<span class="input-group-addon">SEND</span>
			</div>		
		</div>
	</div>

	<!-- 
		1. 화면이 줄어듬에 따라서 UL이 줄어들고, 밑에 입력하는 부분이 따라와야함. 헤더도 따라와야함
		2. 초기에 일정크기를 유지해야함.  
	
	-->
</div>	
</body>

</html>