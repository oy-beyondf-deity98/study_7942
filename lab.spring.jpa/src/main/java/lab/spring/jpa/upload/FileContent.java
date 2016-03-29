package lab.spring.jpa.upload;

import java.io.File;

public class FileContent {
	private static final String _SEPER_ = File.separator;	// 서버 구분자
	
	private String rootUrl;
	private String rootDir;
	private String path;
	private String name;
	private String size;
	private String thumbUrl;
	private String url;
	private String file;
	
	public String getRootUrl() {
		return rootUrl;
	}
	public void setRootUrl(String rootUrl) {
		this.rootUrl = rootUrl;
	}
	public String getRootDir() {
		return rootDir;
	}
	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl() {
		this.url = this.rootUrl +"/"+ this.path +"/"+ this.name;;
	}
	public String getFile() {
		return file;
	}
	public void setFile() {
		this.file = this.rootDir +_SEPER_+ this.path +_SEPER_+ this.name;
	}
	
	
}
