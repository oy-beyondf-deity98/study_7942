package deity.frame.first.domain;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

public class Code extends CommonVo {

	@Size(min=2, max=50)
	private String code;
	@Size(min=2, max=50)
	private String code_nm;
	@Size(min=2, max=50)
	private String code_nm_eng;
	private String remark;
	private String note;
	private String parent_code;
	private String parent_nm;
	@NumberFormat
	private int order_num;
	private boolean is_use;
	private boolean is_lock;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode_nm() {
		return code_nm;
	}
	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}
	public String getCode_nm_eng() {
		return code_nm_eng;
	}
	public void setCode_nm_eng(String code_nm_eng) {
		this.code_nm_eng = code_nm_eng;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getParent_code() {
		return parent_code;
	}
	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public boolean getIs_use() {
		return is_use;
	}
	public void setIs_use(boolean is_use) {
		this.is_use = is_use;
	}
	public boolean getIs_lock() {
		return is_lock;
	}
	public void setIs_lock(boolean is_lock) {
		this.is_lock = is_lock;
	}
	public String getParent_nm() {
		return parent_nm;
	}
	public void setParent_nm(String parent_nm) {
		this.parent_nm = parent_nm;
	}
}