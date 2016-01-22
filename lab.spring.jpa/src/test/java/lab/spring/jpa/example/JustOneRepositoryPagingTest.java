package lab.spring.jpa.example;

import static org.junit.Assert.assertEquals;

import java.util.Date;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SampleController.class)
@Transactional
public class JustOneRepositoryPagingTest {
	private static final String _1234 = "1234";
	private static final String HELLO_WORLD = "hello world";
	
	@Autowired JustOneRepository repository;
	
	@Before
	public void setUp() throws Exception {
		for(int i=0;i<40;i++){
			//Justone객체를 하나 만들고 save 로 저장합니다. 
			//asserteq 에서  총 개수가 1이란 것을 확인해봅니다.
			JustOne one = new JustOne();
			one.setDateJoin(new Date());
			one.setEnumOne(JustOneEnum.TWO);
			one.setMessage(HELLO_WORLD +i);
			one.setPasswordConfirm(_1234);
			repository.save(one);
			//assertEquals(repository.count(), 1);
		}
	}

	@Test
	public void testPage() {
	

			
		Pageable pageable = new PageRequest(0, 10);
		Page<JustOne> ones = repository.findAll(pageable);
		
		
		List<JustOne> oneList = ones.getContent();
		int i=0;
		for(JustOne one : oneList){
			
			assertEquals(one.getMessage(),HELLO_WORLD+i++);
		}
		
		assertEquals(oneList.size(),10);
	}
	
	@Test
	public void 역정렬(){
		Pageable pageable = new PageRequest(0, 10);
		Sort sort = new Sort(Direction.DESC, "id");
		pageable = new PageRequest(0, 10, sort);
		
		Page<JustOne> ones = repository.findAll(pageable);
		List<JustOne> oneList = ones.getContent();
		
		for(int  i =39,j=0;i>=30;i--,j++){
			
			assertEquals(oneList.get(j).getMessage(),HELLO_WORLD+i);
		}
		 
	}


}
