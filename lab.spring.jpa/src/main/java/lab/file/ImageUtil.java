package lab.file;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {


	private static int width = 500;
	private static int height = 400;
	
	public static void imageResize(String input, String output) throws IOException{
		File in = new File(input);
		BufferedImage inputImage = ImageIO.read(in);

		//파일확장자분석
		int index = in.getName().lastIndexOf( "." );
		String fileExt = in.getName().substring( index+1 );
		
		//이미지리사이징하는 데이터
		String[] ext = {"bmp","gif","jpg","jpeg", "png"};
		
		for(String format :ext){
			if(fileExt.toUpperCase().equals(format.toUpperCase())){
				
				
				BufferedImage outputImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
				
		        Graphics2D g2 = outputImage.createGraphics();
		        g2.drawImage(inputImage, 0, 0, width, height, null);
		  
		        //출력파일에 대한 객체를 만들고 ImageIO.write로 출력
		        File outfile = new File(output);
		        ImageIO.write(outputImage, "jpg", outfile);					
			}
		}
	}
}
