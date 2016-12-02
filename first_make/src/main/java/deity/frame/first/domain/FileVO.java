package deity.frame.first.domain;

public class FileVO extends CommonVo {

	private int file_seq;
	private String file_path;
	private String fiel_name;
	private String file_content;
	private String file_ext;
	private String file_type;
	private int Master_file_seq;
	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFiel_name() {
		return fiel_name;
	}
	public void setFiel_name(String fiel_name) {
		this.fiel_name = fiel_name;
	}
	public String getFile_content() {
		return file_content;
	}
	public void setFile_content(String file_content) {
		this.file_content = file_content;
	}
	public String getFile_ext() {
		return file_ext;
	}
	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public int getMaster_file_seq() {
		return Master_file_seq;
	}
	public void setMaster_file_seq(int master_file_seq) {
		Master_file_seq = master_file_seq;
	}
	

	
}