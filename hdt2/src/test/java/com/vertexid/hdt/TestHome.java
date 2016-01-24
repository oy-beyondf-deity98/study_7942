package com.vertexid.hdt;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestHome {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testList() {
		ExampleDao exampleDao = sqlSession.getMapper(ExampleDao.class);
		System.out.println(exampleDao.getUserName("1"));
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void 나누기(){
		System.out.println(61/10);
	}
	
	@Test
	public void 나머지(){
		System.out.println(150%10);
	}
}
