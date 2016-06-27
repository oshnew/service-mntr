package com.biz.common.exception.heandler;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.biz.common.util.CommonUtil;

/**
 * Exception 발생시 후 처리가 필요한 내용 핸들러
 * 
 * @author 엄승하
 */
@EnableWebMvc
@ControllerAdvice
public class SystemExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(SystemExceptionHandler.class);

	/**
	 * 최상위 예외(Exception) 처리
	 *  - 에러로그를 남겨서 담당자에게 이메일 발송(logback에 설정 됨)하여 알 수 있도록 하기 위함  
	 *  
	 * @param ex
	 * @return
	 * @throws Exception 
	 */
	@ExceptionHandler(Exception.class)
	public void RootException(Exception ex) throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

		String reqIp = CommonUtil.getClientIp(request);
		LOG.error("ex message:{}, reqIp:{}, reqUri:{}, queryString:{}, parameters: {}, ex: ", ex.getMessage(), reqIp, request.getRequestURI(), request.getQueryString(),
			getRequestParam(request), ex);

		throw ex;
		//		return "redirect:" + "/error/serverError";

	}

	/**
	 * IOException 처리 핸들러
	 *  - client abort(요청 후 커넥션 타임아웃으로 끊는) 케이스가 많아서 로그레벨을 warn으로 조정 
	 *  
	 * @param ex
	 * @throws Exception
	 */
	@ExceptionHandler(IOException.class)
	public void IOException(Exception ex) throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

		String reqIp = CommonUtil.getClientIp(request);

		if (StringUtils.equals("ClientAbortException", ex.getClass().getSimpleName())) {
			LOG.warn("ex message:{}, reqIp:{}, reqUri:{}, queryString:{}, parameters: {}, ex: ", ex.getMessage(), reqIp, request.getRequestURI(), request.getQueryString(),
				getRequestParam(request), ex);
		} else {
			LOG.error("ex message:{}, reqIp:{}, reqUri:{}, queryString:{}, parameters: {}, ex: ", ex.getMessage(), reqIp, request.getRequestURI(), request.getQueryString(),
				getRequestParam(request), ex);
			throw ex;
		}
	}

	/**
	 * 허용되지 않는 HTTP 메소드 요청시 에러 핸들러
	 *  - 405가 아닌 403 권한없으로 리턴
	 *  
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> NotSupportMethodException(HttpRequestMethodNotSupportedException ex) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

		String reqIp = CommonUtil.getClientIp(request);
		LOG.warn("## 비 허용 HTTP 메소드 요청. reqIp:{}, reqUri:{}, queryString:{}", reqIp, request.getRequestURI(), request.getQueryString());

		return new ResponseEntity<String>("Not allow your request", HttpStatus.FORBIDDEN); //권한없음 코드로 리턴
	}

	/**
	 * 업로드 사이즈 오버시 발생 예외처리 핸들러
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(org.springframework.web.multipart.MaxUploadSizeExceededException.class)
	public String MaxUploadSizeExceededException(org.springframework.web.multipart.MaxUploadSizeExceededException ex) {

		return "common/error/overUploadSize";

	}

	/**
	 * 요청 파라미터들을 리턴
	 * 
	 * @param request
	 * @return
	 */
	private String getRequestParam(HttpServletRequest request) {

		StringBuffer strBuff = new StringBuffer();
		if (request != null && request.getParameterNames() != null) {
			Enumeration params = request.getParameterNames();

			while (params.hasMoreElements()) {
				String names = (String)params.nextElement();
				strBuff.append(names);
				strBuff.append(":");
				strBuff.append(request.getParameter(names));
				strBuff.append(", ");
			}
		}

		return strBuff.toString();
	}

}
