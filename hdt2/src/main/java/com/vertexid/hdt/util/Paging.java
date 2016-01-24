package com.vertexid.hdt.util;


/**
 *  
 * @author kimgyupyo
 *
 * 구해야할 것
 * 	- 페이지의 총리스트갯수
 *  - 현재화면에 보여주는 페이지리스트
 *  - 현재는 페이지의 어느곳에 있는가?
 *  - 페이지그룹이라는 단위를 만들어서 어디에 속해있는지 계산해서 보내도록한다.
 */
public class Paging {
	
	private int pageNo;			//페이지번호,현재페이지번호
	private int totalCount; 	//컨텐츠 총갯수
	private int listSize; 		//한화면에 보여질 목록 갯수
	private int pagingListSize; //한화면에 보여질 페이징 갯수
	
	static int 총데이터 = 0;
	static int 한번에보고싶은데이터갯수 = 0;
	static int 한번에보여주고싶은페이지수 = 0;
	static int 현재페이지 = 0;
	
	private static int 현재페이지소속그룹 = 0;
	private static int 페이지그룹갯수 = 0;
	private static int 페이지갯수 = 0;
		
	
	
	public Paging(int curPageNo,int totalCount, int dataListSize, int pagingListSize){
		
		
		this.현재페이지 = curPageNo;
		this.총데이터 = totalCount;
		this.한번에보고싶은데이터갯수 =  dataListSize;
		this.한번에보여주고싶은페이지수 = pagingListSize;
		
		this.현재페이지소속그룹 = 현재페이지소속그룹();
		this.페이지그룹갯수 = 페이지그룹갯수();
		this.페이지갯수 = 페이지갯수();
		
		View.페이지앞뒤확인();
	}
	
	@Override
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		if(View.isFirstPage) sb.append(View.FIRST_PAGE);
		if(View.isPreGroupPage) sb.append(View.PRE_PAGE);
		sb.append(View.페이지번호리스트출력());
		if(View.isNextGroupPage) sb.append(View.NEXT_PAGE);
		if(View.isLastPage) sb.append(View.LAST_PAGE);
		
		return sb.toString();
	}
	
	private int 현재페이지소속그룹(){
		return 갯수계산(this.현재페이지,this.한번에보여주고싶은페이지수);
	}
	private int 페이지그룹갯수(){
		return 갯수계산(페이지갯수(),this.한번에보여주고싶은페이지수);
	}
	
	private int 페이지갯수(){
		return 갯수계산(this.총데이터,this.한번에보고싶은데이터갯수);
	}
	
	private int 갯수계산(int 총갯수,int 보여주고싶은갯수){
		int 계산법 = 총갯수/보여주고싶은갯수;
		
		return 총갯수%보여주고싶은갯수==0?계산법:계산법+1;
		
	}
	
	
	static class View{
		//아래것은 수정할수 있게한다.
		static String FIRST_PAGE = "처음 ";
		static String LAST_PAGE = " 마지막";
		static String PRE_PAGE = "<";
		static String NEXT_PAGE = ">";
		
		static boolean isFirstPage = false;
		static boolean isLastPage = false;
		static boolean isPreGroupPage = false;
		static boolean isNextGroupPage = false;
		
		static String 페이지구분자 = ",";		

		static private String 페이지번호리스트출력(){
			StringBuffer sb = new StringBuffer();
			 if(총데이터 ==0){
					
			}else if(현재페이지 > 페이지갯수){
					
			}else if(현재페이지 <= 한번에보여주고싶은페이지수){
				int 마지막번호 = 현재페이지;
				int 시작번호 = 1;
				
				for(int i =시작번호;i<=마지막번호;i++){
					if(i < 마지막번호){
						sb.append(i).append(페이지구분자);	
					}else{
						sb.append(i);
					}
				}
			}else if(현재페이지소속그룹 ==페이지그룹갯수){
				
				int 마지막번호 = 페이지갯수;
				int 시작번호 = (페이지그룹갯수-1) * 한번에보여주고싶은페이지수 +1;
				for(int i =시작번호;i<=마지막번호;i++){
					if(i < 마지막번호){
						sb.append(i).append(페이지구분자);	
					}else{
						sb.append(i);
					}
				}
			}else{
				int 현재그룹페이지 = 현재페이지소속그룹 ==1?현재페이지소속그룹:현재페이지소속그룹-1;
				int 마지막번호 = 현재그룹페이지*한번에보여주고싶은페이지수+한번에보여주고싶은페이지수;
				int 시작번호 = 현재그룹페이지*한번에보여주고싶은페이지수+1;
				for(int i =시작번호;i<=마지막번호;i++){
					if(i < 마지막번호){
						sb.append(i).append(페이지구분자);	
					}else{
						sb.append(i);
					}
				}
			}
			
			//데코레이션패턴을 넣고싶은데... 어찌해야하나?
			return sb.toString();
		}
		
		static private void 페이지앞뒤확인(){
			if(페이지갯수 ==1 || 페이지갯수 ==0 || 현재페이지 > 페이지갯수 ){ //1개의 페이지만 있을때
				isFirstPage = false;
				isPreGroupPage = false;
				isNextGroupPage =false;
				isLastPage = false;
			}else if(현재페이지 <= 한번에보여주고싶은페이지수){//1개의 페이지그룹만 있을때
				isFirstPage = true;
				isPreGroupPage = false;
				isNextGroupPage =false;
				isLastPage = false;
			}else if(페이지그룹갯수 > 1 && 현재페이지소속그룹 > 1){//그룹이 1개이상있을때
				if(현재페이지 == 페이지갯수){//마지막페이지일때
					isFirstPage = true;
					isPreGroupPage = true;
					isNextGroupPage =false;
					isLastPage = false;	
				}else if(현재페이지소속그룹 ==페이지그룹갯수 ){//마지막페이지그룹일때
					isFirstPage = true;
					isPreGroupPage = true;
					isNextGroupPage =false;
					isLastPage = true;
				}else{//일반적인 경우, 중간단계에서...
					isFirstPage = true;
					isPreGroupPage = true;
					isNextGroupPage =true;
					isLastPage = true;
				}
			}
		}		
		
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getPagingListSize() {
		return pagingListSize;
	}

	public void setPagingListSize(int pagingListSize) {
		this.pagingListSize = pagingListSize;
	}
	
	
	
	
}
