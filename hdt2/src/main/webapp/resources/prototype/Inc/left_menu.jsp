<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page session="true" %>
<html>
<head>
	<title>HDT(Hyper Dual Tag)</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
       <div class="well sidebar-nav">
         <ul class="nav">
           <li>${param.menu}</li>
           <li class="active"><a href="#">${param.sub_menu}</a></li>
           <li><a href="#">Link</a></li>
           <li><a href="#">Link</a></li>
           <li>Sidebar</li>
           <li><a href="#">Link</a></li>
           <li><a href="#">Link</a></li>
           <li><a href="#">Link</a></li>
           <li>Sidebar</li>
           <li><a href="#">Link</a></li>
           <li><a href="#">Link</a></li>
         </ul>
       </div>
     </div>

</body>
</html>