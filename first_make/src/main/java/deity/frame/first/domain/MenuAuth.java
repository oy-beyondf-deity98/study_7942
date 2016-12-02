package deity.frame.first.domain;

import java.util.List;

/**
 * 
 * @author deity
 *
 */
public class MenuAuth extends CommonVo {
	private int menu_auth_seq;
	private Auth auth;
	private List<User> userList;
	private List<Menu> menuList;
	
	public int getMenuAuthSeq() {
		return menu_auth_seq;
	}
	public String getMenuAuthSeqStr(){
		return menu_auth_seq+"";
	}
	public void setMenuAuthSeq(int menu_auth_seq) {
		this.menu_auth_seq = menu_auth_seq;
	}
	public Auth getAuth() {
		return auth;
	}
	public void setAuth(Auth auth) {
		this.auth = auth;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	
	

}