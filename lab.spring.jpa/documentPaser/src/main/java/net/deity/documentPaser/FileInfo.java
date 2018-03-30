package net.deity.documentPaser;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link 참조 http://blog.naver.com/PostView.nhn?blogId=admass&logNo=220533424691}
 * @author deity
 *
 */
public class FileInfo {
    static final Logger log = LoggerFactory.getLogger(FileInfo.class);
    
    private static final long serialVersionUID = -5845531127378217582L;
    
    private String objectId; 
    private String objectFunctionName;
    private String fileNo;
    private String fileName;
    private String fileSize;
    private String fileType;
    private String fileFullPath;
    private String fileRegDate;
    private String fileExt;//파일 확장자
    
    private String fileUrl;
    
    //    2015-11-05    추가    파일정보 추출정보를 저장하는 필드 추가 (DB에는 없음)
    private String fileSummary;
    
    public FileInfo(File file) {
			super();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd / HH:mm:ss");
	
			
			
			this.fileName = file.getName();
			this.fileSize = file.length()+"";//bytes
	//		this.fileType = fileType;
			this.fileFullPath = file.getAbsolutePath();
			this.fileRegDate = sf.format(file.lastModified());
			this.fileExt =fileName.substring( fileName.lastIndexOf( "." ) + 1 ); 
	//		this.fileUrl = fileUrl;
	//		this.fileSummary = fileSummary;
		}

	//     Extraction이 가능한 파일인지 판단하자.
    public boolean isExtractable()
    {
        if(StringUtils.isEmpty(fileName))
        {
            //    파일이름이 없으면 판단불가
            return false;
        }
        
        if(fileName.toLowerCase().contains(".pdf") || fileName.toLowerCase().contains(".hwp")
                || fileName.toLowerCase().contains(".doc") || fileName.toLowerCase().contains(".docx")
                || fileName.toLowerCase().contains(".xls") || fileName.toLowerCase().contains(".xlsx")
                || fileName.toLowerCase().contains(".ppt") || fileName.toLowerCase().contains(".pptx")
                || fileName.toLowerCase().contains(".txt")
            )
        {
            return true;
        } else
        {
            return false;
        }
    }
 
    /*
     * File DeleteUrl 구성
     */

    
    /*
     * URL을 갈제로 DB에서 지정하면 해당 디렉토리를 표시하고, 그렇지 않다면 새로운 URL을 지정해주자.
     * (OLD 파일들과의 호환성 유지를 위하여 사용)
     */

    
    /*
     * 단위 변환하여 String으로 Setting하자.
     */
    public void setFileSize(long fileSize) 
    {
        String bytes = (new Long(fileSize)).toString(); 
        Double size = Double.parseDouble(bytes);
        String[] s = { "bytes", "KB", "MB", "GB", "TB", "PB" };
        
        if (bytes != "0") 
        {
            int idx = (int) Math.floor(Math.log(size) / Math.log(1024));
            DecimalFormat df = new DecimalFormat("#,###.##");
            double ret = ((size / Math.pow(1024, Math.floor(idx))));
            this.fileSize = df.format(ret) + " " + s[idx];
        } else 
        {
            this.fileSize += " " + s[0];
        }
    }
    
    public String getObjectId() {
        return objectId;
    }
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
    public String getObjectFunctionName() {
        return objectFunctionName;
    }
    public void setObjectFunctionName(String objectFunctionName) {
        this.objectFunctionName = objectFunctionName;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileSize() {
        return fileSize;
    }
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public String getFileFullPath() {
        return fileFullPath;
    }
    public void setFileFullPath(String fileFullPath) {
        this.fileFullPath = fileFullPath;
    }
 
    public String getFileRegDate() {
        return fileRegDate;
    }
    public void setFileRegDate(String fileRegDate) {
        this.fileRegDate = fileRegDate;
    }
    public String getFileNo() {
        return fileNo;
    }
    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }
 
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
 
    public String getFileSummary() {
        return fileSummary;
    }
 
    public void setFileSummary(String fileSummary) {
        this.fileSummary = fileSummary;
    }

	@Override
	public String toString() {
		return "FileInfo [fileName=" + fileName + ", fileSize=" + fileSize + ", fileFullPath=" + fileFullPath
				+ ", fileRegDate=" + fileRegDate + "]";
	}
    
    
}
