<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="true" %>
<html>
<head>
	<title>HDT(Hyper Dual Tag)</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="/hdt/resources/js/collapse.js" type="text/javascript"></script>
	<script src="/hdt/resources/js/dropdown.js" type="text/javascript"></script>
</head>
<body>
  <nav class="navbar navbar-default" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/hdt/resources/prototype/main.jsp">HDT</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      
        <li class="dropdown">
		  	<a data-toggle="dropdown"  data-target="#">입고관리</a>
		  	<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
		    	<li><a href="/hdt/resources/prototype/warehouse_in/list.jsp">입고조회</a></li>
		    </ul>
        </li>
        <li class="dropdown">
		  	<a data-toggle="dropdown"  data-target="#">재고관리</a>
		  	<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
		    	<li><a href="/hdt/resources/prototype/stock/list.jsp">창고별제품조회</a></li>
		    	<li><a href="/hdt/resources/prototype/stock/list.jsp">제품별창고조회</a></li>
		    </ul>
        </li>
        <li class="dropdown">
		  	<a data-toggle="dropdown"  data-target="#">출고관리</a>
		  	<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
		    	<li><a href="/hdt/resources/prototype/delivery/list.jsp">발주내역조회</a></li>
		    	<li><a href="/hdt/resources/prototype/delivery/list.jsp">출고조회</a></li>
		    </ul>
        </li>                
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
        	<a data-toggle="dropdown"  data-target="#">Admin</a>
		  	<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
		    	<li><a href="/hdt/resources/prototype/admin/list.jsp">공통코드관리</a></li>
		    	<li><a href="/hdt/resources/prototype/admin/list.jsp">창고관리</a></li>
		    	<li><a href="/hdt/resources/prototype/admin/list.jsp">사원관리</a></li>
		    	<li><a href="/hdt/resources/prototype/admin/list.jsp">부서관리</a></li>
		    	<li><a href="/hdt/resources/prototype/admin/list.jsp">거래처관리</a></li>
		    	<li><a href="/hdt/resources/prototype/admin/list.jsp">상품관리</a></li>
		    </ul>
		</li>
        <li><a href="#">${sessionScope.userLoginInfo.username} 님 로그인되었습니다.</a></li>
        <li><a href="./login/logout">로그아웃</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
    </nav>

</body>
</html>