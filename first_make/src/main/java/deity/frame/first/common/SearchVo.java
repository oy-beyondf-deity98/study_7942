package deity.frame.first.common;

import java.util.Map;



/**
 * @Class명: NaviVo
 * @작성일: 2014. 10. 18
 * @작성자: 김진호
 * @설명: 네비게이션 VO 
 * 페이징 개념의 쿼리를 위해서 사용
 */
public class SearchVo {
	
	private Map<String,String> params;		// 공통 파라메터, 여기서는 필요없을 듯하다.
	
	private int rowSize;					// 로우사이즈
	private int currPg;						// 현페이지
	private int totRow;						// 총로우 사이즈
	private String fnName;					// 페이지이동 script function 명
	private int start;						// 페이지 글시작 로우넘
	private int end;						// 페이지 글종료 로우넘
	
	private int rn;                         // row number
	
	private String search;
	
	
	public Map<String, String> getParams() {
		return params ;
	}
	public int getTotRow() {
		return totRow;
	}
	public void setTotRow(int totRow) {
		this.totRow = totRow;
	}
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	public int getRowSize() {
		return rowSize;
	}
	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}
	public int getCurrPg() {
		return currPg;
	}
	public void setCurrPg(int currPg) {
		this.currPg = currPg;
	}
	public String getFnName() {
		return fnName;
	}
	public void setFnName(String fnName) {
		this.fnName = fnName;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	
	public String getPagingStart(){
//		this.params = Encoder.isoToUtfMap(this.params);
		String sQuery="";
		sQuery+= "SELECT PAGE2.*														\n";
		sQuery+= "FROM (																\n";
		sQuery+= "       SELECT ROWNUM RN, PAGE1.*										\n";
		sQuery+= "		 FROM ( 														\n";
		
		sQuery+= "SELECT NO_PAGE.* , ROW_NUMBER() OVER (ORDER BY NO_DESC DESC) NO		\n";
		sQuery+= "FROM (																\n";
		sQuery+= "       SELECT NO_DESC_PAGE.* ,ROWNUM NO_DESC							\n";
		sQuery+= "		 FROM ( 														\n";
		return sQuery;
	}
	public String getPagingEnd(){
		int end= currPg * rowSize;
		int start = end - rowSize;
		this.end =end;
		this.start =start;
		String eQuery="";
		eQuery+= "		)NO_DESC_PAGE 													\n";
		eQuery+= ") NO_PAGE																\n";
		eQuery+= "ORDER BY NO_DESC														\n";
		
		
		eQuery+= "		) PAGE1 														\n";
		eQuery+= "		WHERE ROWNUM <= "+end+"											\n";
		eQuery+= ") PAGE2 																\n";
		eQuery+= "WHERE PAGE2.RN > "+start+"											\n";
		return eQuery;
	}
	
	public void pagingInit(){
		if(this.currPg==0){
			setCurrPg(1);
		}
		if(this.rowSize==0){
			setRowSize(10);
		}
		if(this.fnName == null){
			setFnName("move");
		}
	}
	
	@Override
	public String toString() {
		return "NaviVo [params=" + params + ", rowSize=" + rowSize
				+ ", currPg=" + currPg + ", totRow=" + totRow + ", fnName="
				+ fnName + "]";
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
}
