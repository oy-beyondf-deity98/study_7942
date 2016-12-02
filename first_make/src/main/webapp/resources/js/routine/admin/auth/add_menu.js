$(document).ready(function(){
	$(".close").click(function(){
		$(location).attr("href","auth_list");
	});
	
	$("#add").click(function (e) {
		$("#listMenu").find('option:selected').remove().appendTo($("#objectMenu"));
	});
	
	$("#remove").click(function (e) {
		$("#objectMenu").find('option:selected').remove().appendTo($("#listMenu"));
	});	
	
	$("#saveAuthMenu").click(function(){
		
		
		var url=s_context_path+"/admin/auth/add_menu.json";
		
		var auth_seq = $("#auth_seq").val();
		var object_menu = $("#objectMenu > option").map(function () {
			return this.value;
		}).get();//TODO array값 저장하기 딱좋네~
		
		
		$.ajax({
			url : url,
		    data:{"auth_seq":auth_seq,"object_menu":object_menu
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

