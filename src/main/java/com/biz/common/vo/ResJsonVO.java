package com.biz.common.vo;

import com.biz.common.errorCd.ErrorCdInterface;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * 응답 공통용 VO
 *  - 값이 null인 필드는 응답에서 제외
 * 
 * @author 엄승하
 */
@Data
@JsonPropertyOrder({"success", "errorCd", "msg", "data"})
@JsonInclude(Include.NON_NULL)
public class ResJsonVO {

	private boolean success;
	private ErrorCdInterface errorCd;
	private String msg;

	/**
	 * 응답data 존재시 사용
	 *  - 어떤 타입의 데이터일지 알 수 없기 때문에 최상위타입인 Object클래스
	 */
	private Object data;

	public ResJsonVO() {
		super();
	}

	/**
	 * 생성자
	 *  - 단순 성공여부 및 메시지만 포함 
	 *  
	 * @param success
	 * @param msg
	 */
	public ResJsonVO(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	/**
	 * 생성자
	 *  - 에러코드 포함 
	 *  
	 * @param success
	 * @param errorCd
	 * @param msg
	 */
	public ResJsonVO(boolean success, ErrorCdInterface errorCd, String msg) {
		super();
		this.success = success;
		this.errorCd = errorCd;
		this.msg = msg;
	}

	/**
	 * 생성자
	 *  - 응답용 데이터 포함
	 * 
	 * @param success
	 * @param msg
	 * @param data
	 */
	public ResJsonVO(boolean success, String msg, Object data) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 생성자
	 *  - 전체 포함
	 * 
	 * @param success
	 * @param errorCd
	 * @param msg
	 * @param data
	 */
	public ResJsonVO(boolean success, ErrorCdInterface errorCd, String msg, Object data) {
		super();
		this.success = success;
		this.errorCd = errorCd;
		this.msg = msg;
		this.data = data;
	}
}
