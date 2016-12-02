package deity.frame.first.domain;

public class Manual extends CommonVo {

	private int manual_seq;
	private String subject;
	private String remark;
	private FileVO fileVO;
	
	
	public int getManual_seq() {
		return manual_seq;
	}
	public void setManual_seq(int manual_seq) {
		this.manual_seq = manual_seq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public FileVO getFileVO() {
		return fileVO;
	}
	public void setFileVO(FileVO fileVO) {
		this.fileVO = fileVO;
	}
	
	public String getManual_seq_str(){
		return this.manual_seq+"";
	}
	

}