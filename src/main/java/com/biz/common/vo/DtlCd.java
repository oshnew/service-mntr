package com.biz.common.vo;

import lombok.Data;

/**
 * 공통 상세코드 모델
 * 
 * @author 엄승하
 */
@Data
public class DtlCd {
	String grpCd;
	String grpCdNm;
	String dtlCd;
	String dtlCdNm;
	int sort;
}
