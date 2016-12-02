<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
 .layer_pop{
 	display:none; position: absolute; 
 	top: 20%; left: 20%; width: auto; height:auto;
 	background-color:#fff; border: 5px solid #3571B5; 
 	z-index: 10;
   }
  #confirm_status{
  	color:red;
  } 
	   
</style>
<div id="pwdPop" class="layer_pop">
	<div class="page_name">비밀번호 수정</div>
	<table class="input_form">
	<tbody>
		<tr>
			<th>비밀번호 수정</th>
			<td><input id="user_pwd" name="user_pwd" type="password"></td>
		</tr>
		<tr>
			<th>비밀번호 검증</th>
			<td><input id="confirm_pwd" name="confirm_pwd" type="password"></td>
		</tr>
		<tr>
			<td colspan="2"><label id="confirm_status">수정할 비밀번호를 입력하십시요.</label></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2"><input type="button" class="btnPwdUpdate" value="수정"><input type="button" class="pop_close" value="닫기"/></td>
		</tr>
	</tfoot>
	</table>
</div>
<script>
$(document).ready(function(){
	$("#pwdPop").hide();
	
	$(".pop_close").click(function(){
		pop_close();
	});
	
	$(".btnPwdUpdate").click(function(ev){
		var url=s_context_path+"/admin/user/user_pwd_change.json";
		var user_id = $("#user_id").val();
		var user_pwd = $("#user_pwd").val();
		var user_confirm_pwd =$("#confirm_pwd").val();
		
		console.log(user_id);
		console.log(user_pwd);
		console.log(user_confirm_pwd);
		if(user_pwd =="" || user_confirm_pwd ==""){
			$("#confirm_status").html("변경 비밀번호를 입력하지 않았습니다.");
		}else if(user_pwd == user_confirm_pwd ){
			$.ajax({
				url : url,
			    data:{"user_id":user_id,"user_pwd":user_pwd
			    },
			    type : "POST",
			    dataType : "json",
			    cache : false ,
			    success : function(data) {
			    	console.log(data.rtnMessage);
			    	//왜 jquery가 안먹힐까?
			    	$("#pwdPop").hide();
			    },error : function(data){
			    	$("#confirm_status").html("오류가 발생하였습니다.");
			    	//alert("오류가 발생하였습니다.");
			    }
			});			
		}else{
			$("#confirm_status").html("비밀번호가 같지 않습니다.");
		}
		
		
		
		$("#user_pwd").val("");
		$("#confirm_pwd").val("");
		
		ev.preventDefault();//submit작업을 막고 위에 ajax를 진행하기 위해서 넣는다.
			
	});
});

function pop_close(){
	$(".layer_pop").find("input:text, input:password").each(function(){
		$(this).val("");
	});
	
	$(".layer_pop").hide();
}
</script>