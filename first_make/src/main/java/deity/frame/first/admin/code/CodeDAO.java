package deity.frame.first.admin.code;

import java.util.Map;

import deity.frame.first.common.DefaultDAO;
import deity.frame.first.domain.Code;

public interface CodeDAO extends DefaultDAO<Code> {

	public Map<String,String> ableDeleteCode(String code);
	
}
