$(document).ready(function(){
	$(".close").click(function(){
		$(location).attr("href","auth_list");
	});
	
	$("#grant").click(function (e) {
		$("#listUser").find('option:selected').remove().appendTo($("#grantUser"));
	});
	
	$("#removeGrant").click(function (e) {
		$("#grantUser").find('option:selected').remove().appendTo($("#listUser"));
	});	
	
	$("#saveAuthUser").click(function(){
		
		
		var url=s_context_path+"/admin/auth/add_user.json";
		
		var auth_seq = $("#auth_seq").val();
		var grant_user = $("#grantUser > option").map(function () {
			return this.value;
		}).get();
		
		$.ajax({
			url : url,
		    data:{"auth_seq":auth_seq,"grant_user":grant_user
		    },
		    type : "POST",
		    dataType : "json",
		    cache : false ,
		    success : function(data) {
		    	$(location).attr('href',"auth_list");
		    },error : function(data){
		    	alert("오류가 발생하였습니다.");
		    }
		});
		
	});
});

