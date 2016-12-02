$(document).ready(function(){
	$("#menuInsert").click(function(){
		$(location).attr('href',"menu_insert");
	});
	
});

function menu_update(menu_id){
	$(location).attr('href',"menu_update?menu_seq="+menu_id);
}

function menu_delete(menu_seq){
	//json으로 요청하면... 보안사항에 많이 위험할 것으로 보인다.
	//리턴값이 json이 아니어서 오류가 발생한다.
	var url=s_context_path+"/admin/menu/menu_delete.json";
	$.ajax({
		url : url,
	    data:{"menu_seq":menu_seq
	    },
	    type : "POST",
	    dataType : "json",
	    cache : false ,
	    success : function(data) {
	    	$(location).attr('href',"menu_list");
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