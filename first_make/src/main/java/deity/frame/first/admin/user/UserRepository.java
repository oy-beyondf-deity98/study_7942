package deity.frame.first.admin.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import deity.frame.first.common.SearchVo;
import deity.frame.first.domain.User;


@Repository
public class UserRepository implements UserDAO {

	@Autowired  SqlSession sqlSession;
	
	public List<User> list(SearchVo search) {
		//비교하는 문때문에 map으로 바꾸는게 필요하다.
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("search", search);
		search.pagingInit();
		int listCount = sqlSession.selectOne("listUserCnt",search);
		search.setTotRow(listCount);
		
		return sqlSession.selectList("listUser",search);
	}

	@Override
	public int insert(User user) {
		return sqlSession.insert("insertUser",user);
	}

	@Override
	public User get(String user_id) {
		return sqlSession.selectOne("getUser",user_id);
		
	}

	@Override
	public int update(User user) {
		return sqlSession.update("updateUser",user);
	}

	@Override
	public int delete(String user_id) {
		
		return sqlSession.delete("deleteUser",user_id);
	}

	@Override
	public int updateUserPwd(User user) {
		return sqlSession.update("updateUserPwd",user);
	}

	@Override
	public List<User> authObjectUser(String auth_seq) {
		
		return sqlSession.selectList("authObjectUser",auth_seq);
	}
	
}
