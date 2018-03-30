package net.deity.documentPaser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.argo.hwp.HwpTextExtractor;

public class DocumentReader {
	static final Logger log = LoggerFactory.getLogger(FileInfo.class);
	
    //    파일정보에 있는 파일로부터 String Text를 추출하는 공통함수. 사전에 fileInfo에 파일정보를 담고 와야 한다.
    public String extractStringTextFromFileInfo(FileInfo fileInfo)
    {
        //    1. 우선 해당 파일 정보를 받는다.
        if(fileInfo==null || StringUtils.isEmpty(fileInfo.getFileFullPath()) || StringUtils.isEmpty(fileInfo.getFileName()))
        {
            log.info("[extractStringTextFromFileInfo] 해당 파일정보가 존재하지 않습니다.");
            return null;
        }
        
//        log.info("추출작업 시작 : " + fileInfo.getFileFullPath());
        
        //    2. 파일 타입을 구분하여 확장자에 따라서 Extraction을 진행한다.
        if(fileInfo.getFileName().toLowerCase().endsWith(".pdf"))
        {
            try
            {
                String pdfText = getStringTextFromPDF(fileInfo);
                
//                log.info("파일 " + fileInfo.getFileFullPath() + " 에 대한 추출결과 : " + pdfText);
                
                return pdfText;
            } catch (Exception e)
            {
                log.info("[extractStringTextFromFileInfo] PDF 파일정보 추출에 실패하였습니다. 파일명 : " + fileInfo.getFileFullPath() + " / 추출과정 오류 : " + e.getMessage());
                return null;
            }
        } else if(fileInfo.getFileName().toLowerCase().endsWith(".doc"))
        {
            try
            {
                String docText = getStringTextFromDOC(fileInfo);
                
//                log.info("파일 " + fileInfo.getFileFullPath() + " 에 대한 추출결과 : " + docText);
                
                return docText;
            } catch (Exception e)
            {
                log.info("[extractStringTextFromFileInfo] DOC 파일정보 추출에 실패하였습니다. 파일명 : " + fileInfo.getFileFullPath() + " / 추출과정 오류 : " + e.getMessage());
                return null;
            }            
        } else if(fileInfo.getFileName().toLowerCase().endsWith(".xls"))
        {
            try
            {
                String xlsText = getStringTextFromXLS(fileInfo);
                
//                log.info("파일 " + fileInfo.getFileFullPath() + " 에 대한 추출결과 : " + xlsText);
                
                return xlsText;
            } catch (Exception e)
            {
                log.info("[extractStringTextFromFileInfo] XLS 파일정보 추출에 실패하였습니다. 파일명 : " + fileInfo.getFileFullPath() + " / 추출과정 오류 : " + e.getMessage());
                return null;
            }            
        } else if(fileInfo.getFileName().toLowerCase().endsWith(".ppt"))
        {
            try
            {
                String pptText = getStringTextFromPPT(fileInfo);
                
//                log.info("파일 " + fileInfo.getFileFullPath() + " 에 대한 추출결과 : " + pptText);
                
                return pptText;
            } catch (Exception e)
            {
                log.info("[extractStringTextFromFileInfo] PPT 파일정보 추출에 실패하였습니다. 파일명 : " + fileInfo.getFileFullPath() + " / 추출과정 오류 : " + e.getMessage());
                return null;
            }            
        } else if(fileInfo.getFileName().toLowerCase().endsWith(".docx"))
        {
            try
            {
                String docxText = getStringTextFromDOCX(fileInfo);
                
//                log.info("파일 " + fileInfo.getFileFullPath() + " 에 대한 추출결과 : " + docxText);
                
                return docxText;
            } catch (Exception e)
            {
                log.info("[extractStringTextFromFileInfo] DOCX 파일정보 추출에 실패하였습니다. 파일명 : " + fileInfo.getFileFullPath() + " / 추출과정 오류 : " + e.getMessage());
                return null;
            }            
        } else if(fileInfo.getFileName().toLowerCase().endsWith(".pptx"))
        {
            try
            {
                String pptxText = getStringTextFromPPTX(fileInfo);
                
//                log.info("파일 " + fileInfo.getFileFullPath() + " 에 대한 추출결과 : " + pptxText);
                
                return pptxText;
            } catch (Exception e)
            {
                log.info("[extractStringTextFromFileInfo] PPTX 파일정보 추출에 실패하였습니다. 파일명 : " + fileInfo.getFileFullPath() + " / 추출과정 오류 : " + e.getMessage());
                return null;
            }            
        } else if(fileInfo.getFileName().toLowerCase().endsWith(".xlsx"))
        {
            try
            {
                String xlsxText = getStringTextFromXLSX(fileInfo);
                
//                log.info("파일 " + fileInfo.getFileFullPath() + " 에 대한 추출결과 : " + xlsxText);
                
                return xlsxText;
            } catch (Exception e)
            {
                log.info("[extractStringTextFromFileInfo] XLSX 파일정보 추출에 실패하였습니다. 파일명 : " + fileInfo.getFileFullPath() + " / 추출과정 오류 : " + e.getMessage());
                return null;
            }            
        } else if(fileInfo.getFileName().toLowerCase().endsWith(".hwp"))
        {
            try
            {
                String hwpText = getStringTextFromHWP(fileInfo);
                
//                log.info("파일 " + fileInfo.getFileFullPath() + " 에 대한 추출결과 : " + hwpText);
                
                return hwpText;
            } catch (Exception e)
            {
                log.info("[extractStringTextFromFileInfo] HWP 파일정보 추출에 실패하였습니다. 파일명 : " + fileInfo.getFileFullPath() + " / 추출과정 오류 : " + e.getMessage());
                return null;
            }            
        } else
        {
            //    분류코드에 들지 않는 경우에는 파일을 Text로 열어서 해당 정보를 그대로 내보낸다.
            //    이 경우 HTML이 있을 수도 있으므로 HTML TAG는 제거하여 보낸다. (MHTML등등)
            try
            {
                String generalText = getStringTextFromTextFile(fileInfo);
                generalText = generalText.replaceAll("\\<.*?\\>", "");
                
//                log.info("파일 " + fileInfo.getFileFullPath() + " 에 대한 추출결과 : " + generalText);
                
                return generalText;
            } catch (Exception e)
            {
                log.info("[extractStringTextFromFileInfo] HWP 파일정보 추출에 실패하였습니다. 파일명 : " + fileInfo.getFileFullPath() + " / 추출과정 오류 : " + e.getMessage());
                return null;
            }
        }
    }
 
    //    각종파일 추출기능
    //    http://develop.sunshiny.co.kr/913 및 https://github.com/ddoleye/java-hwp 참고
    
    private String getStringTextFromTextFile(FileInfo fileInfo) throws Exception 
    {
        StringBuffer sb = new StringBuffer();
        
        BufferedReader in = new BufferedReader(new FileReader(fileInfo.getFileFullPath()));
        String tempOneLine;
        while ((tempOneLine = in.readLine()) != null) 
        {
            sb.append(tempOneLine);
        }
        in.close();
        
        return sb.toString();
    }
 
    private String getStringTextFromHWP(FileInfo fileInfo) throws Exception 
    {
        checkValidationForFileInfo(fileInfo);
        
        File hwp = new File(fileInfo.getFileFullPath()); // 텍스트를 추출할 HWP 파일
        Writer writer = new StringWriter(); // 추출된 텍스트를 출력할 버퍼
        HwpTextExtractor.extract(hwp, writer); // 파일로부터 텍스트 추출
        String text = writer.toString(); // 추출된 텍스트
        
        return text;
    }
 
    private String getStringTextFromXLSX(FileInfo fileInfo) throws Exception 
    {
        checkValidationForFileInfo(fileInfo);
        
        FileInputStream fs = new FileInputStream(new File(fileInfo.getFileFullPath()));
        OPCPackage d = OPCPackage.open(fs);
        XSSFExcelExtractor xe = new XSSFExcelExtractor(d);
        xe.setFormulasNotResults(true);
        xe.setIncludeSheetNames(true);
        return xe.getText();
    }
 
    private String getStringTextFromPPTX(FileInfo fileInfo) throws Exception
    {
        checkValidationForFileInfo(fileInfo);
        
        FileInputStream fs = new FileInputStream(new File(fileInfo.getFileFullPath()));
        OPCPackage d = OPCPackage.open(fs);
        XSLFPowerPointExtractor xp = new XSLFPowerPointExtractor(d);
        return xp.getText();
    }
 
    private String getStringTextFromDOCX(FileInfo fileInfo) throws Exception 
    {
        checkValidationForFileInfo(fileInfo);
        
        FileInputStream fs = new FileInputStream(new File(fileInfo.getFileFullPath()));
        OPCPackage d = OPCPackage.open(fs);
        XWPFWordExtractor xw = new XWPFWordExtractor(d);
        return xw.getText();
    }
 
    private String getStringTextFromPPT(FileInfo fileInfo) throws Exception
    {
        checkValidationForFileInfo(fileInfo);
        
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fileInfo.getFileFullPath()));
        PowerPointExtractor extractor = new PowerPointExtractor(fs);
        return extractor.getText();
    }
 
    private String getStringTextFromXLS(FileInfo fileInfo) throws Exception
    {
        checkValidationForFileInfo(fileInfo);
        
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fileInfo.getFileFullPath()));
        ExcelExtractor ex = new ExcelExtractor(fs);
        ex.setFormulasNotResults(true);
        ex.setIncludeSheetNames(true);
        return ex.getText();
    }
 
    //    DOC 파일추출기능    /    
    private String getStringTextFromDOC(FileInfo fileInfo) throws Exception
    {
        checkValidationForFileInfo(fileInfo);
        
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fileInfo.getFileFullPath()));
        HWPFDocument doc = new HWPFDocument(fs);
        WordExtractor we = new WordExtractor(doc); 
        return we.getText();
    }
 
    //    PDF 파일 추출기능    /    오류 발생시 모두 Exception으로 처리하자.
    private String getStringTextFromPDF(FileInfo fileInfo) throws Exception 
    {
        checkValidationForFileInfo(fileInfo);
        
        String resultText = "";
        
        FileInputStream fi = new FileInputStream(new File(fileInfo.getFileFullPath()));
        PDFParser parser = new PDFParser(fi);
        parser.parse();
        COSDocument cd = parser.getDocument();
        PDFTextStripper stripper = new PDFTextStripper();
        resultText = stripper.getText(new PDDocument(cd));
        cd.close();
        
        return resultText;
    }
 
    private void checkValidationForFileInfo(FileInfo fileInfo) {
        if(fileInfo==null || StringUtils.isEmpty(fileInfo.getFileFullPath()) || StringUtils.isEmpty(fileInfo.getFileName()))
        {
            throw new IllegalArgumentException("입력된 파일 정보가 올바르지 않습니다.");
        }
    }
	
}
