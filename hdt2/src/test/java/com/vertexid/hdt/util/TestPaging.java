package com.vertexid.hdt.util;

import java.util.Iterator;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 1. 기본
 * 	ㄱ. 1000개 데이터 페이징 : 10개씩
 * 		- 첫페이지
 * 		- 두번째 페이지
 * 		- 11번째 페이지
 * 		- 마지막 페이지
 * @author kimgyupyo
 *
 */
public class TestPaging {
	
	@Test
	public void 테스트(){
		int 총데이터 = 0;
		int 한번에보고싶은데이터갯수 = 10;
		int 한번에보여주고싶은페이지수 = 10;
		int 현재페이지 = 10;
		
		
		Paging p = new Paging(현재페이지,총데이터,한번에보고싶은데이터갯수,한번에보여주고싶은페이지수);
		
		Assert.assertEquals(p.toString(), "");
	}
	
	@Test
	public void 테스트2(){
		int 총데이터 = 100;
		int 한번에보고싶은데이터갯수 = 10;
		int 한번에보여주고싶은페이지수 = 10;
		int 현재페이지 = 1;
		
		Paging p = new Paging(현재페이지,총데이터,한번에보고싶은데이터갯수,한번에보여주고싶은페이지수);
		
		Assert.assertEquals(p.toString(), "처음 1");
		
	}
	
	@Test
	public void 테스트3(){
		int 총데이터 = 100;
		int 한번에보고싶은데이터갯수 = 10;
		int 한번에보여주고싶은페이지수 = 10;
		int 현재페이지 = 10;
		
		Paging p = new Paging(현재페이지,총데이터,한번에보고싶은데이터갯수,한번에보여주고싶은페이지수);
		
		Assert.assertEquals(p.toString(), "처음 1,2,3,4,5,6,7,8,9,10");
		
	}

	@Test
	public void 테스트4(){
		int 총데이터 = 1000;
		int 한번에보고싶은데이터갯수 = 10;
		int 한번에보여주고싶은페이지수 = 10;
		int 현재페이지 = 101;
		
		Paging p = new Paging(현재페이지,총데이터,한번에보고싶은데이터갯수,한번에보여주고싶은페이지수);
		
		Assert.assertEquals(p.toString(), "");
	}
	
	@Test
	public void 테스트5(){
		int 총데이터 = 1000;
		int 한번에보고싶은데이터갯수 = 10;
		int 한번에보여주고싶은페이지수 = 10;
		int 현재페이지 = 98;
		
		Paging p = new Paging(현재페이지,총데이터,한번에보고싶은데이터갯수,한번에보여주고싶은페이지수);
		
		Assert.assertEquals(p.toString(), "처음 <91,92,93,94,95,96,97,98,99,100 마지막");
	}
	
	@Test
	public void 테스트6(){
		int 총데이터 = 1000;
		int 한번에보고싶은데이터갯수 = 10;
		int 한번에보여주고싶은페이지수 = 10;
		int 현재페이지 = 100;
		
		Paging p = new Paging(현재페이지,총데이터,한번에보고싶은데이터갯수,한번에보여주고싶은페이지수);
		
		Assert.assertEquals(p.toString(), "처음 <91,92,93,94,95,96,97,98,99,100");
	}
	
	/**
	 * 일반적으로 나와야하는 부분
	 */
	@Test
	public void 테스트7(){
		int 총데이터 = 1000;
		int 한번에보고싶은데이터갯수 = 10;
		int 한번에보여주고싶은페이지수 = 10;
		int 현재페이지 = 13;
		
		Paging p = new Paging(현재페이지,총데이터,한번에보고싶은데이터갯수,한번에보여주고싶은페이지수);
		
		Assert.assertEquals(p.toString(), "처음 <11,12,13,14,15,16,17,18,19,20> 마지막");
	}
	
	/**
	 * 일반적으로 나와야하는 부분, 페이지가 그 그룹에서 마지막일때
	 */
	@Test
	public void 테스트8(){
		int 총데이터 = 1000;
		int 한번에보고싶은데이터갯수 = 10;
		int 한번에보여주고싶은페이지수 = 10;
		int 현재페이지 = 20;
		
		Paging p = new Paging(현재페이지,총데이터,한번에보고싶은데이터갯수,한번에보여주고싶은페이지수);
		
		System.out.println(p.toString());
		Assert.assertEquals(p.toString(), "처음 <11,12,13,14,15,16,17,18,19,20> 마지막");
	}
	
}
