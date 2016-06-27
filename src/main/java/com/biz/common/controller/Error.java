package com.biz.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 공통 에러 페이지 컨트롤러
 * 
 * @author 엄승하  
 */
@Controller
@RequestMapping("/error")
public class Error {

	/**
	 * 페이지 찾을 수 없음
	 * 
	 * @return
	 */
	@RequestMapping(value = "/notFound")
	public String notFound() {
		return "common/error/notFound";
	}

	/**
	 * 권한없음
	 * 
	 * @return
	 */
	@RequestMapping(value = "/notAuth")
	public String notAuth() {
		return "common/error/notAuth";
	}

	/**
	 * 서버에러
	 * 
	 * @return
	 */
	@RequestMapping(value = "/serverError")
	public String serverError() {
		return "common/error/serverError";
	}

}
