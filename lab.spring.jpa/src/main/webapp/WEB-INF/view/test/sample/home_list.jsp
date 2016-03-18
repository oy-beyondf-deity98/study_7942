<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<!-- begin #content -->
		<div id="content" class="content">
			<!-- begin breadcrumb -->
			<ol class="breadcrumb pull-right">
				<li><a href="javascript:;">Home</a></li>
				<li><a href="javascript:;">Sample</a></li>
				<li class="active">Sample List</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">Sample List</h1>
			<!-- end page-header -->
			
			<!-- begin row -->
			<div class="row">
			    <!-- begin col-12 -->
			    <div class="col-md-12">
			        <!-- begin panel -->
                    <div class="panel panel-inverse" data-sortable-id="table-basic-1">
                        <div class="panel-heading">
                            <h4 class="panel-title">Sample Table</h4>
                        </div>
                        <div class="panel-body">
                        	<form class="form-horizontal" action="/property/" method="POST">
	                        	<div class="form-group">
									<div class="col-md-2">
										<input type="email" class="form-control" placeholder="search">
									</div>
									<div class="col-md-10">
										<button type="button" class="btn btn-default m-r-5 m-b-5">검색</button>
										<button type="button" class="btn btn-default m-r-5 m-b-5">초기화</button>
										<button type="button" class="btn btn-success m-r-5 m-b-5" id="formBtn">등록</button>
									</div>
								</div>
							</form>
                            <table class="table">
                                <colgroup>
									<col style='width: 10%;' />
									<col style='width: 10%;' />
						           	<col style='width: 10%;' />
						           	<col style='width: 10%;' />
						           	<col style='width: 20%;' />
						           	<col style='width: 20%;' />
						           	<col style='width: 20%;' />
								</colgroup>
								<thead>
									<tr>
										<th>TEMP_PK</th>
										<th>TEMP_1</th>
										<th>TEMP_2</th>
										<th>TEMP_3</th>
										<th>TEMP_4</th>
										<th>TEMP_5</th>
										<th>관리</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="item" items="${list}">
									<tr>
										<td>${item.temp_pk}</td>
										<td>${item.temp_1}</td>
										<td>${item.temp_2}</td>
										<td>${item.temp_3}</td>
										<td>${item.temp_4}</td>
										<td>${item.temp_5}</td>
										<td>
											<span onclick ="fnGet_updateHomeList('${item.temp_pk}')" style="cursor:pointer;">수정</span>
											&nbsp;
											<span onclick ="fnGet_deleteHomeList('${item.temp_pk}')" style="cursor:pointer;">삭제</span>
										</td>
									</tr>				
								</c:forEach>
								</tbody>
                            </table>
                            <div style="text-align: center;">
                                <ul class="pagination pagination-lg m-t-0 m-b-10">
                                    ${navi}
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- end panel -->
			    </div>
			    <!-- end col-6 -->
			</div>
			<!-- end row -->
		</div>
		<!-- end #content -->
<!-- 등록팝업 End-->
<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="<%=pluginPath%>/color-admin/bootstrap-calendar/js/bootstrap_calendar.min.js"></script>
<script src="<%=pluginPath%>/color-admin/gritter/js/jquery.gritter.js"></script>
<script src="<%=jsPath%>/color-admin/apps.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->	
<script>
		$(document).ready(function() {
			App.init();
		});
	</script>
<script type="text/javascript" src="<%=jsPath%>/routine/home/home.js"></script>