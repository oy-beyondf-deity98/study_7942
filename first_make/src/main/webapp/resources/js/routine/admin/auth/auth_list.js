$(document).ready(function(){
	$("#authInsert").click(function(){
		$(location).attr('href',"auth_insert");
	});
	
});

function auth_update(auth_seq){
	$(location).attr('href',"auth_update?auth_seq="+auth_seq);
}

function add_user(auth_seq){
	$(location).attr('href',"add_user?auth_seq="+auth_seq);
}

function add_menu(auth_seq){
	$(location).attr('href',"add_menu?auth_seq="+auth_seq);
}

function auth_delete(auth_seq){
	//json으로 요청하면... 보안사항에 많이 위험할 것으로 보인다.
	//리턴값이 json이 아니어서 오류가 발생한다.
	var url=s_context_path+"/admin/auth/auth_delete.json";
	$.ajax({
		url : url,
	    data:{"auth_seq":auth_seq
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
}



function move(pgNum){
	$('#currPg').val(pgNum);
	var form = document.getElementById("searchForm");
	form.submit();
}