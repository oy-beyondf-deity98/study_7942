<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!-- 먼저 Spring Form Tag를 사용하기 위해 taglib 한줄 추가한다. -->

<!DOCTYPE HTML>
<html>
<head>
<style>
/* 드래그해 놓을 상자의 모양을 정합니다. 지금은 신경쓰지 않으셔도 됩니다. */
/**
	1. 간단하게 따라해 보기 : http://sergeswin.com/1032, 원리를 잠깐 살펴보자.
	2. 셀렉트박스에 대한 예제 : http://m.mkexdev.net/58, 드래그앤드롭에 대한 기본적인 지식
	3. 이미지 에디터 데모 : http://hacks.mozilla.or.kr/2010/07/an-html5-offline-image-editor-and-uploader-application/
	4. 실제 구현한 페이지 : http://www.technote.co.kr/php/technote1/board.php?board=memberqna&command=body&no=26564
	5. 멀티업로드 : http://okky.kr/article/226534
**/
#div1 {width:350px;height:135px;padding:10px;border:1px solid #999;}
#div2 {width:350px;height:135px;padding:10px;border:1px solid #999;}
</style>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script>
function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    ev.target.appendChild(document.getElementById(data));
}

function onDragStart(event){
    document.getElementById("msg").innerHTML += "onDragStart->";
    
    //드래그 대상 요소가 option 일 경우에만 가능토록 함
    if(event.target.tagName.toLowerCase() == "option"){
    
      //dataTransfer 객체에 이동할 요소의 ID를 "selectOption"라는 이름으로 등록함
      event.dataTransfer.setData("selectOption", event.target.id);
    }
    else{
      //만일 드래그 대상 요소가 option이 아닐 경우 취소함
      event.preventDefault();
    }
  }        
  
  function onDragEnter(event){
    document.getElementById("msg").innerHTML += "onDragEnter->";
    
    //드래그 대상이 selectOption 일 경우에만 드롭 가능토록 설정함
    var types = event.dataTransfer.types;
    for(var i = 0; i < types.length; i++){
      if(types[i] == "selectOption"){
        event.preventDefault();
        return;
      }
    }
  }
  
  function onDragOver(event){
    document.getElementById("msg").innerHTML += "onDragOver->";
    
    //드롭이 가능하도록 기본 상태를 취소함
    event.preventDefault();
  }        
  
  function onDrop(event){   
    document.getElementById("msg").innerHTML += "onDrop";   
    
    //dataTransfer 객체로 부터 데이터를 꺼내옴
    var id = event.dataTransfer.getData("selectOption");
    
    //현재 문서객체에서 해당 요소를 가져옴
    var optionElement = document.getElementById(id);
    
    //데이터가 존재하고 드래그 대상과 드롭 대상이 같지 않을 경우 드롭 실행
    if(optionElement && optionElement.parentNode != event.currentTarget){
      //드래그 대상에서 이동할 데이터 삭제
      optionElement.parentNode.removeChild(optionElement);
      
      //드롭 대상에 데이터 추가
      event.currentTarget.appendChild(optionElement);
    }
          
    //드롭 완료 후 이벤트 버블링을 막기 위해 호출            
    event.stopPropagation();
          
  }

  
	$('[id^=\"btnRight\"]').click(function (e) {

	    $(this).prev('select').find('option:selected').remove().appendTo($(this).nextAll('select'));
	});

	$('[id^=\"btnLeft\"]').click(function (e) {
	    $(this).next('select').find('option:selected').remove().appendTo($(this).prevAll('select'));
	});  

</script>
</head>
<body>

<p>아래 노트북 이미지를 위 상자로 끌어넣어 보세요:</p>

<div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<br>
<img id="drag1" src="http://cfile230.uf.daum.net/image/265A314E55C4A772208A2E" draggable="true" ondragstart="drag(event)" width="128" height="128">
<br>
<div id="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>

<hr>
<hr>

    <!-- 드래그 대상 요소 -->
    <select size= 4 id="select1" ondragstart="onDragStart(event)">
      <option id="option1_1" draggable="true">옵션1-1</option> <!-- 드래그 데이터 -->
      <option id="option1_2" draggable="true">옵션1-2</option> <!-- 드래그 데이터 -->
      <option id="option1_3" draggable="true">옵션1-3</option> <!-- 드래그 데이터 -->
    </select>
    
    <!-- 드롭 대상 요소 -->
    <select size= 4 id="select2"
       ondragenter="onDragEnter(event)"
      ondragover="onDragOver(event)"
      ondrop="onDrop(event)">
      <option id="option2_1" draggable="true">옵션2-1</option>
      <option id="option2_2" draggable="true">옵션2-2</option>
      <option id="option2_3" draggable="true">옵션2-3</option>
    </select>
    
    <br><br><div id="msg"></div>

<div>
    <select id='canselect_code' name='canselect_code' multiple class='fl'>
        <option value='1'>toto</option>
        <option value='2'>titi</option>
    </select>
    <input type='button' id='btnRight_code' value='  >  ' />
    <br>
    <input type='button' id='btnLeft_code' value='  <  ' />
    <select id='isselect_code' name='isselect_code' multiple class='fr'>
        <option value='3'>tata</option>
        <option value='4'>tutu</option>
    </select>
</div>

</body>
</html>