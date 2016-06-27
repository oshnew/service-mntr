package com.biz.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  메인 페이지
 *  
 * @author 엄승하
 */
@Controller
public class Main {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	/**
	 * 메인 페이지 리턴
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main")
	public ResponseEntity<String> main() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		return new ResponseEntity<String>("메인페이지입니다.", responseHeaders, HttpStatus.CREATED);
	}

	//	@RequestMapping(value = "/main")
	//	public String main() {
	//		return "dashboard/dashboard";
	//	}
}
