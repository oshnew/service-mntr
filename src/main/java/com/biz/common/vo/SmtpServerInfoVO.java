package com.biz.common.vo;

import lombok.Data;

/**
 * 시스템에서 공통으로 사용하는 이메일 SMTP서버 정보 VO
 * 
 * @author 엄승하
 */
@Data
public class SmtpServerInfoVO {
	private String host;
	private int port;
	private String id;
	private String passwd;
	private String fromEmail;
	private String fromName;
}