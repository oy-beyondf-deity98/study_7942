package lab.spring.jpa.upload;

/**
 * 파일업로드 참조 : http://blog.netgloo.com/2015/02/08/spring-boot-file-upload-with-ajax/
 * 
 * 1메가 이상할려면 설정을 바꿔야한다. 멀티파티...
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Controller
public class FileController {
	private static final String _SEPER_ = File.separator;	// 서버 구분자
	private static int width = 500;
	private static int height = 400;	
	private static boolean isImageResize = false;
	FileContent fileContent = new FileContent();
	
	@RequestMapping(value ="uploadfile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile uploadfile){
		System.out.println("컨트롤러를 몇번이나 타는거야???");
		String root = request.getSession().getServletContext().getRealPath("/");
		String uploadDir = root + _SEPER_ +"upload";
		
		fileUpload(uploadDir, uploadfile);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(fileContent);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=UTF-8");
		
		
	    return new ResponseEntity<>(json,responseHeaders,HttpStatus.OK);
	}
	
	private void fileUpload(String uploadDir, MultipartFile uploadfile){
		//디렉토리 체크
		File dir = new File(uploadDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		String filename = uploadfile.getOriginalFilename();
	    String filepath = Paths.get(uploadDir, filename).toString();
	    
	    //System.out.println("업로드 디렉토리:"+uploadDir);
	    BufferedOutputStream stream = null;
	    
		try {
			
			boolean imageResize = false;
			
			//이미지 리사이징을 허락하고, 이미지리사징파일이면 이미지 리사이징을 한다.
			if(isImageResize) imageResize = imageResize(filepath,uploadfile);
			//이미지 파일이 아니면 파일을 업로드 한다.
			if(!imageResize){
				stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				stream.write(uploadfile.getBytes());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally{
			try {	stream.close();	} catch (IOException e) {}
		}    
	    

	    fileContent.setUrl(filepath);
	    fileContent.setName(filename);
	    
	}

	private boolean imageResize(String filepath, MultipartFile uploadfile) throws IllegalStateException, IOException {
		//파일확장자분석
		String fileExt = filepath.substring(filepath.lastIndexOf(".")+1);
		//이미지리사이징하는 데이터
		String[] ext = {"bmp","gif","jpg","jpeg", "png"};
		
		boolean flag = false;
		
		for(String format :ext){
//			if(fileExt.equals(format)){
			if(fileExt.toUpperCase().equals(format.toUpperCase())){
				BufferedImage inputImage = ImageIO.read(multipartToFile(uploadfile));
				BufferedImage outputImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		        Graphics2D g2 = outputImage.createGraphics();
		        g2.drawImage(inputImage, 0, 0, width, height, null);
		        //출력파일에 대한 객체를 만들고 ImageIO.write로 출력
		        File outfile = new File(filepath);
		        ImageIO.write(outputImage, "jpg", outfile);
		        flag = true;
			}
		}
		return flag;
	}
	
	private File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException 
	{
	        File convFile = new File( multipart.getOriginalFilename());
	        multipart.transferTo(convFile);
	        return convFile;
	}	
}


