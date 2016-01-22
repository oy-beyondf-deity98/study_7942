package lab.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import org.junit.Test;

public class StringFilterTest {

	@Test
	public void test() throws IOException {
		
		String str = "45. 1:1 매핑 클래스 작성, 45 다음은 1:1 매핑 예제입니다. 양쪽에서 서로의 객체를 필드지정해주면서 onetoone 어노테이션을 붙여줍시다. JoinColumn 에서 name 으로 해주면 매핑하는 테이블 외래키의 컬럼명을 지정할 수 있습니다. Onetoone 매핑으로 상대 테이블의 주키를 외래키로 가져오는 것을 볼수 있습니다. mappedBy에서상대쪽 필드로 매핑(?) 되어 안기는(?) 것을 볼 수 있습니다.";
	
		
		StringTokenizer tokens = new StringTokenizer(str,"[\\.\\,]",false);
		
		if(tokens.countTokens() > 0){
			while(tokens.hasMoreTokens()){
				String data = tokens.nextToken();

				if(data.length() >3)
				System.out.println(data.trim());
			}	
		}
		
		
		
	}
	
	

}
