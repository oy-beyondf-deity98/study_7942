$(document).ready(function(){
	$("#userInsert").click(function(){
		$(location).attr('href',"user_insert");
	});
	
});

function user_update(user_id){
	$(location).attr('href',"user_update?user_id="+user_id);
}

function user_delete(user_id){
	//json으로 요청하면... 보안사항에 많이 위험할 것으로 보인다.
	//리턴값이 json이 아니어서 오류가 발생한다.
	var url=s_context_path+"/admin/user/user_delete.json";
	$.ajax({
		url : url,
	    data:{"user_id":user_id
	    },
	    type : "POST",
	    dataType : "json",
	    cache : false ,
	    success : function(data) {
	    	$(location).attr('href',"user_list");
	    },error : function(data){
	    	alert("오류가 발생하였습니다.");
	    }
	});
}

function move(pgNum){
	$('#currPg').val(pgNum);
	var form = document.getElementById("searchForm");
	form.submit();
}