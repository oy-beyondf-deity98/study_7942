package lab.file;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 엑셀은 xls와 xlsx읽는 방법으로 나뉜다.
 * 일단 jxl이 간단합니다. 하지만 POI는 jfree와 연동해서 엑셀을 임포트할때 그래프를 넣는등
더 다양하게 엑셀을 생성할 수 있습니다.
 * 속도면에서 비교표 : http://yjacket.tistory.com/66
 * 결과 : 속도는 JXL 이 가장 빠르고, 파일 크기는 POI(xlsx)가 가장 작다.
 * jxl은 xlsx을 읽을수 없는것 같다.
 * @author deity
 * 나의 목적은 엑셀에서 데이터를 읽어오는 것이다.
 * 엑셀은 리스트이므로 첫줄은 header로 보는것도 좋은방법이다.
 */
public class TestExcel_JXL {

	@Test
	public void test() throws BiffException, IOException {
		Workbook workbook = null;
		String path = "/Users/deity/Documents/data.xls";
		workbook = Workbook.getWorkbook(new File(path));
		int sheetnumber = workbook.getNumberOfSheets();
		
		for(Sheet sheet:workbook.getSheets()){
			
			int rowCount = sheet.getRows();
			int colCount = sheet.getColumns();
			
			if(rowCount > 0 && colCount > 0){
				for(int i=0;i<rowCount;i++){
					String head = "";
					StringBuffer body = new StringBuffer();
					for(int k=0;k<colCount;k++){
						Cell cell = sheet.getCell(k,i);
						if(cell == null) continue;
						System.out.println("["+i+","+k+"]"+cell.getContents());
					}
				}
			}
			
		}
//		System.out.println(sheetnumber);
	}
	
	@Test
	public void testWrite() throws IOException, RowsExceededException, WriteException, InterruptedException{
		String url = "/Users/deity/Documents/data_write.xls";

		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		
		File execFile = new File(url);
		Label label = null;
		
		for(int i = 0; i<10;i++){
			workbook = Workbook.createWorkbook(execFile);
			workbook.createSheet("sheet1", 0);
			sheet = workbook.getSheet(0);
			
			for(int j = 0; j< 30;j++){
				label = new Label(j,0,"test finally");
				sheet.addCell(label);
			}
			workbook.write();
		}
		
		workbook.close();
	}	

}
