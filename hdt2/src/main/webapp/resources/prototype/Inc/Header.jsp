<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8" />
<link rel='stylesheet' href='Prototype.css' type='text/css' />
<title><%=request.getParameter("title")%></title>
<script type='text/javascript'>
  window.onload = function()
                  {
                    document.getElementById('tdScreen').innerHTML = document.getElementById('divLeftContent').innerHTML;
                    document.getElementById('tdDesc').innerHTML = document.getElementById('divRightContent').innerHTML;
                  };
</script>