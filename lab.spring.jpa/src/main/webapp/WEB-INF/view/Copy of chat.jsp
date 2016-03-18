<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
    <head>
    	<!-- 오~ 채팅프로그램 http://minieetea.com/2014/04/archives/1686 -->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="http://api.mobilis.co.kr/webfonts/css/?fontface=NanumGothicWeb" rel="stylesheet" type="text/css">
		<link href="http://fonts.googleapis.com/css?family=Lato:900" rel="stylesheet" type="text/css">        
		<style type="text/css">
			#screen {height:400px;width:450px;overflow-x:hidden;overflow-y:hidden;overflow-y:scroll;padding:4px; border:1 solid #000000;}
			.screen_user {height:20px;width:450px;border:1;background:#fffff;text-align:left;float:left}
			.screen_system {height:20px;border:1;text-align:right;float:right;margin-top:20px;background:#FFEC8B;}
			#user_message {height:80px;width:450px;background:#0099ff}
			#par {
				position:relative;
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
			    font-size: 18px;
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
			 
			.chat-box .odd:after {
			    content: ' ';
			    position: relative;
			    top: auto;
			    bottom: auto;
			    border: 12px solid;
			    border-color: transparent transparent #ecf0f1 transparent;
			    margin: 0 0 0 -24px;
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
			    float: right;
			}
			 
			.chat-box li span {
			    padding: 0 0 5px;
			    color: #7f8c8d;
			    display: block;
			}			
				
		</style>        
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
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
		            	addMessage(system_message);
		            	
		            },
		            error:function(){
						var system_message ='error';
		            	
						addMessage(system_message);
		            }
		        });
		    }
		    
		    function addMessage(message){
            	$('.chat-box').append("<li>"+message+"</li>");
            	
            	$('#screen').animate({scrollTop:"+=100"},400);
		    }
		    
		    
		    function readData(){
		        //var org = $('#screen').html();
		        var addText = $('#user_message').val();
		        $('.chat-box').append("<li>"+addText +"</li>");
		        $('#screen').animate({scrollTop:"+=100"},400);
		        $('#user_message').val("");
		    }
		    
		    $(document).ready(function(){
		        $('#user_message').live('keypress',function(e){
		            if(e.which == 13){
		                request();
		                readData();
		            }
		        });
		    });
		
		</script>
</head>
<body>
	<!-- div id="guide" name="guide">타자부터</div--><div id="guide_text" name="guide_text">타자치자</div>
	<div id="screen" name="screen"><ul class="chat-box"></ul></div>
	<div id="par"><textarea id="user_message" cols="30"></textarea></div>
</body>

</html>