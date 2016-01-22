package lab.spring.jpa.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import lab.spring.jpa.SampleController;
import lab.spring.jpa.example.domain.JustOne;
import lab.spring.jpa.example.domain.JustOneEnum;
import lab.spring.jpa.example.repository.JustOneRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SampleController.class)
@Transactional
public class JustOneRepositorySearchTest {
	private static final String _1234 = "1234";
	private static final String HELLO_WORLD = "hello world";
	
	@Autowired JustOneRepository repository;
	
	@Before
	public void setUp() throws Exception {
		JustOne one = new JustOne();
		one.setDateJoin(new Date());
		one.setEnumOne(JustOneEnum.TWO);
		one.setMessage(HELLO_WORLD);
		one.setPasswordConfirm(_1234);
		repository.save(one);
		assertEquals(repository.count(), 1);
	}

	@Test
	public void 특정메세지로_가져오기() {
		JustOne one = repository.findByMessage(HELLO_WORLD);
		assertNotNull(one);
		assertEquals(one.getMessage(),HELLO_WORLD);
		
	}
	
	@Test
	public void 날짜이전_특정메세지로찾기(){
		repository.deleteAll();
		/**주의 * 자바 날짜는 자바8, joda time 같은 걸로 해주는게 더 좋다고 합니다.
		 * 여기선 그냥 간단하게 java date 로 이미 가버렸습니다;; 삐질  */
		//먼저 데이터를 삽입하고
		Calendar calendar;	
		for(int i=0;i<10;i++){
			calendar = new GregorianCalendar(2010+i,1,1,13,24,56);
			JustOne one = new JustOne();
			one.setDateJoin(calendar.getTime());
			one.setMessage(i%2==0? HELLO_WORLD: _1234);
			repository.save(one);	
		}
		//기준 데이터를 가져와서 특정날짜이전과 해당 메시지에 해당하는 리스트를 뽑아봅니다.
		calendar = new GregorianCalendar(2015,1,1,13,24,56);
		List<JustOne> getList = 
		repository.findBydateJoinBeforeAndMessage(calendar.getTime(), HELLO_WORLD);
		//그리고 검사
		int year=2010;
		for (JustOne justOne : getList) {	
			calendar.set(year,1,1,13,24,56);
			assertEquals(justOne.getMessage(), HELLO_WORLD);
			assertEquals(justOne.getDateJoin(), calendar.getTime());
			year+=2;
		}
	}

}
