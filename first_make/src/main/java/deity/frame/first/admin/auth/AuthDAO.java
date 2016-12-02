package deity.frame.first.admin.auth;

import java.util.List;
import java.util.Map;

import deity.frame.first.common.DefaultDAO;
import deity.frame.first.domain.Auth;

public interface AuthDAO extends DefaultDAO<Auth> {

	public void insertAuthUser(Map<String, String> map);

	public List<Map<String,String>> grantAuthUser(String auth_seq);

	public void deleteAuthUser(String auth_seq);

	public List<Map<String, String>> authObjectMenu(String auth_seq);

	public void deleteAuthMenu(String auth_seq);

	public void insertAuthMenu(Map<String, String> map);

}
