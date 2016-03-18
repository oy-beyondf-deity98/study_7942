<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 참조 : http://www.dropzonejs.com/ -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">


<title>Dropzone simple example</title>
<script src="/js/dropzone.js"></script>
<link rel="stylesheet" href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css">

</head>
<body data-feedly-mini="yes">
<!-- Change /upload-target to your upload address -->
	<form action="/uploadfile" class="dropzone dz-clickable">
		<div class="dz-default dz-message">
			<span>Drop files here to upload</span>
		</div>
	</form>
	<input type="file" multiple="multiple" class="dz-hidden-input" style="visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;">
	
</body>
</html>