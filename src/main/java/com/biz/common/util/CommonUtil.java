package com.biz.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * 각종 공통 유틸 메소드
 * 
 * @author 엄승하
 */
public class CommonUtil {
	private static final Logger LOG = LoggerFactory.getLogger(CommonUtil.class);

	/**
	 * bean의 데이터를 다른 bean으로 복사 시키는 유틸 메소드
	 *  - 대상 데이터 bean에 존재하는 properties만 복사됨
	 * 
	 * @param oriDataBean 데이터가 담긴 원본 bean
	 * @param copyedBean name기반으로 복사되서 저장될 bean
	 */
	public static void copyTargetBeanData(Object oriDataBean, Object copyedBean) {

		try {
			BeanUtils.populate(copyedBean, BeanUtils.describe(oriDataBean));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new RuntimeException("copyTargetBeanData Exception");
		}
	}

	/**
	 * Ajax요청인지 판단
	 * 
	 * @param servletRequest
	 * @return
	 */
	public static boolean isAjaxReq(HttpServletRequest servletRequest) {

		String chkStr = servletRequest.getHeader("X-Requested-With");

		if (StringUtils.isEmpty(chkStr) == false && StringUtils.equals("xmlhttprequest", StringUtils.lowerCase(chkStr))) {
			return true;

		} else {
			return false;
		}

	}

	/**
	 * 클라이언트의 실제 IP를 가져옴(WAS 앞단에 L4등이 존재할 수 있음을 감안)
	 * 
	 * @param request HttpServletRequest
	 * @return
	 */
	public static String getClientIp(HttpServletRequest request) {

		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;

	}

	/**
	 * Spring Valid어노테이션에 체크된 에러의 메시지를 가져옴
	 * 
	 * @param result
	 * @param msgSeperator 에러가 여러개일 때 에러메시지 구분자
	 * @return
	 */
	public static String getErrMsgValidAnnotation(BindingResult result, String msgSeperator) {

		StringBuilder message = new StringBuilder("");

		// Validation 오류 발생시
		if (result.hasErrors()) {

			List<FieldError> errors = result.getFieldErrors();
			int errSize = errors.size();
			for (int i = 0; i < errSize; i++) {
				message.append(errors.get(i).getDefaultMessage());
				if (i != errSize - 1) {
					message.append(msgSeperator);
				}
			}
		}

		return message.toString();
	}

	/**
	 * 호스트명을 가져옴
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public static String getMyHostname() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostName();
	}

}
