package common.generic.crud;

import java.util.Map;

public interface GenericBean {

	public String getSqlXML();
	
	public Map getParamMap();
	
	public Map getKey();
}
