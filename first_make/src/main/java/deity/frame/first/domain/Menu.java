package deity.frame.first.domain;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

/**
 * 
 * @author deity
 *
 */
public class Menu extends CommonVo {

	private int menu_seq;
	@Size(min=2, max=50)
	private String menu_nm;
	private String menu_url;
	@NumberFormat
	private int parent_menu;
	private String parent_menu_nm;
	@NumberFormat
	private int menu_depth;
	@NumberFormat
	private int order_num;
	private int order_group;
	
	public int getMenu_seq() {
		return menu_seq;
	}
	public void setMenu_seq(int menu_seq) {
		this.menu_seq = menu_seq;
	}
	public String getMenu_nm() {
		return menu_nm;
	}
	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public int getParent_menu() {
		return parent_menu;
	}
	public void setParent_menu(int parent_menu) {
		this.parent_menu = parent_menu;
	}
	public String getParent_menu_nm() {
		return parent_menu_nm;
	}
	public void setParent_menu_nm(String parent_menu_nm) {
		this.parent_menu_nm = parent_menu_nm;
	}
	public int getMenu_depth() {
		return menu_depth;
	}
	public void setMenu_depth(int menu_depth) {
		this.menu_depth = menu_depth;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getOrder_group() {
		return order_group;
	}
	public void setOrder_group(int order_group) {
		this.order_group = order_group;
	}
	
	public String getMenu_str() {
		
		return this.menu_seq+"";
	}
}