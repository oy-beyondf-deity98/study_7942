package common.generic.crud.test;

import java.util.HashMap;
import java.util.Map;

import common.ObjectUtil;
import common.generic.crud.GenericBean;

public class GenericTestBean implements GenericBean{
	private String sqlMapName = "Calendar";
	
    private String id;
    private String subject;
    private String name;
    private String start_date;
    private String end_date;
    
    
	
	@Override
	public Map<String,Object> getParamMap() {
//		Map<String,Object> map = new HashMap<String,Object>();
		return ObjectUtil.toMap(this);
	}
	
	public Map<String,Object> getKey() {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("id", this.id);
		return map;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	@Override
	public String getSqlXML() {
		// TODO Auto-generated method stub
		return this.sqlMapName;
	}


	@Override
	public String toString() {
		return "GenericTestBean [sqlMapName=" + sqlMapName + ", id=" + id + ", subject=" + subject + ", name=" + name
				+ ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}

}
