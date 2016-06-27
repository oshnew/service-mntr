package com.biz.common.errorCd;

/**
 * 공통으로 사용하는 에러 코드
 * 
 * @author 엄승하
 */
public interface ErrorCdInterface {

	public abstract String getCd();;

	public abstract String getMsg(String addMsg);

}
