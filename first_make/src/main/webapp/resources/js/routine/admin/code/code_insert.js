$(document).ready(function(){
	$(".close").click(function(){
		$(location).attr('href',"code_list");
	});
	$("#select_parent").click(function(){
		fnGet_Pop();
	});	
});