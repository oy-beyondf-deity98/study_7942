package com.vertexid.hdt;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	  @Autowired
	  private SqlSession sqlSession;
	 
	  @RequestMapping("/test/mybatis/{userId}")
	  @ResponseBody
	  public void testMybatis(@PathVariable("userId") String userId)
	  {
		  ExampleDao exampleDao = sqlSession.getMapper(ExampleDao.class);
		  System.out.println(exampleDao.getUserName(userId));
	  }
}
