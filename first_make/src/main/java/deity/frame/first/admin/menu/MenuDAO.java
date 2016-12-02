package deity.frame.first.admin.menu;

import java.util.List;
import java.util.Map;

import deity.frame.first.common.DefaultDAO;
import deity.frame.first.domain.Menu;

public interface MenuDAO extends DefaultDAO<Menu> {

	public List<?> getTreeMenu();
	
	public List<Menu> listTopMenu();

	public List<Map<String,String>> authMenuList(String auth_seq);

	public String getMenuLocation(String menu_url);
	
	public List<Menu> topMenu(String user_id);

}
