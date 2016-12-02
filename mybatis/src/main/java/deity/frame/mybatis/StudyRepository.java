package deity.frame.mybatis;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudyRepository  implements StudyDao{

	@Autowired
    private SqlSession query;
	
	@Override
	public void test() throws SQLException {
		String rtnStr = query.selectOne("test");//(1)
		//String rtnStr = query.selectOne("query.test");(2)
		//쿼리를 가져올때 id명만 넣어도 되는데? (1)
		//아.. 겹치는것은 앞에 네임스페이스를 넣어서 하면 되는건가?(2)
		
		System.out.println("qeury result :"+rtnStr);
	}	
}
