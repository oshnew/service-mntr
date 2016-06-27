package com.biz.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  도메인 웰컴 페이징
 *  
 * @author 엄승하
 */
@Controller
public class Welcome {
	private static final Logger LOG = LoggerFactory.getLogger(Welcome.class);

	@RequestMapping(value = "/")
	public String indexPage() {
		return "redirect:" + "/main";
	}

}
