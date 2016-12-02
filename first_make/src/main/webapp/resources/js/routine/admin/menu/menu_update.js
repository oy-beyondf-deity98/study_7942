$(document).ready(function(){
	$(".close").click(function(){
		$(location).attr('href',"menu_list");
	});
	$("#select_parent").click(function(){
		fnGet_tree();
	});
});