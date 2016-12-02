package deity.frame.first.common;

import deity.frame.first.common.SearchVo;

/**
 * @Class명: Navi
 * @작성일: 2014. 10. 2
 * @작성자: 김진호
 * @설명: 페이지 네비게이션
 * 화면에 page navigation을 위해서 사용
 */
public class Navi {
	
	private int rowSize = 10;		//로우사이즈
	private int pageSize = 10;		//페이지 수
	
	private int currentPage;		// 현재페이지
	private int totalRowCnt;		// 총 로우수
	private String fnName;			// 페이징처리 script 함수명
	
	/**
	 *@인자값
	 *<pre>String FnNm,	(펑션명)
	 *int totRow,	(전체로우)
	 *int currPg,	(현페이지번호)
	 *int viewRowSize	(리스트수)
	 *</pre>
	*/	
	public Navi (String FnNm,int totRow, int currPg, int viewRowSize) {
		this.setFnName(FnNm);
		this.setTotalRowCnt(totRow);
		this.setCurrentPage(currPg);
		this.setRowSize(viewRowSize);
	}
	/**
	 *@인자값
	 *<pre>NaviVo vo		(NaviVo)
	 *int totRow	(전체로우)  
	*/	
	public Navi (SearchVo vo, int totRow) {
		this.setFnName(vo.getFnName());
		this.setTotalRowCnt(totRow);
		this.setCurrentPage(vo.getCurrPg());
		this.setRowSize(vo.getRowSize());
	}
	/**
	 * @인자값 NaviVo vo 		(NaviVo 클래스)
	 */	
	public Navi (SearchVo vo) {
		this.setFnName(vo.getFnName());
		this.setTotalRowCnt(vo.getTotRow());
		this.setCurrentPage(vo.getCurrPg());
		this.setRowSize(vo.getRowSize());		
	}
	/**
	 *@설명 
	 *<pre>인자값 String FnNm,	(펑션명)
	 *int totRow,	(전체로우) 
	 *int currPg,	(현페이지번호) 
	 *화면 출력 Default Row  10줄
	 *</pre>
	*/	
	public Navi (String FnNm,int totRow, int currPg) {
		this.setFnName(FnNm);
		this.setTotalRowCnt(totRow);
		this.setCurrentPage(currPg);		
	}
	
	/**
	 * @메서드명: getPageNavi()
	 * @설명: paging 처리 Html 리턴
	 * @return String
	*/	
	public String getPageNavi() {
		
		int totalPageCnt = ((totalRowCnt + rowSize - 1) / rowSize);
		boolean nowFirst = (currentPage <= pageSize);
		boolean nowEnd = (totalPageCnt - 1) / pageSize * pageSize < currentPage;
		
		StringBuffer sbHtml = new StringBuffer();
		if(totalRowCnt > 0){
			int iStartPage = (currentPage - 1) / pageSize * pageSize + 1;
			int iEndPage = iStartPage + pageSize - 1;
			if(iEndPage > totalPageCnt)
				iEndPage = totalPageCnt;

			sbHtml.append("<ul>");
			sbHtml.append("<li><a href='javascript:"+fnName+"(1)'>처음</a></li>");
			
			if (nowFirst) {
				sbHtml.append("<li></li>");
			} else {
				sbHtml.append("<li><a href='javascript:"+fnName+"("+ (iEndPage - 10) + ")'>«</a></li>");
			}
			
			for (int i = iStartPage; i <= iEndPage; i++) {
				if (currentPage == i) {
					sbHtml.append("<li><a class='active' href='javascript:;'>"+ i +"</a></li>");
				} else {
					sbHtml.append("<li><a href='javascript:"+fnName+"("+ i + ")'> " + i + "</a></li>");
				}
			}		
			if (nowEnd) {
				sbHtml.append("<li></li>");
			} else {
				sbHtml.append("<li><a href='javascript:"+fnName+"("+ (iStartPage + 10) + ")'>»</a></li>");
			}
			
			sbHtml.append("<li><a href='javascript:"+fnName+"("+ (totalPageCnt) + ")'>마지막</a></li>");
			
			sbHtml.append("</ul>");
		}
		return sbHtml.toString();

	}
	
	public String getFnName() {
		return fnName;
	}
	public void setFnName(String fnName) {
		this.fnName = fnName;
	}
	public int getRowSize() {
		return rowSize;
	}
	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalRowCnt() {
		return totalRowCnt;
	}
	public void setTotalRowCnt(int totalRowCnt) {
		this.totalRowCnt = totalRowCnt;
	}
	
}
