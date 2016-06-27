package com.biz.common;

import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import com.biz.common.util.CommonUtil;

/**
 * 상수 클래스
 * 
 * @author 엄승하
 */
@Component
public class ConstantsCommon {
	private static final Logger LOG = LoggerFactory.getLogger(ConstantsCommon.class);

	@Autowired
	private MessageSourceAccessor ms;

	/** 시스템의 현재 환경코드(ex. local, alpha, beta, qa, real)  */
	public static String ENV_CD;

	/** 구분자 : 파이프(|)  */
	public static final String SEPERATOR_PIPE = "|";

	/** 구분자 : 콤마(,)  */
	public static final String SEPERATOR_COMMA = ",";

	/** 구분자 : 세미콜론(;)  */
	public static final String SEPERATOR_SEMI_COLON = ";";

	/** 구분자 : 등호(=)  */
	public static final String SEPERATOR_EQUALS = "=";

	/** 구분자 : 콜론(:)  */
	public static final String SEPERATOR_COLON = ":";

	/** 구분자 : 앤드(&)  */
	public static final String SEPERATOR_AND = "&";

	/** 스트링 : system  */
	public static final String STR_system = "system";

	/**
	 * 초기화 메소드
	 * 
	 * @throws UnknownHostException 
	 */
	@PostConstruct
	private void init() throws UnknownHostException {

		ENV_CD = ms.getMessage("env");

		String hostname = CommonUtil.getMyHostname();
		String port = System.getProperty("server.port"); //톰캣 실행시 프로퍼티로 셋팅
		if (StringUtils.isAnyBlank(hostname, port)) {
			LOG.error("Error. 호스트명 또는 톰캣포트. hostname:{}   port:{}", hostname, port);
			System.exit(-1); //필수값이라서 프로세스 종료
		}

		if (NumberUtils.isDigits(port) == false) {
			LOG.error("Error. 포트번호가 숫자가 아님. port:{}", port);
			System.exit(-1);
		}

		LOG.info("\n\n ENV_CD:{}\n hostname:{}\n port:{}\n", ENV_CD, hostname, port);
	}

}
