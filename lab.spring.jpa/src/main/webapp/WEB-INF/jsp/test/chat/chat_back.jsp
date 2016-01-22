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
			.guide_label {height:20px;border:1;font-size:7px}
			.guide_label2 {height:20px;width:90px;border:1;font-size:7px;filter:alpha(opacity:.3)}
			.guide_input {height:20px;width:20px;border:2;font-size:7px;background:#fffff}
			#user_message {height:80px;width:450px;background:#0099ff}
			#par {
				position:relative;
			}
			#guide {
				position:absolute;
				left:301px;
				top:0px;
				height:80px;
				width:160px;
				overflow-x:hidden;
				overflow-y:scroll;
				background-image:url('/life/image/guide.jpg');
				background-size: 160px 80px;
				background-repeat: no-repeat;
			
			}
				
		</style>        
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<!-- script type="text/javascript" src="/life/js/turn.min.js"></script-->
		<script>
		    function request(){
		    	
		    	//http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo
		        //var url = "/life/test.json?callback=?";
		        //http://61.250.201.170:8182
		        var url = "/chat/typing";
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
		            	$('#screen').animate({scrollTop:"+=100"},400);
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
            	$('#screen').append("<div class='screen_system'>"+message+"</div>");
            	
            	$('#screen').animate({scrollTop:"+=100"},400);
		    }
		    
		   
		    
		    function readData(){
		        var org = $('#screen').html();
		        var addText = $('#user_message').val();
		        $('#screen').append("<label class='screen_user'>"+addText +"</label></p>");
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
	<div id="screen" name="screen"></div>
	<div id="par"><textarea id="user_message" cols="30"></textarea></div>
</body>

</html>