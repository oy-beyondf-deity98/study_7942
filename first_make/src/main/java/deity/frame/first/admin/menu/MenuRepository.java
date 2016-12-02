package deity.frame.first.admin.menu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import deity.frame.first.common.SearchVo;
import deity.frame.first.domain.Menu;

@Repository
public class MenuRepository implements MenuDAO{

	@Autowired SqlSession sqlSession;
	
	@Override
	public List<Menu> list(SearchVo search) {
		search.pagingInit();
		int listCount = sqlSession.selectOne("listMenuCnt", search);
		search.setTotRow(listCount);

		return sqlSession.selectList("listMenu", search);
		
	}

	@Override
	public Menu get(String id) {
		return sqlSession.selectOne("getMenu",id);
	}

	@Override
	public int insert(Menu menu) {
		
		return sqlSession.insert("insertMenu",menu);
	}

	@Override
	public int update(Menu menu) {
		
		return sqlSession.update("updateMenu",menu);
	}

	@Override
	public int delete(String id) {
		return sqlSession.delete("deleteMenu",id);
	}

	@Override
	public List<?> getTreeMenu() {
		
		return sqlSession.selectList("treeMenu");
	}

	@Override
	public List<Menu> listTopMenu() {
		
		return sqlSession.selectList("listTopMenu");
	}

	@Override
	public List<Map<String,String>> authMenuList(String auth_seq) {
		
		return sqlSession.selectList("authMenuList",auth_seq);
	}

	@Override
	public String getMenuLocation(String menu_url) {

		return sqlSession.selectOne("getMenuLocation",menu_url);
	}

	@Override
	public List<Menu> topMenu(String user_id) {
		
		return sqlSession.selectList("topMenu",user_id);
	}

}
