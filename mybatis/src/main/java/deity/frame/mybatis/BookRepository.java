package deity.frame.mybatis;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public class BookRepository extends SqlSessionDaoSupport implements BookDAO{
	
	@Override
	public void test() {
		String rtnStr = getSqlSession().selectOne("test2");
		
		System.out.println("두번째 리턴값확인 :"+rtnStr);
		
	}

}
