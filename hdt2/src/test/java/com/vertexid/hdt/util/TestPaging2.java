package com.vertexid.hdt.util;

import java.util.Iterator;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 1. 데이터수/보여주고싶은수
 * 2. 첫페이지<< < 1,2,3,4,5,6,7,8,9,10 > >> 마지막페이지 
 * @author kimgyupyo
 *
 */
public class TestPaging2 {
	int 총데이터 = 0;
	int 한번에보고싶은데이터갯수 = 0;
	int 한번에보여주고싶은페이지수 = 0;
	int 현재페이지 = 0;
	
	boolean isFirstPage = false;
	boolean isLastPage = false;
	boolean isPreGroupPage = false;
	boolean isNextGroupPage = false;
	
	//아래것은 수정할수 있게한다.
	String FIRST_PAGE = "처음 ";
	String LAST_PAGE = " 마지막";
	String PRE_PAGE = "<";
	String NEXT_PAGE = ">";
	
	String 페이지구분자 = ",";
	
	/**
	 * 데이터수가 보여주고 싶은수보다 작을때
	 * 페이지갯수를 판단한다.
	 */
	@Test
	public void test1(){
		this.총데이터 = 4;
		this.한번에보고싶은데이터갯수 = 10;
		
		Assert.assertEquals(1,페이지갯수());
		
	}
	
	/**
	 * 데이터수와 보여주고 싶은수가 같을때
	 */
	@Test
	public void test2(){
		this.총데이터 = 10;
		this.한번에보고싶은데이터갯수 = 10;
		
		Assert.assertEquals(1,페이지갯수());
	}
	
	/**
	 * 딱떨어질때
	 * 갯수를 확인한다.
	 */
	@Test
	public void test3(){
		this.총데이터 = 100;
		this.한번에보고싶은데이터갯수 = 10;
		
		Assert.assertEquals(10,페이지갯수());
		
	}
	
	/**
	 * 2개생성되고 갯수보다 많을때 갯수를 본다.
	 */
	@Test
	public void test4(){
		this.총데이터 = 12;
		this.한번에보고싶은데이터갯수 = 10;
		
		Assert.assertEquals(2,페이지갯수());
		
	}
	
	/**
	 * 10의 배수가 아닌값을 산정해본다.
	 */
	@Test
	public void test5(){
		this.총데이터 = 186;
		this.한번에보고싶은데이터갯수 = 7;
		
		Assert.assertEquals(27,페이지갯수());
		
	}
	
	/**
	 * 1. 처음, <, >, 끝 이것들이 있는지 확인
	 * 2. <<, <, >, >> 누른후에 페이지번호
	 * 3. 현재의 페이지위치도 파악해야하나?
	 * 4. 페이지그룹갯수를 파악한다.
	 * 
	 * 페이지수가 페이지그룹수보다 작을때 
	 */
	@Test
	public void test11(){
		this.총데이터 = 4;
		this.한번에보고싶은데이터갯수 = 10;
		this.한번에보여주고싶은페이지수 = 10;
		
		Assert.assertEquals(1,페이지그룹갯수());
		
	}
	
	/**
	 * 페이지수가 페이지그룹과 같을때
	 */
	@Test
	public void test12(){
		this.총데이터 = 100;
		this.한번에보고싶은데이터갯수 = 10;
		this.한번에보여주고싶은페이지수 = 10;
		
		Assert.assertEquals(1,페이지그룹갯수());
		
	}
	
	/**
	 * 페이지수가 페이지그룹과 딱떨어질
	 */
	
	@Test
	public void test13(){
		this.총데이터 = 1000;
		this.한번에보고싶은데이터갯수 = 10;
		this.한번에보여주고싶은페이지수 = 10;
		
		Assert.assertEquals(10, 페이지그룹갯수());
	}
	
	/**
	 * 페이지수가 페이지그룹과 딱떨어지지 않을때
	 */
	
	@Test
	public void test14(){
		this.총데이터 = 1503;
		this.한번에보고싶은데이터갯수 = 10;
		this.한번에보여주고싶은페이지수 = 10;
		
		Assert.assertEquals(16, 페이지그룹갯수());
	}
	
	/**
	 * 페이지수가 페이지그룹과 딱떨어지지 않을때
	 */
	
	@Test
	public void test15(){
		this.총데이터 = 1503;
		this.한번에보고싶은데이터갯수 = 7;
		this.한번에보여주고싶은페이지수 = 9;
		
		Assert.assertEquals(24, 페이지그룹갯수());
	}
	
	@Test
	public void test21(){
		this.총데이터 = 1503;
		this.한번에보고싶은데이터갯수 = 7;
		this.한번에보여주고싶은페이지수 = 9;
		this.현재페이지 = 82;
		
		//System.out.println(갯수계산(this.현재페이지,this.한번에보여주고싶은페이지수));
		
		Assert.assertEquals(24, 페이지그룹갯수());
	}
	
	//테스트할데이터를 만들기
	@Test
	public void test22(){
		this.총데이터 = 0;
		this.한번에보고싶은데이터갯수 = 10;
		this.한번에보여주고싶은페이지수 = 10;
		this.현재페이지 = 99;
		
		System.out.println(페이지갯수());
		System.out.println(페이지그룹갯수());
		페이지앞뒤확인();
		System.out.println(toString());
	}
	
	private String 페이지번호리스트출력(){
		StringBuffer sb = new StringBuffer();
		if(this.현재페이지 <= this.한번에보여주고싶은페이지수){
			int 마지막번호 = this.현재페이지;
			int 시작번호 = 1;
			
			for(int i =시작번호;i<=마지막번호;i++){
				if(i < 마지막번호){
					sb.append(i).append(this.페이지구분자);	
				}else{
					sb.append(i);
				}
			}
		}else if(현재페이지소속그룹() ==페이지그룹갯수()){
			
			int 마지막번호 = 페이지갯수();
			int 시작번호 = (페이지그룹갯수()-1) * this.한번에보여주고싶은페이지수 +1;
			for(int i =시작번호;i<=마지막번호;i++){
				if(i < 마지막번호){
					sb.append(i).append(this.페이지구분자);	
				}else{
					sb.append(i);
				}
			}
		}else if(this.총데이터 ==0){
			
		}else if(this.현재페이지 > 페이지갯수()){
			
		}else{
			int 현재그룹페이지 = 현재페이지소속그룹() ==1?현재페이지소속그룹():현재페이지소속그룹()-1;
			int 마지막번호 = 현재그룹페이지*this.한번에보여주고싶은페이지수+this.한번에보여주고싶은페이지수;
			int 시작번호 = 현재그룹페이지*this.한번에보여주고싶은페이지수+1;
			for(int i =시작번호;i<=마지막번호;i++){
				if(i < 마지막번호){
					sb.append(i).append(this.페이지구분자);	
				}else{
					sb.append(i);
				}
			}
		}
		
		//데코레이션패턴을 넣고싶은데... 어찌해야하나?
		return sb.toString();
	}
	
	private void 페이지앞뒤확인(){
		if(페이지갯수() ==1){ //1개의 페이지만 있을때
			this.isFirstPage = false;
			this.isPreGroupPage = false;
			this.isNextGroupPage =false;
			this.isLastPage = false;
		}else if(this.현재페이지 <= this.한번에보여주고싶은페이지수){//1개의 페이지그룹만 있을때
			this.isFirstPage = true;
			this.isPreGroupPage = false;
			this.isNextGroupPage =false;
			this.isLastPage = false;
		}else if(페이지그룹갯수() > 1 && 현재페이지소속그룹() > 1){//그룹이 1개이상있을때
			if(this.현재페이지 == 페이지갯수()){//마지막페이지일때
				this.isFirstPage = true;
				this.isPreGroupPage = true;
				this.isNextGroupPage =false;
				this.isLastPage = false;	
			}else if(현재페이지소속그룹() ==페이지그룹갯수() ){//마지막페이지그룹일때
				this.isFirstPage = true;
				this.isPreGroupPage = true;
				this.isNextGroupPage =false;
				this.isLastPage = true;
			}else{//일반적인 경우, 중간단계에서...
				this.isFirstPage = true;
				this.isPreGroupPage = true;
				this.isNextGroupPage =true;
				this.isLastPage = true;
			}
		}
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		if(this.isFirstPage) sb.append(FIRST_PAGE);
		if(this.isPreGroupPage) sb.append(PRE_PAGE);
		sb.append(페이지번호리스트출력());
		if(this.isNextGroupPage) sb.append(NEXT_PAGE);
		if(this.isLastPage) sb.append(LAST_PAGE);
		
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
	
	
					
}
