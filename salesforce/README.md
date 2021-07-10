# salesForce
재미있는 영업관리 만들기-backend

* 기본뼈대 참조 : https://coding-start.tistory.com/136
  - 제네릭 컨트롤러
  
* 옛날 방식의 뼈대가 될수 있는 것 : https://github.com/hoyeonUM/genericController
  
---
필요한 것 , side effect를 잘 처리할수록 좋다~
1. 사용자 권한 체크
    - DB사용
2. 다국어
3. 오류처리

---
마스터는 제네레이터로 최대한 간단하게 간다.
1. model과 Controller만 있으면 된다.
2. 조회쿼리를 이용한 조회
    - 최대한 간단하게...

여기는 기본뼈대만가지고 가고... 나중에 하도록 하자.

---
master치고는 너무 많네 Service에 Repository까지...
제네릭 최종은 컨트롤만 만드는 것으로 하자.

스프링부트에서 컨트롤러 테스트 : https://siyoon210.tistory.com/145
  - MockMvc를 이용해서 테스트를 한다. url호출이 가능하다..
  - @SpringBootTest + @AutoConfigureMockMvc는 통합테스트를 할 때, @WebMvcTest는 MVC쪽만 슬라이스(slice) 테스트를 할 때 사용합니다.
  - 두번째 방향으로 하니까 오류가 발생한다.
  
``` java, 오류난 코드
@RunWith(SpringRunner.class)
@WebMvcTest
```

컨트롤러 테스트는 다음을 보면 될것 같다. 깔끔하네 : https://shinsunyoung.tistory.com/52

post일때 값을 어떻게 넘겨야하는지에 대한 고찰
 - https://stackoverflow.com/questions/20504399/testing-springs-requestbody-using-spring-mockmvc
 - RequestBody의 값을 넘기기위해서
get일때는 param이 제공되는 것 같다.

* 음... 아마도 컨트롤러가 아니라 서비스에 대한 검증을 하면 될것 같다.
  - 컨트롤러 검증은 복잡해보이네.. 굿이 할필요가 있을까 싶다.
  - 데이터 검증이 필요할때 쓰면 될것 같다.
  - api에 대한 검증도 마찬가지이다...