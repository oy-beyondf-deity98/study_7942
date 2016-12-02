$(document).ready(function(){
	$("#codeInsert").click(function(){
		$(location).attr('href',"code_insert");
	});
	
	
});

function code_update(code){
	$(location).attr('href',"code_update?code="+code);
}

function insert_detail(code){
	$(location).attr('href',"code_insert?parent_code="+code);
}

function code_delete(code){
	//json으로 요청하면... 보안사항에 많이 위험할 것으로 보인다.
	//리턴값이 json이 아니어서 오류가 발생한다.
	var url=s_context_path+"/admin/code/code_delete.json";
	$.ajax({
		url : url,
	    data:{"code":code
	    },
	    type : "POST",
	    dataType : "json",
	    cache : false ,
	    success : function(data) {
	    	if(data.ableDelete =='Y'){
	    		alert('삭제 처리되었습니다.');
	    		$(location).attr('href',"code_list");
	    	}else{
	    		alert("하위코드가 존재하거나 lock가 걸린 코드입니다.");
	    	}
	    },error : function(data){
	    	alert("오류가발생하였습니다.");
	    }
	});
}

function move(pgNum){
	$('#currPg').val(pgNum);
	var form = document.getElementById("searchForm");
	form.submit();
}