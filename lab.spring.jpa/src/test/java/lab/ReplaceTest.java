package lab;

import org.junit.Test;

public class ReplaceTest {
	
	@Test
	public void test(){
		String value = "4. 개요 4 • 에.. 주로 독학을 하다가, 한계를 느껴서 2015년부터 스터디에 참여을 하게 되었습니다. 김현기님이 운영하시는 TDD,JPA 스터디 , 오창화님이 운영하시는 pooh 스터디 참여중^^; • 아무래도 다른 개발환경, 다른 경험을 가지신 분들이 오시다보니 스터디에서 쓰게 될 JPA 가 낯설은 분도 계신 것 같기도하고.. • JPA 가 저도 마찬가지로 봐도봐도 아직 낯설어서^^; 정리를 한번 PPT로 해볼려고 합니다. (제가 정리를 제대로 한 게 없더군요.) • 일단은 기본 객체매핑과 관계 매핑부터 시작합니다~ 간단하고 부족하고 틀린 곳이 있을 지 모릅니다. 주로 제가 혼자 공부하다보니…;; 그리고 심화 정도까지도 안 갑니다;; 항상 급하게 만드느라;;; 아..아무튼~ 자.잘 부탁드립니다! ㄷㄷ";
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z.,;:*~`!\\/\\/\\{\\}\\[\\]\\?\\|\\(\\)\\s]";
		//String match ="";
		
		//\}\[\]\/?|\)
		
		value =value.replaceAll(match, "");
		
		String match2 = "\\s{2,}";
		value = value.replaceAll(match2, " ");
		
		System.out.println(value);
	}

}
