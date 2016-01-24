<html>
    <head>
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
			#user_message {height:80px;width:300px;background:#0099ff}
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
				background-image:url('/image/guide.jpg');
				background-size: 160px 80px;
				background-repeat: no-repeat;
			}
				
		</style>        
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script>
		    function request(){
		    	var url = "http://localhost:8080/hdt/message";
		        $.ajax({
		            type:'POST',
		            url:url,
		            data:{param:$('#user_message').val()},
		            dataType:'json',
		            //contentType: "application/json; charset=utf-8",
		            complete:function(){
		            	addReturnMessage("");
		            },
		            success:function(data){
		            	if(data.status =="로그인실패"){
		            		alert("승인받고오세요");
		            		
		            		return;
		            	}else{
		            		$('#guide_text').empty();
		            	}
		            	
		            	var description = data.description;
		            	var content = data.content;
		            	if(content == undefined || content == "undefined"){
		            	}else{
		            		var jsondata = JSON.parse(content);
		            		guide(jsondata);	
		            	}
		            	
		            	if(description == null){
		            		description = "";
		                }
		            	
		            	addReturnMessage(description);
		            	
		            },
		            error:function(){
		            	$('#screen').append("실패");
		            }
		        });
		    }
		    
		    function addReturnMessage(msg){
		    	if(msg !=""){
		    		$('#screen').append("<label class='screen_system'>"+msg+"</label>");	
		    	}
		    	
		    	$('#user_message').val("");
            	$('#screen').animate({scrollTop:"+=100"},400);
		    }
		    
		    function addUserMessage(msg){
		    	$('#screen').append("<label class='screen_user'>"+msg +"</label></p>");
		        $('#screen').animate({scrollTop:"+=100"},400);
		    }
		    
		    function readData(){
		        var org = $('#screen').html();
		        var addText = $('#user_message').val();
		        addUserMessage(addText);
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
<div id="screen" name="screen"></div>
<div id="par">
	<textarea id="user_message" cols="30"></textarea>
</div>
</body>

</html>