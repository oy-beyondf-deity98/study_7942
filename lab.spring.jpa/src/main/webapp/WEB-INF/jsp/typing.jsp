<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
	<title> 옥창 타자연습 v1.0 </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="generator" content="editplus">
	<meta name="author" content="">
	<meta name="keywords" content="">
	<meta name="description" content="">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script>
		
		//var array_data = [];
		/* 초기화, 없애면 오류가 난다.*/
		var array_data  = new Array(
				"오늘도 행복하게 살자."
			);
		var typing = new Typing(array_data);
		
		$(document).ready(function(){
		
			var url = "chat/typing";
	    	
	        $.getJSON(url,function(data){
	        	var i=0;
	        	 $.each(data.data, function (index, value) {
	        		 array_data[i++]=value;
	        	}); 	
	        });
		 	
			typing.setInit();
			
			$("#httpInputString").on("keypress",function(){
				typing.chkMiss();
				
				var objInputString = typing.obj("httpInputString");
				
				/*** 다른 문장으로 넘김 ***/
				if(typing.exString.length<=objInputString.value.length){
					
					typing.accuracy();
					typing.speed();

					typing.setInit();
					return false;
				}
				return true;
			});
			$("#httpInputString").keyup(function(){
				typing.chkMiss();
			});
			$("#httpInputString").keydown(function(){
				typing.chkTime();
			});
		});
		
		
		
		function Typing(arr){
			this.arrStrs = arr;
			
			this.exString="";
			this.inputString="";
			this.speedCur=0;
			this.speedMax=0;
			
			this.accuracyTotal=0; //정확도
			this.accuracyCur=0; //정확도

			this.lengthTotal=0; //전체 글자수
			this.lengthTotalTrue=0; //전체 맞은 글자수
			this.lengthCurTrue=0; //현재 맞은 글자수
			
			this.timerInt;
			this.timerStopped=true;
			this.timerSec=0;

			this.setInit = function(){
				/*** 임의 문장 선택 ***/
				if(this.arrStrs == undefined){
					this.exString ='';
				}else{
					var idx = Math.floor(Math.random(1)*this.arrStrs.length);
					this.exString = this.arrStrs[idx];	
				}
				
				/*** 문장/입력 객체 가져오기***/
				var objInputString = this.obj("httpInputString");
				var objExString = this.obj("exString");
				
				/*** 타이머 초기화 ***/
				this.timerStopped=true;
				this.timerInt=window.clearInterval(this.timerInt);
				this.timerSec=0;

				/*** 문장 초기화 ***/
				objExString.innerHTML=this.exString;
				objInputString.value="";
				objInputString.focus();
			}
			
			this.accuracy = function(){
				/*** 정확도 계산/출력 ***/
				this.lengthTotal += this.exString.length;
				this.lengthTotalTrue += this.lengthCurTrue;
				
				this.accuracyCur = Math.floor(this.lengthCurTrue/this.exString.length*100);
				this.accuracyTotal = Math.floor(this.lengthTotalTrue/this.lengthTotal*100);
				this.obj("prnAccuracyCur").innerHTML=this.accuracyCur;
				this.obj("prnAccuracyTotal").innerHTML=this.accuracyTotal;
				this.obj("barAccuracyCur").style.width=this.accuracyCur+"%";
				this.obj("barAccuracyTotal").style.width=this.accuracyTotal+"%";
			}
			
			this.speed = function(){
				/*** 속도 계산/출력 ***/
				this.speedCur = Math.floor(this.lengthCurTrue / this.timerSec * 6000);
				if(this.speedMax<this.speedCur)this.speedMax = this.speedCur;
				this.obj("prnSpeedCur").innerHTML = this.speedCur;
				this.obj("prnSpeedMax").innerHTML = this.speedMax;
				this.obj("barSpeedCur").style.width=this.speedCur/10+"%";
				this.obj("barSpeedMax").style.width=this.speedMax/10+"%";
			}
			
			this.obj=function(id){
				return document.getElementById(id);
			}
			this.chkMiss=function(){
				var result="";
				this.lengthCurTrue=0;

				var objInputString = this.obj("httpInputString");
				this.inputString = objInputString.value;

				for(var i=0;i<this.exString.length;i++){
					if(this.exString.substring(i,i+1)!=this.inputString.substring(i,i+1) && i<this.inputString.length)
						result+="<font color=red>"+this.exString.substring(i,i+1)+"</font>";
					else{
						result+=this.exString.substring(i,i+1);
						this.lengthCurTrue++;
					}
				}
				var objExString = this.obj("exString");
				objExString.innerHTML=result;
			}
			this.chkTime=function(){
				if(this.timerStopped){
					this.timerStopped=false;
					this.timerSec=0;
					this.timerInt=window.setInterval("typing.addSec()",10);
				}
			}
			this.addSec=function(){
				this.timerSec++;
			}
		}
	</script>
	<style>
		#httpBox {border:1px solid #cccccc;width:600px;padding:4px;}
		#httpBox .smallBox {width:100%;background-color:#f5f5f5;border:1px solid #cccccc;padding:2px;font-size:9pt;font-family:'malgun gothic';text-align:center;}
		#httpBox .ph {height:4px;font-size:0px;}
		#httpBox .textbox {width:95%;border:0px;background-color:#f5f5f5;text-align:center;}
		#httpBox #status {width:100%;}
		#httpBox #status th{font-size:9pt;}
		#httpBox #status .bar {width:0px;font-size:0px;height:18px;}
		#httpBox #status .nums {font-size:9pt;height:18px;}
		#httpBox #status .barBgcolor {background-color:#cccccc}
	</style>
</head>
<body>
	<h3>옥창타자연습 v1.0</h3>
	<div id="httpBox">

		<div id="exString" class="smallBox"></div>
		
		<div class="ph"></div>

		<div class="smallBox">
			<input type="text" class="textbox" id="httpInputString">
		</div>

		<div class="ph"></div>
		
		<div id="status" class="smallBox">
			<table width="100%">
				<col width="80">
				<col width="">
				<col width="80">
				<tr>
					<th>정확도</th>
					<td>
						<div class="barBgcolor">
							<div id="barAccuracyCur" class="bar" style="background-color:#33ccff"></div>
						</div>
					</td>
					<td class="nums">
						<span id="prnAccuracyCur">0</span>%
					</td>
				</tr>
				<tr>
					<th>평균 정확도</th>
					<td>
						<div class="barBgcolor">
							<div id="barAccuracyTotal" class="bar" style="background-color:#3399cc"></div>
						</div>
					</td>
					<td class="nums">
						<span id="prnAccuracyTotal">0</span>%
					</td>
				</tr>
				<tr>
					<th>현재 속도</th>
					<td>
						<div class="barBgcolor">
							<div id="barSpeedCur" class="bar" style="background-color:#ffcc33"></div>
						</div>
					</td>
					<td class="nums">
						<span id="prnSpeedCur">0</span>타/분
					</td>
				</tr>
				<tr>
					<th>최고 속도</th>
					<td>
						<div class="barBgcolor">
							<div id="barSpeedMax" class="bar" style="background-color:#cc9933"></div>
						</div>
					</td>
					<td class="nums">
						<span id="prnSpeedMax">0</span>타/분
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div>타자연습 원본 : http://lepas.pe.kr/main/index.php?mid=results&document_srl=187</div>
</body>
</html>