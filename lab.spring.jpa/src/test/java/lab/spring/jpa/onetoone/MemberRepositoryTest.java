package lab.spring.jpa.onetoone;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import lab.spring.jpa.SampleController;
import lab.spring.jpa.onetoone.Member;
import lab.spring.jpa.onetoone.MemberDetail;
import lab.spring.jpa.onetoone.MemberRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SampleController.class)
@Transactional
public class MemberRepositoryTest {

	@Autowired MemberRepository repository;
	
	@Test
	public void test() {
		Member member = new Member();
		member.setName("arahansa");
		MemberDetail memberDetail = new MemberDetail();
		memberDetail.setAddress("incheon");
		member.setMemberDetail(memberDetail);
		
		repository.save(member);
		assertEquals(repository.count(), 1);
	}

}
