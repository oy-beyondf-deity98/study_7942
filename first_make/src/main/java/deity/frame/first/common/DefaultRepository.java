package deity.frame.first.common;

/**
 * 한번 만들어 보았다. 쓰지는 않는다.
 * 별로 적당하지도 않고
 */
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import deity.frame.first.domain.User;

public class DefaultRepository<T>{
	
	@Autowired protected  SqlSession sqlSession;
	//private String
	private T t;
	private String domain ;
	
	
	public DefaultRepository(T t) {
		this.t= t;
		domain = t.getClass().getName();
	}

	public List<User> list(SearchVo search) {
		
		
		//비교하는 문때문에 map으로 바꾸는게 필요하다.
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("search", search);
		search.pagingInit();
		System.out.println(domain);
		int listCount = sqlSession.selectOne("listUserCnt",search);
		search.setTotRow(listCount);
		
		return sqlSession.selectList("listUser",search);
	}

	
	public User get(String id) {
		return sqlSession.selectOne("getUser",id);
		
	}

	
	public int insert(User domain) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int update(T domain){
		return 0;
	}
	
	public int delete(String id) {
		
		return sqlSession.delete("deleteUser",id);
	}	
	
}
