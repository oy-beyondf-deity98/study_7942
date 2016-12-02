package deity.frame.first.admin.auth;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import deity.frame.first.common.SearchVo;
import deity.frame.first.domain.Auth;

@Repository
public class AuthRepository implements AuthDAO {

	@Autowired private SqlSession sqlSession;
	
	@Override
	public List<Auth> list(SearchVo search) {
		search.pagingInit();
		int listCount = sqlSession.selectOne("listAuthCnt", search);
		search.setTotRow(listCount);

		return sqlSession.selectList("listAuth", search);
		
	}

	@Override
	public Auth get(String id) {
		
		return sqlSession.selectOne("getAuth",id);
	}

	@Override
	public int insert(Auth auth) {
		
		return sqlSession.insert("insertAuth",auth);
	}

	@Override
	public int update(Auth auth) {
		
		return sqlSession.update("updateAuth",auth);
	}

	@Override
	public int delete(String id) {
		
		return sqlSession.delete("deleteAuth",id);
	}
	
	@Override
	public void deleteAuthUser(String auth_seq) {
		sqlSession.delete("deleteAuthUser",auth_seq);
		
	}	

	@Override
	public void insertAuthUser(Map<String,String> map) {
		
		sqlSession.insert("insertAuthUser",map);
		
	}

	@Override
	public List<Map<String,String>> grantAuthUser(String auth_seq) {
		
		return sqlSession.selectList("grantAuthUser",auth_seq);
	}

	@Override
	public List<Map<String, String>> authObjectMenu(String auth_seq) {
		
		return sqlSession.selectList("authObjectMenu",auth_seq);
	}

	@Override
	public void deleteAuthMenu(String auth_seq) {
		sqlSession.delete("deleteAuthMenu",auth_seq);
		
	}

	@Override
	public void insertAuthMenu(Map<String, String> map) {
		sqlSession.insert("insertAuthMenu",map);
		
	}



}
