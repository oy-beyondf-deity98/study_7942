package deity.frame.first.admin.user;

import java.util.List;

import deity.frame.first.common.DefaultDAO;
import deity.frame.first.domain.User;

public interface UserDAO extends DefaultDAO<User> {

	public int updateUserPwd(User user);
	public List<User> authObjectUser(String auth_seq);
}
