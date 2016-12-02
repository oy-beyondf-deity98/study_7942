package deity.frame.first.main.login;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository implements LoginDAO {

	@Autowired SqlSession sqlSession;
	
	@Override
	public Map<String, String> loginInfo(String user_id, String user_pwd) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id);
		map.put("user_pwd", user_pwd);
		
		return sqlSession.selectOne("getLoginInfo",map);
	}

}
