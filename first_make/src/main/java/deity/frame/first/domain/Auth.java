package deity.frame.first.domain;

/**
 * 
 * @author deity
 *
 */
public class Auth extends CommonVo {

	private int auth_seq;
	private String auth_nm;
	private String auth_type;
	
	private String remark;
	private String is_lock;
	private int parent_seq;
	
	public int getAuth_seq() {
		return auth_seq;
	}
	public String getAuth_seq_str(){
		return auth_seq+"";
	}
	
	public void setAuth_seq(int auth_seq) {
		this.auth_seq = auth_seq;
	}
	public String getAuth_type() {
		return auth_type;
	}
	public void setAuth_type(String auth_type) {
		this.auth_type = auth_type;
	}
	public String getAuth_nm() {
		return auth_nm;
	}
	public void setAuth_nm(String auth_nm) {
		this.auth_nm = auth_nm;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	public String getIs_lock() {
		return is_lock;
	}
	public void setIs_lock(String is_lock) {
		this.is_lock = is_lock;
	}
	

	
}
