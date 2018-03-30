package lab.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.catalina.valves.rewrite.Substitution.RewriteCondBackReferenceElement;
import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.hslf.record.Record;
import org.apache.poi.hslf.record.Slide;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.hibernate.sql.HSQLCaseFragment;
import org.junit.Test;

public class TestPPT_WORD {

	@Test
	public void testPPT() throws IOException {
		String path = "/Users/deity/Documents/4_버텍스아이디 김규표 프로파일.ppt";
		
		//파일을 읽기위해 엑셀파일을 가져온다
		FileInputStream fis=  getFileStrime(path);
		PowerPointExtractor extractor = new PowerPointExtractor(fis);
        String s = extractor.getText();
        
        String[] ss = s.split("\n");//\n으로 스플릿하면 될듯하다.
        int i =0;
        for(String line : ss){
        	System.out.println( i++ +"라인 :"+line);
        }
        
        
        
//        HSLFSlideShow ppt = new HSLFSlideShow(fis);
//        Record[] recodeList = ppt.getRecords();
//        
//        int i=0;
//        for(Record r : recodeList){
//        	System.out.print(i++);
//        	
//        	System.out.print(r.isAnAtom());
//        	System.out.println(r.toString());
//        }
        
//        SlideShow pptSlides = new SlideShow(ppt);
        
        
//        pptSlides.getDocumentRecord().get;
        
//        SlideShow[] s =pptSlides.getSlides().getSlides();
        
        
//        for(Slide slide :list){
//        	
//        }
//        System.out.println(pptSlides.getSlides().length);
        
		
		
		
        fis.close();
        
	}
	
	private FileInputStream getFileStrime(String path) throws IOException {
		File file = new File(path);
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			throw new IOException(path);
		}
		
		return new FileInputStream(path);
	}

}
