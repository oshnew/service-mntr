package com.biz.common.cd;

import org.apache.commons.lang3.StringUtils;

/**
 * 서비스 환경 코드 정의
 *  - propertis에 환경별로 변수가 담겨져 있음
 * 
 * @author 엄승하
 */
public enum EnvCd {
	local("로컬 개발환경"), alpha("알파 개발환경"), beta("베타 테스트환경"), qa("QA 환경"), real("리얼 서비스환경");

	private String cdNm;

	private EnvCd(String cdNm) {
		this.cdNm = cdNm;
	}

	public String getCdNm() {
		return cdNm;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	/**
	 * 동일 envCd인지 확인
	 *  - 입력받은 문자는 대문자로 치환하여 체크
	 * 
	 * @param strEnvCd
	 * @return
	 */
	public boolean isEqualEnv(String strEnvCd) {
		return StringUtils.equals(this.toString().toUpperCase(), strEnvCd.toUpperCase()); //모두 대문자 처리해서 비교(대소문자 섞어쓰는 부분때문)
	}

}
