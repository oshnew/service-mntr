package com.biz.common.errorCd;

import java.util.Locale;

/**
 * 공통으로 사용하는 에러 코드
 * 
 * @author 엄승하
 */
public enum ErrorCdCommon implements ErrorCdInterface {
	SYSTEM_ERROR("SYSTEM_ERROR", "시스템 에러", "An error occurred in the server"),
	SYSTEM_MAINTENANCE("SYSTEM_MAINTENANCE", "시스템 점검 중", "System is under maintenance"),
	NOT_EXIST_DATA("NOT_EXIST_DATA", "데이터 없음", "Not exist data"),
	ALREADY_EXIST_DATA("ALREADY_EXIST_DATA", "이미 데이터가 존재함", "Already exist data");

	private String cd;
	private String cdNm;
	private String msg;

	private ErrorCdCommon(String cd, String cdNm, String msg) {
		this.cd = cd;
		this.cdNm = cdNm;
		this.msg = msg;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCdNm() {
		return cdNm;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	public String getMsg() {
		return msg;
	}

	public String getMsg(String addMsg) {
		return msg + " : " + addMsg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static ErrorCdCommon fromString(String value) {

		try {
			return ErrorCdCommon.valueOf(value.toUpperCase(Locale.US));
		} catch (Exception e) {
			throw new IllegalArgumentException(String.format("Invalid value '%s' for given! (case insensitive).", value), e);
		}
	}

}
