package deity.frame.first.main.login;

import java.util.Map;

public interface LoginDAO {
	public Map<String,String> loginInfo(String user_id,String user_pwd);
}
