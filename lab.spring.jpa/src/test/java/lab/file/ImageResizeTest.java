package lab.file;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import org.junit.Test;

public class ImageResizeTest {

	private String inputFile ="C:/UCWARE/Seoul Milk Messenger/Download/거창공장.png";
	private String outputFile ="C:/UCWARE/Seoul Milk Messenger/Download/거창공장.jpg";
	private String outputFile2 ="C:/Users/deity/Documents/버텍스아이디/서울우유/1.진행중/강남지점(분당사무동)2.jpg";
	

	@Test
	public void test() throws IOException{
		int width = 500;
		int height = 500;
		
		ParameterBlock pb = new ParameterBlock();
        pb.add(inputFile);
        RenderedOp rOp = JAI.create("fileload", pb);

        //실제 크기 변경을 위한 셋팅
        System.setProperty("java.awt.headless", "true"); 

        //입력 파일에 대해 BufferedImage형식으로 받아 온다.
        BufferedImage im = rOp.getAsBufferedImage();
  
        //썸네일(리사이즈)이미지를 위한 공간을 만든다. 50,50은 width, height
        BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
  
        //썸네일 버퍼공간에 대해 Graphics2D객체를 얻어와서 입력이미지에 있는 내용을 그린다.(0,0위치에 50,50크기로 복사)
        Graphics2D g2 = thumb.createGraphics();
        g2.drawImage(im, 0, 0, width, height, null);
  
        //출력파일에 대한 객체를 만들고 ImageIO.write로 출력
        File outfile = new File(outputFile);
        ImageIO.write(thumb, "jpg", outfile);		
	}

	@Test
	public void testOrg() throws IOException{
		File in = new File(inputFile);
		BufferedImage inputImage = ImageIO.read(in);
		
		int width = 500;
		int height = 500;
		
		String[] ext = {"bmp","gif","jpg","jpeg", "png"};
		
		for(String format :ext){
			BufferedImage outputImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			
	        Graphics2D g2 = outputImage.createGraphics();
	        g2.drawImage(inputImage, 0, 0, width, height, null);
	  
	        //출력파일에 대한 객체를 만들고 ImageIO.write로 출력
	        File outfile = new File(outputFile2);
	        ImageIO.write(outputImage, "jpg", outfile);	
		}
	}
	
	@Test
	public void testClass() throws IOException{
		ImageUtil.imageResize(inputFile, outputFile);
	}
	
	@Test
	public void testReal() throws IOException{
		
		//FileUtil fileUtil = new FileUtil();
		//fileUtil.setFileList("//파일서버/프로젝트/재산관리시스템/7. 기타/서울우유사진");
		String path="C:/Users/deity/Documents/버텍스아이디/서울우유/upload";
		//String outPath="//파일서버/프로젝트/재산관리시스템/7. 기타/서울우유사진/리사이즈";
		List<String> listFile = new ArrayList<String>();
		
		FileUtil fUtil = new FileUtil();//static로 만들어야할듯
		listFile = fUtil.setFileList(path).getFilesAll();
		
		for(String s : listFile){
			
			//String outFileName = s.replace("\\upload2\\", "\\upload\\");
			System.out.println(s);
			//ImageUtil.imageResize(s, outFileName);
		}
	}
}
