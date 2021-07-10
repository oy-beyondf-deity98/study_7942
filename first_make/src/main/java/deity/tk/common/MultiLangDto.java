package com.tk.common;

import java.util.List;

public class MultiLangDto {
	private List<String> codeNm;
	private String code;
	private String table;
	private String column;
	private List<String> langs;
	
	public List<String> getCodeNm() {
		return codeNm;
	}
	public void setCodeNm(List<String> codeNm) {
		this.codeNm = codeNm;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public List<String> getLangs() {
		return langs;
	}
	public void setLangs(List<String> langs) {
		this.langs = langs;
	}
	@Override
	public String toString() {
		return "MultiLangDto [codeNm=" + codeNm + ", code=" + code + ", table=" + table + ", column=" + column
				+ ", langs=" + langs + "]";
	}
	
	

}
