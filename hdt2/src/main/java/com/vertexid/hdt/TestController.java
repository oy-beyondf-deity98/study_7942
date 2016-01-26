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
	  
	  
	  @RequestMapping("/test/get/{userId}")
	  @ResponseBody
	  public void getUser(@PathVariable("userId") String userId)
	  {
		  ExampleDao exampleDao = sqlSession.getMapper(ExampleDao.class);
		  UserVo userVo = new UserVo();
		  userVo.setUserId("deity");
		  
		  UserVo rsVo = new UserVo();
		  rsVo = exampleDao.getUser(userVo);
		  System.out.println(rsVo.getUserName());
	  }
}
