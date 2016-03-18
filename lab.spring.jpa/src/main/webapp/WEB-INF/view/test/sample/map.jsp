<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="http://openapi.map.naver.com/openapi/naverMap.naver?ver=2.0&key=dd97a1ffb49444c883277a34ef0e8a57"></script>
<div id = "testMap" style="border:1px solid #000; width:1200px; height:600px;"></div>
<script type="text/javascript">
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
</body>
</html>
