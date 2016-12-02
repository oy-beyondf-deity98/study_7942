<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="${pluginPath}/jstree/jstree.min.js"></script>
<link href="${pluginPath}/jstree/themes/default/style.min.css" rel="stylesheet" />
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
<!-- 엑박버턴을 넣어서 닫히게 하자. -->
<div id="menuTreePop" class="layer_pop">
	<div class="page_name">메뉴리스트-트리</div>
	<div id="jstree-default"></div>
	<div><input type="button" class="pop_close" value="닫기"/></div>
</div>
<script>
$(document).ready(function(){
	$("#menuTreePop").hide();
	//fnGet_tree();
	
	$(".pop_close").click(function(){
		pop_close();
	});
	
	
});

function pop_close(){
	$(".layer_pop").hide();
}

function fnGet_tree(){
	$.ajax({
		url : s_context_path +"/admin/menu/menu_tree",
		type : "GET",
		dataType : "json",
		cache : false ,
		success : function(data){
			
			var tree_data = keyLowCase(data);
			console.log(tree_data);
			treeInit(tree_data);		
			
			//$("#menuTreePop").modal('show');
			
			$(".layer_pop").show();
		},
		error : function(data){
			alert('통신중 오류가 발생하였습니다.');
		}
	});	
}

function keyLowCase(json_data)
{
	var str = JSON.stringify(json_data);
	
    pattern = /\"([a-z0-9_-]{0,})\"\:/gi;
    str = str.replace(pattern, function() { return arguments[0].toLowerCase() });
    return  JSON.parse(str);
}

function treeInit(tree_data){
	$('#jstree-default').jstree({
        "core": {
            "data" :tree_data
        }
    });
	
	$('#jstree-default').on('select_node.jstree', function(e,data) {
		var select_node = data.node;
		$("#parent_menu_nm").val(select_node.text);
		$("#parent_menu").val(select_node.id);
		$("#menu_depth").val(parseInt(select_node.original.menu_depth)+1);
		
		$("#menuTreePop").hide();
	});
	
}
</script>