package com.biz.common.vo;

import lombok.Data;

/**
 * 페이징 공통관련 VO
 * 
 * @author 엄승하
 */
@Data
public class PagingCommonVO {
	
	/** 현재페이지 */
    private int pageIndex = 1;

    /** 페이지 네비게이션 사이즈 */
    private int pageSize = 10;

    /** 첫페이지 인덱스 */
    private int firstIndex = 1;

    /** 마지막페이지 인덱스 */
    private int lastIndex = 1;

    /** 페이지에 보여줄 데이터 갯수 */
    private int recordCountPerPage = 20;

    /** 검색 제한 레코드 시작 위치 */
//    private int limitOffSet = 1;
    
    public int getPageIndex() {
    	if(pageIndex==0){ //값 셋팅없이 사용되는 경우(페이지 최초 접근)
    		return 1;
    	}else {
    		return pageIndex;
    	}
	}

	public int getLimitOffSet() {
		return (pageIndex - 1) * recordCountPerPage;
	}
    
    


}
