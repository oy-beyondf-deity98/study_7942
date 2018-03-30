package lab.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.activation.MimetypesFileTypeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/**
 * 로우를 모두 통채로 저장할 필요도 있다.
 * 각 단어어 전체를 저장할 필요도 있다.
 * 
 * @author deity
 *
 */
public class TestExcel_Poi {

	/**
	 * 
	 * @link http://blog.naver.com/PostView.nhn?blogId=ken6ybn&logNo=100190884209
	 * @link http://hellogk.tistory.com/14 [IT Code Storage]
	 * 
	 * @throws IOException
	 * 
	 */
	@Test
	public void testXls() throws IOException {
		String path = "/Users/deity/Documents/data.xls";
		
		//파일을 읽기위해 엑셀파일을 가져온다
		FileInputStream fis=  getFileStrime(path);
		HSSFWorkbook workbook=new HSSFWorkbook(fis);
		
		for(int i= 0;i < workbook.getNumberOfSheets();i++){
			
			for( Row row : workbook.getSheetAt(i) ) {
				
				for( Cell cell : row ) {
					String value="";
					switch (cell.getCellType()){
	                case HSSFCell.CELL_TYPE_FORMULA:
	                    value=cell.getCellFormula();
	                    break;
	                case HSSFCell.CELL_TYPE_NUMERIC:
	                    value=cell.getNumericCellValue()+"";
	                    break;
	                case HSSFCell.CELL_TYPE_STRING:
	                    value=cell.getStringCellValue()+"";
	                    break;
	                case HSSFCell.CELL_TYPE_BLANK:
	                    value=cell.getBooleanCellValue()+"";
	                    break;
	                case HSSFCell.CELL_TYPE_ERROR:
	                    value=cell.getErrorCellValue()+"";
	                    break;
	                }
					
					System.out.println("각 셀 내용 :"+value);
				}
			}	
			
		}		
	}
	
	
	
	/**
	 * 와~ xlsx만 되네? xls는 안된다.
	 * 내일은 파일가져오는 문을 모두 써볼까?아니다...
	 * @throws IOException
	 */
	@Test
	public void testXlsx() throws IOException {
		String path = "/Users/deity/Documents/역사.xlsx";
		
		//파일을 읽기위해 엑셀파일을 가져온다
		FileInputStream fis=  getFileStrime(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);//추상리스트로 만들수 있는 방법이 모가 있을까?
		
		for(int i= 0;i < workbook.getNumberOfSheets();i++){
			
			for( Row row : workbook.getSheetAt(i) ) {
				
				for( Cell cell : row ) {
					String value="";
					switch (cell.getCellType()){
	                case HSSFCell.CELL_TYPE_FORMULA:
	                    value=cell.getCellFormula();
	                    break;
	                case HSSFCell.CELL_TYPE_NUMERIC:
	                    value=cell.getNumericCellValue()+"";
	                    break;
	                case HSSFCell.CELL_TYPE_STRING:
	                    value=cell.getStringCellValue()+"";
	                    break;
	                case HSSFCell.CELL_TYPE_BLANK:
	                    value=cell.getBooleanCellValue()+"";
	                    break;
	                case HSSFCell.CELL_TYPE_ERROR:
	                    value=cell.getErrorCellValue()+"";
	                    break;
	                }
					
					System.out.println("각 셀 내용 :"+value);
				}
			}	
			
		}		
	}



	private FileInputStream getFileStrime(String path) throws IOException {
		File file = new File(path);
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			throw new IOException(path);
		}
		
		return new FileInputStream(path);
	}



	/**
	 * 파일타입확인하는 방법
	 * {@link 참조  http://openeg.co.kr/519}
	 * 판단방법 {@link 판단방법 https://roadmichi.blogspot.kr/2015/03/apache-tika.html}
	 * 
	 * @throws IOException
	 * 
	 * 정확성은 아파치 tika가 최고이나 의존성이 짙다.
	 * 그렇지만 요즘은 확장자로 판단해도 괜찮을 것 같다.
	 * 
	 * nio로 하는것을 파일타입이 제한이 있다. 오피스계열은 안된다.
	 */
	@Test
	public void testFileType() throws IOException{
		String path = "/Users/deity/Documents/data.xls";
		Path source = Paths.get(path);
		System.out.println(Files.probeContentType(source));
		
		
		File f = new File("/Users/deity/Documents/data.xls");
		System.out.println(new MimetypesFileTypeMap().getContentType(f));
	}
}
