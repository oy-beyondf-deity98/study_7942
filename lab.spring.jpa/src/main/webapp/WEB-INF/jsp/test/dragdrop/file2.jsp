<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<title>HTML5 File example</title>

<style type="text/css">
<!--
	TD{font-family: Arial, Helvetica, sans-serif; font-size: 8pt;}

	.tableheader {
		background-color: #FFFFFF;
		background-image: url(https://www.ibm.com/i/v16/t/sprites-t1.gif);
		background-repeat: repeat-x;
		background-position: 0px -545px;
		padding-left: 10px;
		font-weight: bold;
		border-top-width: 0px;
		border-right-width: 0px;
		border-bottom-width: 1px;
		border-left-width: 0px;
		border-top-style: none;
		border-right-style: none;
		border-bottom-style: solid;
		border-left-style: none;
		border-top-color: #FFFFFF;
		border-bottom-color: #cccccc;
		font-size: 12px;
	}
	.tablepadding {
		margin: 0px;
		padding-top: 0px;
		padding-right: 10px;
		padding-bottom: 0px;
		padding-left: 10px;
		border-top-width: 0px;
		border-right-width: 0px;
		border-bottom-width: 0px;
		border-left-width: 0px;
		border-top-style: none;
		border-right-style: none;
		border-bottom-style: none;
		border-left-style: none;
		font-family: Arial, Helvetica, sans-serif;
		font-size: 12px;
	}
	
	.tableborder {
		border: 1px solid #cccccc;
	}
	
	
	.images { 
	        height:75px;
	        width:75px; 
	        border:0px; 
	        margin:15px 15px 0 0; 
	}
	table, td
	{
	    border-color: #e6e6e6;
	    border-style: solid;
	}
-->
</style>

  
<script>
	function imagesSelected(myFiles) {
	  for (var i = 0, f; f = myFiles[i]; i++) {
	    var imageReader = new FileReader();
	    imageReader.onload = (function(aFile) {
	      return function(e) {
	        var span = document.createElement('span');
	        span.innerHTML = ['<img class="images" src="', e.target.result,'" title="', aFile.name, '"/>'].join('');
	        document.getElementById('thumbs').insertBefore(span, null);
	      };
	    })(f);
	    imageReader.readAsDataURL(f);
	  }
	}
	
	function dropIt(e) {  
	   imagesSelected(e.dataTransfer.files); 
	   e.stopPropagation();  
	   e.preventDefault();   
	}  
</script>

<body>
	* 크롬과 파이어폭스까지 되고 UI도 깔끔하지만.. 크롬과 파이어폭스까지 밖에 안된다는 거~
	<center>
	<table width="485" border="1" cellspacing="0" cellpadding="5">
		<tbody>
		<tr bgcolor="#F2F2F2">
			<td class="tableheader" align="left">
			<p>Thumbnail palette</p>
			</td>
		</tr>
		<tr>
			<td align="left" height="105" ondragenter="return false" ondragover="return false" ondrop="dropIt(event)">    
			<output id="thumbs"></output> 
			</td>
		</tr>
		<tr>
			<td align="center">
			<p>Drag &amp; drop or choose images from your local file system: <input type="file" id="input" size="10" multiple="true" onchange="imagesSelected(this.files)"></p>
			</td>
		</tr>
		</tbody>
	</table>
	</center>

</body>
</html>