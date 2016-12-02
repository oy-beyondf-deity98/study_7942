package deity.frame.first.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author deity
 *
 */
public class User extends CommonVo {

	@NotEmpty(message = "아이디를 입력하십시요.")
    private String user_id;
	@Size(min=2, max=30)
    private String user_nm;
    private String user_group;
    private String is_user;
    private String user_pwd;
    
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getUser_group() {
		return user_group;
	}
	public void setUser_group(String user_group) {
		this.user_group = user_group;
	}
	public String getIs_user() {
		return is_user;
	}
	public void setIs_user(String is_user) {
		this.is_user = is_user;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
    
    
    
    
    
    

}