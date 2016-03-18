<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<link href="<%=pluginPath%>/color-admin/jstree/dist/themes/default/style.min.css" rel="stylesheet" />

<div id="content" class="content">
	<ol class="breadcrumb pull-right">
		<li><a href="javascript:;">Home</a></li>
		<li class="active">Main</li>
	</ol>
	<h1 class="page-header">재산현황 <small>재산현황 정보</small></h1>
	
	<div class="row">
		<div class="col-md-3 col-sm-6">
			<div class="widget widget-stats bg-green">
				<div class="stats-icon"><i class="fa fa-desktop"></i></div>
				<div class="stats-info">
					<h4>재산정보</h4>
					<p>서울우유 사무동</p>	
				</div>
				<div class="stats-link">
					<a href="javascript:;">&nbsp;</a>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-6">
			<div class="widget widget-stats bg-blue">
				<div class="stats-icon"><i class="fa fa-list"></i></div>
				<div class="stats-info">
					<h4>자산수량</h4>
					<p>10건</p>	
				</div>
				<div class="stats-link">
					<a href="javascript:;">View Detail <i class="fa fa-arrow-circle-o-right"></i></a>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-6">
			<div class="widget widget-stats bg-purple">
				<div class="stats-icon"><i class="fa fa-won"></i></div>
				<div class="stats-info">
					<h4>취득원가</h4>
					<p>200원</p>	
				</div>
				<div class="stats-link">
					<a href="javascript:;">View Detail <i class="fa fa-arrow-circle-o-right"></i></a>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-6">
			<div class="widget widget-stats bg-red">
				<div class="stats-icon"><i class="fa fa-bank"></i></div>
				<div class="stats-info">
					<h4>공시지가(㎡/원)</h4>
					<p>200원</p>	
				</div>
				<div class="stats-link">
					<a href="javascript:;">View Detail <i class="fa fa-arrow-circle-o-right"></i></a>
				</div>
			</div>
		</div>
	</div>
			
	<div class="row">
		<div class="col-md-3">
			<div class="panel panel-inverse">
				<div class="panel-heading">
					<h4 class="panel-title">재산 리스트</h4>
				</div>
				<div class="panel-body">
					<div id="jstree-default">
						<ul>
							<li data-jstree='{"opened":true}' >
								Root node 1
								<ul>
									<li data-jstree='{"opened":true, "selected":true }'>Initially Selected</li>
									<li>Folder 1</li>
									<li>Folder 2</li>
									<li>Folder 3</li>
									<li data-jstree='{"opened":true}' >
										Initially open
										<ul>
											<li data-jstree='{"disabled":true}' >Disabled node</li>
											<li>Another node</li>
										</ul>
									</li>
									<li data-jstree='{ "icon" : "fa fa-warning fa-lg text-danger" }'>custom icon class (fontawesome)</li>
									<li data-jstree='{ "icon" : "fa fa-link fa-lg text-primary" }'><a href="http://www.jstree.com">Clickable link node</a></li>
								</ul>
							</li>
							<li>Root node 2</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-md-5">
			<div class="panel panel-inverse" id="aaa">
				<div class="panel-heading">
					<div class="panel-heading-btn">
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a>
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
					</div>
					<h4 class="panel-title">토지</h4>
				</div>
				<div class="panel-body">
					<ul class="nav nav-tabs">
						<li class=""><a href="#default-tab-1" data-toggle="tab" aria-expanded="false">요약정보</a></li>
						<li class=""><a href="#default-tab-2" data-toggle="tab" aria-expanded="false">상세정보</a></li>
						<li class="active"><a href="#default-tab-3" data-toggle="tab" aria-expanded="true">기타 등등</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane fade" id="default-tab-1">
							<h3 class="m-t-10"><i class="fa fa-cog"></i> Lorem ipsum dolor sit amet</h3>
							<p>
								Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
								Integer ac dui eu felis hendrerit lobortis. Phasellus elementum, nibh eget adipiscing porttitor, 
								est diam sagittis orci, a ornare nisi quam elementum tortor. Proin interdum ante porta est convallis 
								dapibus dictum in nibh. Aenean quis massa congue metus mollis fermentum eget et tellus. 
								Aenean tincidunt, mauris ut dignissim lacinia, nisi urna consectetur sapien, nec eleifend orci eros id lectus.
								
							</p>
						</div>
						<div class="tab-pane fade overflow-y-scroll" id="default-tab-2" style="height:200px;">
							<blockquote>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
								<small>Someone famous in <cite title="Source Title">Source Title</cite></small>
							</blockquote>
							<h4>Lorem ipsum dolor sit amet</h4>
							<p>
								Nullam ac sapien justo. Nam augue mauris, malesuada non magna sed, feugiat blandit ligula. 
								In tristique tincidunt purus id iaculis. Pellentesque volutpat tortor a mauris convallis, 
								sit amet scelerisque lectus adipiscing.
							</p>
							<h4>Lorem ipsum dolor sit amet</h4>
							<p>
								Nullam ac sapien justo. Nam augue mauris, malesuada non magna sed, feugiat blandit ligula. 
								In tristique tincidunt purus id iaculis. Pellentesque volutpat tortor a mauris convallis, 
								sit amet scelerisque lectus adipiscing.
							</p>
							<h4>Lorem ipsum dolor sit amet</h4>
							<p>
								Nullam ac sapien justo. Nam augue mauris, malesuada non magna sed, feugiat blandit ligula. 
								In tristique tincidunt purus id iaculis. Pellentesque volutpat tortor a mauris convallis, 
								sit amet scelerisque lectus adipiscing.
							</p>
							<h4>Lorem ipsum dolor sit amet</h4>
							<p>
								Nullam ac sapien justo. Nam augue mauris, malesuada non magna sed, feugiat blandit ligula. 
								In tristique tincidunt purus id iaculis. Pellentesque volutpat tortor a mauris convallis, 
								sit amet scelerisque lectus adipiscing.
							</p>
						</div>
						<div class="tab-pane fade active in" id="default-tab-3">
							<p>
								<span class="fa-stack fa-4x pull-left m-r-10">
									<i class="fa fa-square-o fa-stack-2x"></i>
									<i class="fa fa-twitter fa-stack-1x"></i>
								</span>
								Praesent tincidunt nulla ut elit vestibulum viverra. Sed placerat magna eget eros accumsan elementum. 
								Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam quis lobortis neque. 
								Maecenas justo odio, bibendum fringilla quam nec, commodo rutrum quam. 
								Donec cursus erat in lacus congue sodales. Nunc bibendum id augue sit amet placerat. 
								Quisque et quam id felis tempus volutpat at at diam. Vivamus ac diam turpis.Sed at lacinia augue. 
								Nulla facilisi. Fusce at erat suscipit, dapibus elit quis, luctus nulla. 
								Quisque adipiscing dui nec orci fermentum blandit.
								Sed at lacinia augue. Nulla facilisi. Fusce at erat suscipit, dapibus elit quis, luctus nulla. 
								Quisque adipiscing dui nec orci fermentum blandit.
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="panel panel-inverse"  id="bbb">
				<div class="panel-heading">
					<div class="panel-heading-btn">
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a>
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
						<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
					</div>
					<h4 class="panel-title">건물/구축물</h4>
				</div>
				<div class="panel-body">
					<ul class="nav nav-tabs">
						<li class=""><a href="#default-tab-11" data-toggle="tab" aria-expanded="true">요약정보</a></li>
						<li class=""><a href="#default-tab-21" data-toggle="tab" aria-expanded="false">상세정보</a></li>
						<li class="active"><a href="#default-tab-31" data-toggle="tab" aria-expanded="false">기타 등등</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane fade" id="default-tab-11">
							<h3 class="m-t-10"><i class="fa fa-cog"></i> Lorem ipsum dolor sit amet</h3>
							<p>
								Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
								Integer ac dui eu felis hendrerit lobortis. Phasellus elementum, nibh eget adipiscing porttitor, 
								est diam sagittis orci, a ornare nisi quam elementum tortor. Proin interdum ante porta est convallis 
								dapibus dictum in nibh. Aenean quis massa congue metus mollis fermentum eget et tellus. 
								Aenean tincidunt, mauris ut dignissim lacinia, nisi urna consectetur sapien, nec eleifend orci eros id lectus.
								
							</p>
						</div>
						<div class="tab-pane fade overflow-y-scroll" id="default-tab-21" style="height:200px;">
							<blockquote>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
								<small>Someone famous in <cite title="Source Title">Source Title</cite></small>
							</blockquote>
							<h4>Lorem ipsum dolor sit amet</h4>
							<p>
								Nullam ac sapien justo. Nam augue mauris, malesuada non magna sed, feugiat blandit ligula. 
								In tristique tincidunt purus id iaculis. Pellentesque volutpat tortor a mauris convallis, 
								sit amet scelerisque lectus adipiscing.
							</p>
							<h4>Lorem ipsum dolor sit amet</h4>
							<p>
								Nullam ac sapien justo. Nam augue mauris, malesuada non magna sed, feugiat blandit ligula. 
								In tristique tincidunt purus id iaculis. Pellentesque volutpat tortor a mauris convallis, 
								sit amet scelerisque lectus adipiscing.
							</p>
							<h4>Lorem ipsum dolor sit amet</h4>
							<p>
								Nullam ac sapien justo. Nam augue mauris, malesuada non magna sed, feugiat blandit ligula. 
								In tristique tincidunt purus id iaculis. Pellentesque volutpat tortor a mauris convallis, 
								sit amet scelerisque lectus adipiscing.
							</p>
							<h4>Lorem ipsum dolor sit amet</h4>
							<p>
								Nullam ac sapien justo. Nam augue mauris, malesuada non magna sed, feugiat blandit ligula. 
								In tristique tincidunt purus id iaculis. Pellentesque volutpat tortor a mauris convallis, 
								sit amet scelerisque lectus adipiscing.
							</p>
						</div>
						<div class="tab-pane fade active in" id="default-tab-31">
							<p>
								<span class="fa-stack fa-4x pull-left m-r-10">
									<i class="fa fa-square-o fa-stack-2x"></i>
									<i class="fa fa-twitter fa-stack-1x"></i>
								</span>
								Praesent tincidunt nulla ut elit vestibulum viverra. Sed placerat magna eget eros accumsan elementum. 
								Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam quis lobortis neque. 
								Maecenas justo odio, bibendum fringilla quam nec, commodo rutrum quam. 
								Donec cursus erat in lacus congue sodales. Nunc bibendum id augue sit amet placerat. 
								Quisque et quam id felis tempus volutpat at at diam. Vivamus ac diam turpis.Sed at lacinia augue. 
								Nulla facilisi. Fusce at erat suscipit, dapibus elit quis, luctus nulla. 
								Quisque adipiscing dui nec orci fermentum blandit.
								Sed at lacinia augue. Nulla facilisi. Fusce at erat suscipit, dapibus elit quis, luctus nulla. 
								Quisque adipiscing dui nec orci fermentum blandit.
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
		</div>
		<div class="col-md-9">
			<div class="panel panel-inverse">
				<div class="panel-heading">
					<div class="panel-heading-btn">
							<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
							<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a>
							<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
							<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
						</div>
						<h4 class="panel-title">지도</h4>
					</div>
					<div class="panel-body" id="testMap" style="height:auto;">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>			

<script src="<%=pluginPath%>/color-admin/jstree/dist/jstree.min.js"></script>
<script src="<%=jsPath%>/color-admin/ui-tree.demo.min.js"></script>
<script src="<%=jsPath%>/color-admin/apps.js"></script>
<script type="text/javascript" src="http://openapi.map.naver.com/openapi/naverMap.naver?ver=2.0&key=dd97a1ffb49444c883277a34ef0e8a57"></script>
<script>
$(document).ready(function() {
	App.init();
	TreeView.init();
	handleDraggablePanel("aaa");
	handleDraggablePanel("bbb");
});

var oPoint = new nhn.api.map.LatLng(37.5010226, 127.0396037);
nhn.api.map.setDefaultPoint('LatLng');
oMap = new nhn.api.map.Map('testMap' ,{
		point : oPoint,
		zoom : 10,
		enableWheelZoom : true,
		enableDragPan : true,
		enableDblClickZoom : false,
		mapMode : 0,
		activateTrafficMap : false,
		activateBicycleMap : false,
		minMaxLevel : [ 1, 14 ],
		size : new nhn.api.map.Size(1200, 600)
});
var mapZoom = new nhn.api.map.ZoomControl(); // - 줌 컨트롤 선언
mapZoom.setPosition({left:20, bottom:20}); // - 줌 컨트롤 위치 지정

var mapTypeChangeButton = new nhn.api.map.MapTypeBtn(); // - 지도 타입 버튼 선언
mapTypeChangeButton.setPosition({right:10, bottom:10}); // - 지도 타입 버튼 위치 지정

var oSize = new nhn.api.map.Size(28, 37);                        
var oOffset = new nhn.api.map.Size(14, 37);                        
var oIcon = new nhn.api.map.Icon('http://static.naver.com/maps2/icons/pin_spot2.png', oSize, oOffset);     
                 
var oMarker = new nhn.api.map.Marker(oIcon, {
   point : oPoint,
   title : "여기다"
  }); 

var oLabel1 = new nhn.api.map.MarkerLabel(); // 마커 라벨 선언
oMap.addOverlay(oLabel1);// 마커 라벨 지도에 추가. 기본은 라벨이 보이지 않는 상태로 추가됨
oLabel1.setVisible(true, oMarker);// 마커 라벨 보이기 

oMap.addControl(mapZoom); // - 줌 컨트롤 추가.
oMap.addControl(mapTypeChangeButton); // - 지도 타입 버튼 추가
oMap.addOverlay(oMarker);
</script>