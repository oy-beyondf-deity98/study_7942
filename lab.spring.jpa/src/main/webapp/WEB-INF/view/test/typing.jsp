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
	<script>
		
		var http = new Http();
		
		function Http(){
			this.arrStrs = new Array(
				"안녕하세요.",
				"가까운 무당보다 먼 데 무당이 용하다.",
				"가나다라도 모른다.",
				"사공 배 둘러대듯",
				"사기전에 종짓굽 맞추듯",
				"칼끝의 원쑤",
				"차 치고 포 친다.",
				"차돌에 바람 들면 석돌보다 못하다.",
				"바늘 가는 데 실 간다.",
				"바늘구멍으로 황소바람 들어온다.",
				/*
				"다 된 농사에 낫 들고 덤빈다.",
				"다 된 죽에 코 빠졌다.",
				"가난도 비단 가난",
				"가래장부는 본고을 좌수도 몰라본다.",
				"가랑잎이 솔잎더러 바스락거린다고 한다.",
				"고기 새끼 하나 보고 가마솥 부신다.",
				"그 아버지에 그 아들",
				"급하면 바늘허리에 실 매어 쓸까",
				"나 많은 말이 콩 마다할까",
				"나는 새에게 여기 앉아라 저기 앉아라 할 수 없다.",
				"누구네 제사날 기다리다가 사흘 굶은 거지 굶어 죽었다.",
				"눈을 떠도 코 베어 간다.",
				"눈이 아무리 밝아도 제 코는 안 보인다.",
				"달기는 엿집 할머니 손가락이라",
				"달아나는 노루 보고 얻은 토끼를 놓았다.",
				"두 손뼉이 맞아야 소리가 난다.",
				"뒷집 짓고 앞집 뜯어 내란다.",
				"아가리 마구 난 창구멍인가",
				"아는 걸 보니 소강절의 똥구멍에 움막 짓고 살았겠다.",
				"아직 이도 나기 전에 갈비를 뜯는다.",
				"자기 늙은 것은 몰라도 남 자라는 것은 안다.",
				"자식을 낳기보다 부모 되기가 더 어렵다.",
				"자식을 보기엔 아비만 한 눈이 없고 제자를 보기엔 스승만 한 눈이 없다.",
				"잔치는 잘 먹은 놈 잘 차렸다 하고 못 먹은 놈 못 차렸다 한다.",
				"잘 싸우는 장수에게는 내버릴 병사가 없고 글 잘 쓰는 사람에게는 내버릴 글자가 없다.",
				*/
				"칼치가 제 꼬리 베 먹는다.",
				"추어주면 엉뎅이 나가는 줄 모른다.",
				"자식 과년하면 부모가 반중매쟁이 된다.",
				"잔치 보러 왔다가 초상 본다.",
				"옥창원은 잘생겼다.", // ㅈㅅ
				"착하고 잘생긴 옥창원.", // ㅈㅅ
				"옥창원은 훈훈하다.", // ㅈㅅ
				"아 멋있다.", // ㅈㅅ
				"아 이건뭐",
				"죄송합니다.",
				"행복하니?"
			);
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

			this.setHttp=function(){
				/*** 임의 문장 선택 ***/
				var idx = Math.floor(Math.random(1)*this.arrStrs.length);
				this.exString = this.arrStrs[idx];
				
				/*** 문장/입력 객체 가져오기***/
				var objInputString = this.obj("httpInputString");
				var objExString = this.obj("exString");
				
				/*** 타이머 초기화 ***/
				this.timerStopped=true;
				this.timerInt=window.clearInterval(http.timerInt);
				this.timerSec=0;

				/*** 문장 초기화 ***/
				objExString.innerHTML=this.exString;
				objInputString.value="";
				objInputString.focus();
			}
			this.keyUp=function(){
				var objInputString = this.obj("httpInputString");
				
				this.chkMiss();

				/*** 다른 문장으로 넘김 ***/
				if(this.exString.length<=objInputString.value.length){
					
					/*** 정확도 계산/출력 ***/
					this.lengthTotal += this.exString.length;
					this.lengthTotalTrue += this.lengthCurTrue;
					
					this.accuracyCur = Math.floor(this.lengthCurTrue/this.exString.length*100);
					this.accuracyTotal = Math.floor(this.lengthTotalTrue/this.lengthTotal*100);
					this.obj("prnAccuracyCur").innerHTML=this.accuracyCur;
					this.obj("prnAccuracyTotal").innerHTML=this.accuracyTotal;
					this.obj("barAccuracyCur").style.width=this.accuracyCur+"%";
					this.obj("barAccuracyTotal").style.width=this.accuracyTotal+"%";
					
					/*** 속도 계산/출력 ***/
					this.speedCur = Math.floor(this.lengthCurTrue / this.timerSec * 6000);
					if(this.speedMax<this.speedCur)this.speedMax = this.speedCur;
					this.obj("prnSpeedCur").innerHTML = this.speedCur;
					this.obj("prnSpeedMax").innerHTML = this.speedMax;
					this.obj("barSpeedCur").style.width=this.speedCur/10+"%";
					this.obj("barSpeedMax").style.width=this.speedMax/10+"%";

					this.setHttp();
					return false;
				}
				return true;
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
					this.timerInt=window.setInterval("http.addSec()",10);
				}
			}
			this.addSec=function(){
				this.timerSec++;
			}
		}
	</script>
	<style>
		#httpBox {border:1px solid #cccccc;width:900px;padding:4px;}
		#httpBox .smallBox {width:100%;background-color:#f5f5f5;border:1px solid #cccccc;padding:2px;font-size:20pt;font-family:'malgun gothic';text-align:center;}
		#httpBox .ph {height:4px;font-size:0px;}
		#httpBox .textbox {width:95%;border:0px;background-color:#f5f5f5;text-align:center;}
		#httpBox #status {width:100%;}
		#httpBox #status th{font-size:9pt;}
		#httpBox #status .bar {width:0px;font-size:0px;height:18px;}
		#httpBox #status .nums {font-size:9pt;height:18px;}
		#httpBox #status .barBgcolor {background-color:#cccccc}
	</style>
</head>
<body onload="http.setHttp()">
	<h3>옥창타자연습 v1.0</h3>
	<div id="httpBox">

		<div id="exString" class="smallBox"></div>
		
		<div class="ph"></div>

		<div class="smallBox">
			<input type="text" class="textbox" id="httpInputString" onkeypress="return http.keyUp()" onkeyup="http.chkMiss()" onkeydown="http.chkTime()">
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
</body>
</html>