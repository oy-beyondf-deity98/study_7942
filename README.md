# study_7942
한 10년전에 만들었다. 공부하려고 만든것인데... 흔적이라고 하나?
필요없는 것 정리하고 몇개만 남았다. 

1. 문서 파서를 만들려고 했다. 목적은 시스템의 단어사전을 만들기 위해서였다.
  - 결과물 : 모든 단어를 분석해서 영어, 한국어, 한자 로 번역하는 것이다.
  - 번역해서 이것저것 쓰고 싶은게 많았는데, 정말 앞부분만 잡다가 말았다.
  - 검색시스템, 현태소 분석기, 앨라스틱 서치, 루씬
  - 대상 : CODE, MS OFFICE, txt, DBMS, HWP

2. 회사에서 쓰는 일반화 시스템을 만들려고 했다.
  - admin 시스템
3. 회사시스템의 제네레이트 소스를 만들려고 했다.
  - 간단한 메뉴를 빠르게 만들기
  - 컨트롤러, 서비스 제네레이터, JPA, 간단한 DB모델링
    
그냥 도전 했었던 과제를 한번정리해보았다.
원래... 여기는 친구들과 같이 만들고 싶었지만 내 능력부족이었던 것 같다. 

---

1. 영업관리 시스템을 만들다 말았다.
  - 오리온, 롯데
  - 공통관리 시스템을 만들어 보려고 했다.
  
2. 간트 차트 만들기
  - 라이브러리 사용, TREE GRID
3. maven 아키타입을 만들고 아키타입으로 프로젝트를 만드는 연습을 했었다.
  
  
사용 라이브러리
  - MyBatis, JPA, TREE GRID, log4j
  - eclipse, spring MVC, spring boot, spring security

-----------------------------------

* [Github link](https://github.com/ZhibingXie)
* [Linkedin link](http://www.linkedin.com/in/zhibingxie)       
SpringMVC Mybatis : https://github.com/KevinXie0131/SpringMVC-Spring-MyBatis


OSD : https://github.com/OSD-STUDY/cloud
  - 활동을 안한다.
  - 어? 리드미가 있네?

인터뷰를 위한 사항 : https://github.com/JaeYeopHan/Interview_Question_for_Beginner
  - 내가 활동을 안한다.  
---

목표
 1. 우선은 maven과 git, test case를 기본적으로 사용할예정이다.
    - 써바야지만 익숙해지는 나를위해서.. 
    - test case를 한데 묶어서 테스트해볼수 있는것은 무엇이 있을까나?
 2. DB 인터페이스를 만들예정
 3. 유틸뿐만아니라 정보를 규합하고 그것을 재배포, 재배치하는 큐레이션 서비스를 만들어볼 예정이다.

근데.. 내가만든 유틸과 서비스들이.. 이미 비슷한게 있을거라는 예감이 팍팍드는데 말이지.. 쩝

2012년은 git과 maven, testcase를 이용해 개발하는데 중점을 두도록할 예정이다. 나의
개발스타일~ 바꾸기. 한번정해지면 스타일,정보를 개편하지 않는나를 위해~
2013은 커뮤니케이션활동을 주로 할예정. ㅋ 우.. 나의 활동영역을 넓히기? 아니 나의 생활패턴을 바꾸기.


---

해당 아키타입 폴더로 이동(pom.xml이 있는곳)

mvn install 로 local repository 에 추가
추가한 archetype 으로 부터 프로젝트 생성
mvn archetype:generate -DarchetypeCatalog=local
정상적으로 동작한다면 mvn deploy 에 nexus repository 에 배치
참조 : https://www.lesstif.com/pages/viewpage.action?pageId=16744469

